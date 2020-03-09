package dustlet;

//     Dust - a simple particle system for wind visualization
//     Copyright 1999,2005  Nick Thompson
//     see http://nixfiles.com/dust for more information
//
//     This program is free software; you can redistribute it and/or modify
//     it under the terms of the GNU General Public License as published by
//     the Free Software Foundation; either version 2 of the License, or
//     (at your option) any later version.
//
//     This program is distributed in the hope that it will be useful,
//     but WITHOUT ANY WARRANTY; without even the implied warranty of
//     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//     GNU General Public License for more details.
//
//     You should have received a copy of the GNU General Public License
//     along with this program; if not, write to the Free Software
//     Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.

//
// the following info is courtesy of Chad English at USGS:
//
// Date: Wed, 21 Jul 1999 15:50:34 -0700
// From: SF Bay Wind Patterns <wind@sfports.wr.usgs.gov>
// Organization: US Geological Survey, Menlo Park
// Subject: Re: Raw Wind Data (text file)
//
//   ...
// The data we use to generate the most recent graphics
// are available in the file
//   http://sfports.wr.usgs.gov/~wind/windsuv.dat   XXX/nix .out is better?
// (which is updated every hour).  The file is two
// 108x123 grids.  The first 123 lines are the
// u-components (west-east) of the velocity and the
// last 123 lines are the v-components (south-north).
// The units are knots.
//
// For registering the data (to a map):  The grid cells
// are 1km x 1km and coordinates for the south-west
// corner of the grid are: 
//         37.30000N, 122.72000W (lat,lon) 
//         524.5000   4134.000   (UTM)
//
//  ...
//

import java.awt.Color;
import java.awt.Graphics;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.StreamTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Dust
{
  int nmotes;
  private boolean withDustColor = false;

  // nasty bunch of arrays rather than an array of Mote objects
  // because i am aiming for speed rather than shapeliness.
  double[] xmotes;
  double[] ymotes;
  int[] ttlmotes;

  // 3x2 matrix mapping x/y (row vector) to vector field indices
  // map <xmin,ymin> -> <0,0> and <xmax,ymax> -> <xsize,ysize>
  // the units for worldspace are kilometers
  double[] world_to_field;

  // 3x2 matrix mapping x/y (row vector) to view space (pixels)
  // try to map <xmin,ymin> -> <0,0> and <xmax,ymax> -> <nxpixels,nypixels>
  //  XXX but preserve aspect ratio
  double[] world_to_view;

  int xsize;
  int ysize;
  double xmin;
  double ymin;
  double xmax;
  double ymax;
  double[] us;
  double[] vs;

  Dust(int nmotes)
  {
    init(nmotes);
    uvscale = 10.0;
  }

  double uvscale;

  void init(int nmotes)
  {
    int i;

    this.nmotes = nmotes;

    xmotes = new double[nmotes];
    ymotes = new double[nmotes];
    ttlmotes = new int[nmotes];

    for (i = 0; i < nmotes; i++)
    {
      ttlmotes[i] = 0;
    }
  }

  void set_pixel_size(int nxpixels, int nypixels)
  {
    // try to map <xmin,ymin> -> <0,0>
    //        and <xmax,ymax> -> <nxpixels,nypixels>
    // XXX BUT preserve aspect ratio
    world_to_view = new double[6];
    world_to_view[0] = nxpixels / (xmax - xmin);
    world_to_view[1] = 0.0;
    world_to_view[2] = 0.0;
    world_to_view[3] = nypixels / (ymax - ymin);
    world_to_view[4] = -xmin * world_to_view[0];
    world_to_view[5] = -ymin * world_to_view[3];
  }

  void read_windfile(InputStream in, int width, int height)
    throws IOException
  {
    xsize = width;
    ysize = height;
    xmin = 0;
    xmax = width - 1;
    ymin = 0;
    ymax = height;

    uvscale = 0.1;

    // map <xmin,ymin> -> <0,0> and <xmax,ymax> -> <xsize,ysize>
    world_to_field = new double[6];
    world_to_field[0] = xsize / (xmax - xmin);
    world_to_field[1] = 0.0;
    world_to_field[2] = 0.0;
    world_to_field[3] = ysize / (ymax - ymin);
    world_to_field[4] = -xmin * world_to_field[0];
    world_to_field[5] = -ymin * world_to_field[3];

    us = new double[xsize * ysize];
    vs = new double[xsize * ysize];

    Reader r = new BufferedReader(new InputStreamReader(in));
    StreamTokenizer toker = new StreamTokenizer(r);    
//  StreamTokenizer toker = new StreamTokenizer(in);
    toker.eolIsSignificant(true);

    read_array(toker, us, 1.0);
    read_array(toker, vs, -1.0);
  }

  void read_array(StreamTokenizer toker, double[] array, double scale)
    throws IOException
  {
    boolean eof = false;
    int ix = 0;
    int iy = 0;
    int line = 0;

    while (!eof)
    {
      int token = toker.nextToken();
      switch (token)
      {
        case StreamTokenizer.TT_EOF:
          if (iy < ysize - 1)
          {
            throw new IOException("early end of file at line " + line + "(iy:" + iy + ", ysize:" + ysize + ")");
          }
          eof = true;
          break;
        case StreamTokenizer.TT_EOL:
          if (ix != xsize)
          {
            throw new IOException("early end of line " + line + "(ix:" + ix + ", xsize:" + xsize + ")");
          }
          if (iy < ysize - 1)
          {
            ix = 0;
            iy++;
          }
          else
          {
            // should be last newline in the file
            ix = 0;
            iy++;
            return;
          }
          line++;
          break;
        case StreamTokenizer.TT_NUMBER:
          // System.err.println(ix + "," + iy + " <-- " + toker.nval);
          if (ix >= xsize)
          {
            throw new IOException("too many numbers in line " + line);
          }
          else if (iy >= ysize)
          {
            throw new IOException("too many rows, line " + line);
          }
          array[iy * xsize + ix] = scale * toker.nval;
          ix++;
          break;
        default:
          throw new IOException("unexpected token in line " + line);
      }
    }
  }

  // returns true if x,y is valid, false otherwise

  boolean lookup_uv(double x, double y, double[] uv)
  {
    double fx = world_to_field[0] * x + world_to_field[2] * y + world_to_field[4];
    double fy = world_to_field[1] * x + world_to_field[3] * y + world_to_field[5];
    int ix = (int) fx;
    int iy = (int) fy;
    double tx = fx - ix;
    double ty = fy - iy;

    // ensure      0 <= ix,iy < xsize,ysize
    if (ix < 0 || iy < 0 || ix >= xsize - 1 || iy >= ysize - 1)
      return false;

    int index = iy * xsize + ix;

    // bilinear interpolation
    double u0 = (1 - tx) * us[index] + tx * us[index + 1];
    double u1 = (1 - tx) * us[index + xsize] + tx * us[index + xsize + 1];
    uv[0] = uvscale * ((1 - ty) * u0 + ty * u1);

    double v0 = (1 - tx) * vs[index] + tx * vs[index + 1];
    double v1 = (1 - tx) * vs[index + xsize] + tx * vs[index + xsize + 1];
    uv[1] = uvscale * ((1 - ty) * v0 + ty * v1);

    return true;
  }

  public void withDustColor(boolean b)
  {
    withDustColor = b;
  }

  void drawmotes(Graphics g)
  {
    double min = Double.MAX_VALUE, max = 0d;
    
    for (int i = 0; i < nmotes; i++)
    {
      double x = xmotes[i];
      double y = ymotes[i];
      double vx = world_to_view[0] * x + world_to_view[2] * y + world_to_view[4];
      double vy = world_to_view[1] * x + world_to_view[3] * y + world_to_view[5];
      // XXX try an image here?  or a line showing velocity?
      double[] uv = new double[2];
      lookup_uv(x, y, uv);
      // Set the color from the wind...
      double len = Math.sqrt((uv[0] * uv[0]) + (uv[1] * uv[1]));
      min = Math.min(min, len);
      max = Math.max(max, len);
      if (withDustColor)
        setDustColor(g, len);
      else
        g.setColor(Color.green);
      g.drawLine((int) vx, (int) vy, (int) (vx + uv[0]), (int) (vy + uv[1]));
      //	    System.err.println("mote at "+x+","+y+"  --> "+vx+","+vy);
    }
    System.out.println("Min len:" + min + ", max len:" + max);
  }

  private void setDustColor(Graphics g, double len) // TODO Introduce the Wind Factor (default: 5)
  {
    Color c;
    double speed = len * 5;
//    if (speed < (double)5)
//      c = new Color(225, 183, 183);
//    else if (speed >= (double)5 && speed < (double)10)
//      c = new Color(224, 142, 142);
//    else if (speed >= (double)10 && speed < (double)15)
//      c = new Color(223, 105, 105);
//    else if (speed >= (double)15 && speed < (double)20)
//      c = new Color(225, 45, 45);
//    else  if (speed >= (double)20 && speed < (double)25)
//      c = new Color(204, 18, 18);
//    else if (speed >= (double)25 && speed < (double)30)
//      c = new Color(155, 9, 9);
//    else if (speed >= (double)30 && speed < (double)35)
//      c = new Color(115, 5, 5);
//    else if (speed >= (double)35 && speed < (double)40)
//      c = new Color(83, 3, 3);
//    else if (speed >= (double)40 && speed < (double)45)
//      c = new Color(50, 2, 2);
//    else if (speed >= (double)45 && speed < (double)50)
//      c = new Color(37, 1, 1);
//    else
//      c = new Color(0, 0, 0);
    c = getWindColor((int)speed);
    g.setColor(c);
  }

  final private static Color[] colorfield = new Color[]
  {
    Color.white,             // 0-5
    new Color(21, 200, 232), // Blue 5-10
    new Color(19, 234, 186), // Lighter blue 10-15
    new Color(48, 232, 21),  // Green 15-20
    new Color(211, 239, 14), // Yellow 20-25
    new Color(232, 180, 21), // Orange 25-30
    new Color(232, 100, 21), // Darker Orange 30-35
    new Color(180, 8, 0),    // Red 35-40
    new Color(147, 4, 0),    // Dark red 40-45
    new Color(148, 4, 161)   // Purple 45-
  };
  
  public static Color getWindColor(float w)
  {
    int i = (int)w;
    int colorIdx = (int)(i / 5d);
    if (colorIdx > colorfield.length - 1) colorIdx = colorfield.length - 1;
    return colorfield[colorIdx];
  }
  
  void stepmotes(double stepsize)
  {
    int i;
    double[] uv = new double[2];

    double step = stepsize;

    for (i = 0; i < nmotes; i++)
    {
      // randomize the mote if it is too old or out-of-bounds
      if (--ttlmotes[i] < 1 || !lookup_uv(xmotes[i], ymotes[i], uv))
      {

        xmotes[i] = (xmax - xmin) * Math.random() + xmin;
        ymotes[i] = (ymax - ymin) * Math.random() + ymin;
        //                xmotes[i] = Math.random();
        //                ymotes[i] = Math.random();
        ttlmotes[i] = (int) (100 * Math.random());
      }
      else
      {
        xmotes[i] += step * uv[0];
        ymotes[i] += step * uv[1];
      }
    }
  }
}
