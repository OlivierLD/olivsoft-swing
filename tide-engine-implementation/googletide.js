var option = 1;
var lat2plot = 30.4667;
var lng2plot = 130.5;
var stations = new Array (
  {name:"Isso, Kagosima, Japan",
   type:"T",
   latitude:"30.4667",
   longitude:"130.5"}
  ,
  {name:"Mobile (Mobile State Docks), Alabama",
   type:"T",
   latitude:"30.705",
   longitude:"-88.0367"}
  ,
  {name:"Sumiyo Wan, Kagosima, Japan",
   type:"T",
   latitude:"28.2333",
   longitude:"129.417"}
  ,
  {name:"Inward Rocks, River Severn, England",
   type:"T",
   latitude:"51.65",
   longitude:"-2.6167"}
  ,
  {name:"Borrowman Bay, British Columbia (2)",
   type:"T",
   latitude:"52.7333",
   longitude:"-129.2833"}
  ,
  {name:"Kusudomari, Nagasaki, Japan",
   type:"T",
   latitude:"33.2167",
   longitude:"129.583"}
  ,
  {name:"Pacofi Bay, British Columbia (2)",
   type:"T",
   latitude:"52.8333",
   longitude:"-131.8833"}
  ,
  {name:"Hartley Bay, British Columbia (2)",
   type:"T",
   latitude:"53.4333",
   longitude:"-129.25"}
  ,
  {name:"Phoenix Park, Florida (4)",
   type:"T",
   latitude:"30.3833",
   longitude:"-81.6367"}
  ,
  {name:"Nymphe Cove, British Columbia",
   type:"T",
   latitude:"50.1333",
   longitude:"-125.3667"}
  ,
  {name:"St. Andrews, Passamaquoddy Bay, New Brunswick",
   type:"T",
   latitude:"45.0667",
   longitude:"-67.05"}
  ,
  {name:"Irvines Landing, British Columbia",
   type:"T",
   latitude:"49.6333",
   longitude:"-124.05"}
  ,
  {name:"Port Eyre, Australia",
   type:"T",
   latitude:"-32.0",
   longitude:"132.45"}
  ,
  {name:"Yabooma Island, Australia",
   type:"T",
   latitude:"-11.9667",
   longitude:"134.9"}
  ,
  {name:"Goose Island, British Columbia",
   type:"T",
   latitude:"52.0",
   longitude:"-128.4167"}
  ,
  {name:"Hakodate, Hokkaido, Japan (2)",
   type:"T",
   latitude:"41.7833",
   longitude:"140.7167"}
  ,
  {name:"Fresh Creek, Andros Island, Bahamas",
   type:"T",
   latitude:"24.7333",
   longitude:"-77.8"}
  ,
  {name:"Mys Kapuetnyi, Kurile Islands",
   type:"T",
   latitude:"50.0667",
   longitude:"155.217"}
  ,
  {name:"Grassy Key (North), Florida",
   type:"T",
   latitude:"24.7667",
   longitude:"-80.9333"}
  ,
  {name:"Ako (Miyake Sima), Tokyo, Japan",
   type:"T",
   latitude:"34.0667",
   longitude:"139.483"}
  ,
  {name:"Owen Bay, British Columbia",
   type:"T",
   latitude:"50.3167",
   longitude:"-125.2167"}
  ,
  {name:"Inoucdjouac, Québec",
   type:"T",
   latitude:"58.45",
   longitude:"-78.1"}
  ,
  {name:"Boutilier Point, Nova Scotia",
   type:"T",
   latitude:"44.65",
   longitude:"-63.95"}
  ,
  {name:"Ucluelet, British Columbia (2)",
   type:"T",
   latitude:"48.95",
   longitude:"-125.55"}
  ,
  {name:"Casablanca, Morocco",
   type:"T",
   latitude:"33.6",
   longitude:"-7.6"}
  ,
  {name:"Mokuoloe, Kaneohe Bay, Oahu Island, Hawaii (2)",
   type:"T",
   latitude:"21.435",
   longitude:"-157.7917"}
  ,
  {name:"Northport, Northport Bay, Long Island Sound, New York",
   type:"T",
   latitude:"40.9",
   longitude:"-73.35"}
  ,
  {name:"Leith, Scotland (2)",
   type:"T",
   latitude:"55.9833",
   longitude:"-3.1667"}
  ,
  {name:"Ingomar, Nova Scotia",
   type:"T",
   latitude:"43.5667",
   longitude:"-65.3333"}
  ,
  {name:"Kasiwazaki (Ehime), Ehime, Japan",
   type:"T",
   latitude:"33.0167",
   longitude:"132.483"}
  ,
  {name:"Motuoini, Tahiti",
   type:"T",
   latitude:"-17.75",
   longitude:"-140.3667"}
  ,
  {name:"Rikitea, Gambier Islands",
   type:"T",
   latitude:"-23.1167",
   longitude:"-134.9667"}
  ,
  {name:"Lifuka, Ha`apai Group, Tonga",
   type:"T",
   latitude:"-19.8",
   longitude:"-174.3333"}
  ,
  {name:"Fortescue Road, Australia",
   type:"T",
   latitude:"-21.0",
   longitude:"116.1"}
  ,
  {name:"Iwaguro, Yamaguti, Japan",
   type:"T",
   latitude:"33.9667",
   longitude:"130.983"}
  ,
  {name:"Uragami, Wakayama, Japan",
   type:"T",
   latitude:"33.55",
   longitude:"135.9"}
  ,
  {name:"Izumi-Otu, Osaka, Japan",
   type:"T",
   latitude:"34.5",
   longitude:"135.4"}
  ,
  {name:"Shale Island, Australia",
   type:"T",
   latitude:"-16.3833",
   longitude:"124.3333"}
  ,
  {name:"Magosaki, Tokusima, Japan",
   type:"T",
   latitude:"34.2333",
   longitude:"134.65"}
  ,
  {name:"Sarasota, Sarasota Bay, Florida",
   type:"T",
   latitude:"27.3317",
   longitude:"-82.545"}
  ,
  {name:"Hon Nieu, Vietnam",
   type:"T",
   latitude:"18.8",
   longitude:"105.7667"}
  ,
  {name:"No Man's Land, Massachusetts",
   type:"T",
   latitude:"41.2617",
   longitude:"-70.8183"}
  ,
  {name:"Sungai Barito, Borneo, Indonesia",
   type:"T",
   latitude:"-3.5667",
   longitude:"114.4833"}
  ,
  {name:"Abott Harbour, Nova Scotia",
   type:"T",
   latitude:"43.6667",
   longitude:"-65.8167"}
  ,
  {name:"Blubber Bay (Powell River Approaches), British Columbia",
   type:"T",
   latitude:"49.8",
   longitude:"-124.6167"}
  ,
  {name:"Kaligola Point, Papua New Guinea (2)",
   type:"T",
   latitude:"-10.15",
   longitude:"148.2667"}
  ,
  {name:"Port Turton, Australia",
   type:"T",
   latitude:"-34.9333",
   longitude:"137.35"}
  ,
  {name:"Jabiru, Australia",
   type:"T",
   latitude:"-11.8333",
   longitude:"125.2"}
  ,
  {name:"Nikiski, Cook Inlet, Alaska",
   type:"T",
   latitude:"60.6833",
   longitude:"-151.3967"}
  ,
  {name:"Shoal Tickle, Labrador",
   type:"T",
   latitude:"55.7667",
   longitude:"-60.3667"}
  ,
  {name:"Morse Basin, British Columbia (2)",
   type:"T",
   latitude:"54.25",
   longitude:"-130.2333"}
  ,
  {name:"Weynton Passage, British Columbia Current",
   type:"C",
   latitude:"50.6033",
   longitude:"-126.8117"}
  ,
  {name:"Kawana, Sizuoka, Japan",
   type:"T",
   latitude:"34.95",
   longitude:"139.133"}
  ,
  {name:"Haneda, Tokyo, Japan",
   type:"T",
   latitude:"35.55",
   longitude:"139.767"}
  ,
  {name:"Sakai (Tottori), Tottori, Japan",
   type:"T",
   latitude:"35.55",
   longitude:"133.25"}
  ,
  {name:"Alice Arm, British Columbia",
   type:"T",
   latitude:"55.4667",
   longitude:"-129.5"}
  ,
  {name:"Talara, Peru",
   type:"T",
   latitude:"-4.5833",
   longitude:"-81.2833"}
  ,
  {name:"Finnerty Cove, British Columbia",
   type:"T",
   latitude:"48.4667",
   longitude:"-123.3"}
  ,
  {name:"Mellish Reef, Coral Sea",
   type:"T",
   latitude:"-17.4167",
   longitude:"155.8667"}
  ,
  {name:"Sakata, Yamagata, Japan",
   type:"T",
   latitude:"38.9167",
   longitude:"139.833"}
  ,
  {name:"Aberdeen, Washington (3)",
   type:"T",
   latitude:"46.967",
   longitude:"-123.85"}
  ,
  {name:"Noosa Head, Australia",
   type:"T",
   latitude:"-26.3833",
   longitude:"153.1"}
  ,
  {name:"Thistle Island, Australia",
   type:"T",
   latitude:"-34.95",
   longitude:"136.35"}
  ,
  {name:"Port Castries, St. Lucia",
   type:"T",
   latitude:"14.0167",
   longitude:"-61.0"}
  ,
  {name:"Squamish, British Columbia (2)",
   type:"T",
   latitude:"49.7",
   longitude:"-123.15"}
  ,
  {name:"Flinders Bay, Australia",
   type:"T",
   latitude:"-34.3333",
   longitude:"115.1667"}
  ,
  {name:"Cape Canaveral, Florida",
   type:"T",
   latitude:"28.4333",
   longitude:"-80.5667"}
  ,
  {name:"St. Anthony, Newfoundland",
   type:"T",
   latitude:"51.3667",
   longitude:"-55.5833"}
  ,
  {name:"Block Islands, British Columbia (2)",
   type:"T",
   latitude:"53.15",
   longitude:"-129.7667"}
  ,
  {name:"Yanagi-No-Seto, Kumamoto, Japan",
   type:"T",
   latitude:"32.5333",
   longitude:"130.417"}
  ,
  {name:"Sekiu, Washington",
   type:"T",
   latitude:"48.2667",
   longitude:"-124.3"}
  ,
  {name:"Nagasaki Megami, Nagasaki, Japan",
   type:"T",
   latitude:"32.7167",
   longitude:"129.85"}
  ,
  {name:"Morris Island, Australia",
   type:"T",
   latitude:"-13.4833",
   longitude:"143.7167"}
  ,
  {name:"Wagina Island, Solomon Islands",
   type:"T",
   latitude:"-7.4667",
   longitude:"157.7333"}
  ,
  {name:"Mingan, Québec",
   type:"T",
   latitude:"50.2833",
   longitude:"-64.0167"}
  ,
  {name:"Mino, Hirosima, Japan",
   type:"T",
   latitude:"34.25",
   longitude:"132.383"}
  ,
  {name:"Surge Narrows, British Columbia (2)",
   type:"T",
   latitude:"50.2167",
   longitude:"-125.1167"}
  ,
  {name:"Aomori, Aomori, Japan",
   type:"T",
   latitude:"40.8333",
   longitude:"140.767"}
  ,
  {name:"Mitlenatch Island, British Columbia (2)",
   type:"T",
   latitude:"49.95",
   longitude:"-125.0"}
  ,
  {name:"Madras, India",
   type:"T",
   latitude:"13.1",
   longitude:"80.3"}
  ,
  {name:"Cloridorme, Québec",
   type:"T",
   latitude:"49.1833",
   longitude:"-64.8333"}
  ,
  {name:"Philadelphia, Municipal Pier 11, Pennsylvania",
   type:"T",
   latitude:"39.9517",
   longitude:"-75.135"}
  ,
  {name:"Savannah River Entrance, Georgia Current (2) (expired 1999-12-31)",
   type:"C",
   latitude:"32.0367",
   longitude:"-80.8583"}
  ,
  {name:"East Sandy Cove, Nova Scotia",
   type:"T",
   latitude:"44.4833",
   longitude:"-66.0833"}
  ,
  {name:"Montauk Point, Long Island Sound, New York",
   type:"T",
   latitude:"41.0717",
   longitude:"-71.8567"}
  ,
  {name:"Sandy Point, Nova Scotia",
   type:"T",
   latitude:"43.7",
   longitude:"-65.3333"}
  ,
  {name:"Port-Tudy, France",
   type:"T",
   latitude:"47.65",
   longitude:"-3.45"}
  ,
  {name:"Sooma, Fukusima, Japan",
   type:"T",
   latitude:"37.8333",
   longitude:"140.967"}
  ,
  {name:"City Island, New York",
   type:"T",
   latitude:"40.85",
   longitude:"-73.7833"}
  ,
  {name:"Vineyard Haven, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.45",
   longitude:"-70.6"}
  ,
  {name:"Dedele Point, Papua New Guinea",
   type:"T",
   latitude:"-10.2333",
   longitude:"148.7167"}
  ,
  {name:"Swim Point, Nova Scotia",
   type:"T",
   latitude:"43.4333",
   longitude:"-65.6333"}
  ,
  {name:"Deception Pass, Washington Current",
   type:"C",
   latitude:"48.4",
   longitude:"-122.6333"}
  ,
  {name:"Hyperite Point, Nunavut",
   type:"T",
   latitude:"78.1333",
   longitude:"-88.8833"}
  ,
  {name:"Kwajalein Atoll, Marshall Islands (2)",
   type:"T",
   latitude:"8.7333",
   longitude:"167.7333"}
  ,
  {name:"St. Augustine, city dock, Florida",
   type:"T",
   latitude:"29.8917",
   longitude:"-81.31"}
  ,
  {name:"Akkesi Ko, Hokkaido, Japan",
   type:"T",
   latitude:"43.0333",
   longitude:"144.867"}
  ,
  {name:"Portugal Cove, Newfoundland",
   type:"T",
   latitude:"47.6167",
   longitude:"-52.8667"}
  ,
  {name:"Suttu, Hokkaido, Japan",
   type:"T",
   latitude:"42.7833",
   longitude:"140.267"}
  ,
  {name:"Granby Bay, British Columbia (2)",
   type:"T",
   latitude:"55.4167",
   longitude:"-129.8"}
  ,
  {name:"Sunday Island, Australia",
   type:"T",
   latitude:"-16.3833",
   longitude:"123.1833"}
  ,
  {name:"Sakaide, Kagawa, Japan",
   type:"T",
   latitude:"34.3167",
   longitude:"133.85"}
  ,
  {name:"Ostrov Ushishir, Kurile Islands",
   type:"T",
   latitude:"47.5333",
   longitude:"152.817"}
  ,
  {name:"Portland, England",
   type:"T",
   latitude:"50.5667",
   longitude:"-2.4333"}
  ,
  {name:"Wallaroo, Australia (2)",
   type:"T",
   latitude:"-33.9",
   longitude:"137.6"}
  ,
  {name:"Tomakomai, Hokkaido, Japan",
   type:"T",
   latitude:"42.6333",
   longitude:"141.633"}
  ,
  {name:"Harrington Inlet, Australia",
   type:"T",
   latitude:"-31.8667",
   longitude:"152.6833"}
  ,
  {name:"Ilha Guaíba, Brazil",
   type:"T",
   latitude:"-23.0",
   longitude:"-44.0333"}
  ,
  {name:"Matugae, Nagasaki, Japan",
   type:"T",
   latitude:"32.7333",
   longitude:"129.867"}
  ,
  {name:"Saigo, Simane, Japan",
   type:"T",
   latitude:"36.2",
   longitude:"133.333"}
  ,
  {name:"St. Johns River at Navy degaussing structure, Florida (2)",
   type:"T",
   latitude:"30.3964",
   longitude:"-81.3953"}
  ,
  {name:"Pearce Point, Nunavut/NWT",
   type:"T",
   latitude:"69.8167",
   longitude:"-122.0667"}
  ,
  {name:"Davis Strait, Nunavut (3)",
   type:"T",
   latitude:"66.2667",
   longitude:"-56.7667"}
  ,
  {name:"American River, Australia",
   type:"T",
   latitude:"-35.8",
   longitude:"137.7667"}
  ,
  {name:"Cabot Point, Labrador",
   type:"T",
   latitude:"53.7167",
   longitude:"-59.0333"}
  ,
  {name:"Phoenix Park, Florida (2)",
   type:"T",
   latitude:"30.3833",
   longitude:"-81.6367"}
  ,
  {name:"Kazusa-Katuura, Tiba, Japan",
   type:"T",
   latitude:"35.1333",
   longitude:"140.25"}
  ,
  {name:"Cape Hatteras (fishing pier), North Carolina",
   type:"T",
   latitude:"35.2233",
   longitude:"-75.635"}
  ,
  {name:"Goold Island, Australia (2)",
   type:"T",
   latitude:"-18.1667",
   longitude:"146.1833"}
  ,
  {name:"Kwinitsa Creek, British Columbia (2)",
   type:"T",
   latitude:"54.2167",
   longitude:"-129.5833"}
  ,
  {name:"False Bay, British Columbia",
   type:"T",
   latitude:"49.5",
   longitude:"-124.35"}
  ,
  {name:"Port Mouton, Nova Scotia",
   type:"T",
   latitude:"43.9333",
   longitude:"-64.85"}
  ,
  {name:"Aba, Nagasaki, Japan",
   type:"T",
   latitude:"32.75",
   longitude:"129.95"}
  ,
  {name:"Fort Pierce (inside), Indian River, Florida",
   type:"T",
   latitude:"27.4567",
   longitude:"-80.3233"}
  ,
  {name:"Strathcona Sound, Nunavut",
   type:"T",
   latitude:"73.05",
   longitude:"-84.4"}
  ,
  {name:"Petropavlosk, Russia",
   type:"T",
   latitude:"53.0167",
   longitude:"158.6333"}
  ,
  {name:"Armentieres Channel, British Columbia",
   type:"T",
   latitude:"53.1167",
   longitude:"-132.3833"}
  ,
  {name:"Talbert Island, River Shannon, Ireland (2)",
   type:"T",
   latitude:"52.5833",
   longitude:"-9.3667"}
  ,
  {name:"Barra Norte, Brazil",
   type:"T",
   latitude:"0.9167",
   longitude:"-50.0667"}
  ,
  {name:"Tomie, Nagasaki, Japan",
   type:"T",
   latitude:"32.6167",
   longitude:"128.767"}
  ,
  {name:"Matusaka, Mie, Japan",
   type:"T",
   latitude:"34.6",
   longitude:"136.567"}
  ,
  {name:"Sheepscot River (off Barter Island), Maine Current",
   type:"C",
   latitude:"43.9",
   longitude:"-69.6917"}
  ,
  {name:"Davis Strait, Nunavut (2)",
   type:"T",
   latitude:"66.2667",
   longitude:"-60.9667"}
  ,
  {name:"Phoenix Park, Florida (3)",
   type:"T",
   latitude:"30.3833",
   longitude:"-81.6367"}
  ,
  {name:"Baie De Brador, Québec",
   type:"T",
   latitude:"51.4667",
   longitude:"-57.2667"}
  ,
  {name:"Cambridge Bay, Nunavut/NWT (2)",
   type:"T",
   latitude:"69.1167",
   longitude:"-105.0667"}
  ,
  {name:"Akyab, Myanmar",
   type:"T",
   latitude:"20.1333",
   longitude:"92.9"}
  ,
  {name:"Manzeki-Thuo, Nagasaki, Japan",
   type:"T",
   latitude:"34.3",
   longitude:"129.35"}
  ,
  {name:"Tanjong Gelang, Malaysia",
   type:"T",
   latitude:"3.9833",
   longitude:"103.4167"}
  ,
  {name:"Knox Bay, British Columbia",
   type:"T",
   latitude:"50.4",
   longitude:"-125.6"}
  ,
  {name:"Cape Capstan, Nova Scotia",
   type:"T",
   latitude:"45.4667",
   longitude:"-64.85"}
  ,
  {name:"Blount Island Bridge, St. Johns River, Florida",
   type:"T",
   latitude:"30.4133",
   longitude:"-81.545"}
  ,
  {name:"Grande Île, Québec",
   type:"T",
   latitude:"47.6167",
   longitude:"-69.8667"}
  ,
  {name:"South Bend, Washington",
   type:"T",
   latitude:"46.6633",
   longitude:"-123.7983"}
  ,
  {name:"St. Marks River Entrance, Florida (3) (expired 1984-12-31)",
   type:"T",
   latitude:"30.0783",
   longitude:"-84.1783"}
  ,
  {name:"Mukah, Malaysia",
   type:"T",
   latitude:"2.9",
   longitude:"112.0833"}
  ,
  {name:"Kannoura, Koti, Japan",
   type:"T",
   latitude:"33.55",
   longitude:"134.3"}
  ,
  {name:"Tuneisi, Hirosima, Japan",
   type:"T",
   latitude:"34.3833",
   longitude:"133.3"}
  ,
  {name:"Tonoura (Miyazaki), Miyazaki, Japan",
   type:"T",
   latitude:"31.5167",
   longitude:"131.367"}
  ,
  {name:"Haig Point, Daufuskie Island, Cooper River, South Carolina",
   type:"T",
   latitude:"32.15",
   longitude:"-80.8333"}
  ,
  {name:"Port Refuge, Cocos Islands (2)",
   type:"T",
   latitude:"-12.0833",
   longitude:"96.8833"}
  ,
  {name:"Sovetskaya, Russia",
   type:"T",
   latitude:"49.0",
   longitude:"140.3"}
  ,
  {name:"Armentieres Channel, British Columbia (2)",
   type:"T",
   latitude:"53.1167",
   longitude:"-132.3833"}
  ,
  {name:"Port Augusta, Australia",
   type:"T",
   latitude:"-32.55",
   longitude:"137.7833"}
  ,
  {name:"Monhegan Island, Maine",
   type:"T",
   latitude:"43.765",
   longitude:"-69.3217"}
  ,
  {name:"Karumba, Australia",
   type:"T",
   latitude:"-17.5",
   longitude:"140.8333"}
  ,
  {name:"Commonwealth Bay, Antarctica",
   type:"T",
   latitude:"-67.0",
   longitude:"142.6667"}
  ,
  {name:"Round Island, Torres Strait",
   type:"T",
   latitude:"-10.55",
   longitude:"142.2"}
  ,
  {name:"Kunjan, South Korea",
   type:"T",
   latitude:"35.9833",
   longitude:"126.7"}
  ,
  {name:"Peekskill, Hudson River, New York",
   type:"T",
   latitude:"41.2883",
   longitude:"-73.9317"}
  ,
  {name:"Wickford, Narragansett Bay, Rhode Island",
   type:"T",
   latitude:"41.5733",
   longitude:"-71.445"}
  ,
  {name:"Miami Harbor Entrance, Florida Current (1) (expired 1986-12-31)",
   type:"C",
   latitude:"25.765",
   longitude:"-80.1367"}
  ,
  {name:"Cardiff, Wales",
   type:"T",
   latitude:"51.45",
   longitude:"-3.1667"}
  ,
  {name:"Gowlland Harbour, British Columbia (2)",
   type:"T",
   latitude:"50.0667",
   longitude:"-125.2333"}
  ,
  {name:"Harmil Island, Eritrea",
   type:"T",
   latitude:"16.4833",
   longitude:"40.1833"}
  ,
  {name:"Vanimo, Papua New Guinea",
   type:"T",
   latitude:"-2.6833",
   longitude:"141.3"}
  ,
  {name:"Recife, Brazil (2)",
   type:"T",
   latitude:"-8.05",
   longitude:"-34.8667"}
  ,
  {name:"Fife Island, Australia",
   type:"T",
   latitude:"-13.65",
   longitude:"143.7167"}
  ,
  {name:"Hope Bay, British Columbia (2)",
   type:"T",
   latitude:"48.8",
   longitude:"-123.2667"}
  ,
  {name:"Point Ybel, San Carlos Bay Entrance, Florida",
   type:"T",
   latitude:"26.45",
   longitude:"-82.0167"}
  ,
  {name:"Crown Prince Frederick, Nunavut",
   type:"T",
   latitude:"70.0333",
   longitude:"-86.0833"}
  ,
  {name:"Esbjerg, Denmark (2)",
   type:"T",
   latitude:"55.4833",
   longitude:"8.4667"}
  ,
  {name:"Avalon Channel, Newfoundland",
   type:"T",
   latitude:"47.4",
   longitude:"-51.8"}
  ,
  {name:"Belize Inlet, British Columbia",
   type:"T",
   latitude:"51.1167",
   longitude:"-127.2667"}
  ,
  {name:"Caleta Brent, Argentina",
   type:"T",
   latitude:"-54.8333",
   longitude:"-64.3667"}
  ,
  {name:"Pipavav Bandar, India",
   type:"T",
   latitude:"20.95",
   longitude:"71.5333"}
  ,
  {name:"Pointe-Au-Pic, Québec",
   type:"T",
   latitude:"47.6167",
   longitude:"-70.05"}
  ,
  {name:"Charlton Island, Nunavut",
   type:"T",
   latitude:"51.9667",
   longitude:"-79.3"}
  ,
  {name:"Scrabster, Scotland",
   type:"T",
   latitude:"58.6167",
   longitude:"-3.55"}
  ,
  {name:"Los Angeles, California",
   type:"T",
   latitude:"33.72",
   longitude:"-118.2717"}
  ,
  {name:"Sydney, Australia (2)",
   type:"T",
   latitude:"-33.85",
   longitude:"151.2333"}
  ,
  {name:"Lady Barron Harbour, Tasmania",
   type:"T",
   latitude:"-40.2167",
   longitude:"148.25"}
  ,
  {name:"Kawaihae, Big Island, Hawaii",
   type:"T",
   latitude:"20.04",
   longitude:"-155.8317"}
  ,
  {name:"Taylors Landing, Australia",
   type:"T",
   latitude:"-34.85",
   longitude:"135.95"}
  ,
  {name:"Hiru-Ga-Ura, Nagasaki, Japan",
   type:"T",
   latitude:"34.3167",
   longitude:"129.283"}
  ,
  {name:"Nawiliwili, Hawaii (2)",
   type:"T",
   latitude:"21.9667",
   longitude:"-159.35"}
  ,
  {name:"Pointe-à-Pitre, Guadeloupe",
   type:"T",
   latitude:"16.2333",
   longitude:"-61.5333"}
  ,
  {name:"Tappi Saki, Aomori, Japan",
   type:"T",
   latitude:"41.2667",
   longitude:"140.333"}
  ,
  {name:"Ream, Cambodia",
   type:"T",
   latitude:"10.55",
   longitude:"103.6"}
  ,
  {name:"Miners Bay, British Columbia",
   type:"T",
   latitude:"48.85",
   longitude:"-123.3"}
  ,
  {name:"Pointe-au-Pere, Québec (2)",
   type:"T",
   latitude:"48.5167",
   longitude:"-68.4667"}
  ,
  {name:"Port Simpson, British Columbia",
   type:"T",
   latitude:"54.5667",
   longitude:"-130.4333"}
  ,
  {name:"Le Robert, Martinique",
   type:"T",
   latitude:"14.6833",
   longitude:"-60.1167"}
  ,
  {name:"Hizi, Oita, Japan",
   type:"T",
   latitude:"33.3667",
   longitude:"131.533"}
  ,
  {name:"Fort Ross, Nunavut",
   type:"T",
   latitude:"72.0167",
   longitude:"-94.2333"}
  ,
  {name:"Kogo Saki, Nagasaki, Japan",
   type:"T",
   latitude:"33.1",
   longitude:"129.683"}
  ,
  {name:"Cape Hotham, Australia",
   type:"T",
   latitude:"-12.05",
   longitude:"131.2833"}
  ,
  {name:"Passaic, Passaic River, New Jersey",
   type:"T",
   latitude:"40.8483",
   longitude:"-74.12"}
  ,
  {name:"Holyhead, Wales (2)",
   type:"T",
   latitude:"53.3167",
   longitude:"-4.6167"}
  ,
  {name:"Hiwasa, Tokusima, Japan",
   type:"T",
   latitude:"33.7333",
   longitude:"134.55"}
  ,
  {name:"Odawa Wan, Kanagawa, Japan",
   type:"T",
   latitude:"35.2167",
   longitude:"139.617"}
  ,
  {name:"Moura, Aomori, Japan",
   type:"T",
   latitude:"40.95",
   longitude:"140.867"}
  ,
  {name:"Portland, Maine (3) (expired 1982-12-31)",
   type:"T",
   latitude:"43.6567",
   longitude:"-70.2467"}
  ,
  {name:"Ominato, Aomori, Japan",
   type:"T",
   latitude:"41.25",
   longitude:"141.15"}
  ,
  {name:"La Paz, Baja California Sur, Mexico",
   type:"T",
   latitude:"24.15",
   longitude:"-110.3"}
  ,
  {name:"Middle Island Anchorage, Australia",
   type:"T",
   latitude:"-21.65",
   longitude:"150.25"}
  ,
  {name:"Shingle Bay, British Columbia",
   type:"T",
   latitude:"53.25",
   longitude:"-131.8167"}
  ,
  {name:"Sagar Island, India",
   type:"T",
   latitude:"21.65",
   longitude:"88.05"}
  ,
  {name:"Seymour Narrows, British Columbia",
   type:"T",
   latitude:"50.1333",
   longitude:"-125.35"}
  ,
  {name:"Vishakhapatnam, India",
   type:"T",
   latitude:"17.6833",
   longitude:"83.2833"}
  ,
  {name:"Bedout Islet, Australia",
   type:"T",
   latitude:"-19.6",
   longitude:"119.1"}
  ,
  {name:"Runaway Bay, Australia",
   type:"T",
   latitude:"-27.9167",
   longitude:"153.4"}
  ,
  {name:"Eden, Australia",
   type:"T",
   latitude:"-37.0667",
   longitude:"149.9"}
  ,
  {name:"Ostrov Matua, Kurile Islands",
   type:"T",
   latitude:"48.0833",
   longitude:"153.267"}
  ,
  {name:"Reservation Bay, Washington (2)",
   type:"T",
   latitude:"48.4167",
   longitude:"-122.0667"}
  ,
  {name:"Port Stephens, Australia",
   type:"T",
   latitude:"-32.7167",
   longitude:"152.1833"}
  ,
  {name:"Bunbury, Australia",
   type:"T",
   latitude:"-33.3167",
   longitude:"115.65"}
  ,
  {name:"Samuel Island (South Shore), British Columbia (2)",
   type:"T",
   latitude:"48.8",
   longitude:"-123.2"}
  ,
  {name:"Patricia Bay, British Columbia (2)",
   type:"T",
   latitude:"48.65",
   longitude:"-123.45"}
  ,
  {name:"Port Blackney, British Columbia",
   type:"T",
   latitude:"52.3167",
   longitude:"-128.35"}
  ,
  {name:"Goold Island, Australia",
   type:"T",
   latitude:"-18.1667",
   longitude:"146.1833"}
  ,
  {name:"Honolulu, Oahu (Hawaii)",
   type:"T",
   latitude:"21.3067",
   longitude:"-157.8667"}
  ,
  {name:"Wyndham, Australia",
   type:"T",
   latitude:"-15.45",
   longitude:"128.1"}
  ,
  {name:"Nabe Sima, Kagawa, Japan",
   type:"T",
   latitude:"34.3833",
   longitude:"133.817"}
  ,
  {name:"Pinkney Point, Nova Scotia",
   type:"T",
   latitude:"43.7",
   longitude:"-66.0667"}
  ,
  {name:"St. Paul Island, Gulf of St. Lawrence, Nova Scotia",
   type:"T",
   latitude:"47.2",
   longitude:"-60.15"}
  ,
  {name:"Guaymas, Sonora, Mexico",
   type:"T",
   latitude:"27.9167",
   longitude:"-110.8833"}
  ,
  {name:"Angra dos Reis, Brazil",
   type:"T",
   latitude:"-23.0167",
   longitude:"-44.3167"}
  ,
  {name:"Little Harbour, Nova Scotia",
   type:"T",
   latitude:"44.7167",
   longitude:"-62.85"}
  ,
  {name:"Haysport, British Columbia (2)",
   type:"T",
   latitude:"54.1833",
   longitude:"-130.0"}
  ,
  {name:"Seal Cove, Grand Manan Island, New Brunswick",
   type:"T",
   latitude:"44.65",
   longitude:"-66.85"}
  ,
  {name:"Black Rock Point, Nova Scotia",
   type:"T",
   latitude:"46.3",
   longitude:"-60.4"}
  ,
  {name:"Québec (Lauzon), Québec (2)",
   type:"T",
   latitude:"46.8333",
   longitude:"-71.1667"}
  ,
  {name:"Pollock Rip Channel, Massachusetts Current",
   type:"C",
   latitude:"41.5467",
   longitude:"-69.985"}
  ,
  {name:"Fort Churchill, Manitoba",
   type:"T",
   latitude:"58.7667",
   longitude:"-94.0667"}
  ,
  {name:"Hay Point, Australia",
   type:"T",
   latitude:"-21.2667",
   longitude:"149.3"}
  ,
  {name:"Port Phillip Heads, Australia",
   type:"T",
   latitude:"-38.3",
   longitude:"144.6167"}
  ,
  {name:"Mizu-No-Ura (Goto), Nagasaki, Japan",
   type:"T",
   latitude:"32.75",
   longitude:"128.75"}
  ,
  {name:"Port Edward, British Columbia (2)",
   type:"T",
   latitude:"54.2333",
   longitude:"-130.3"}
  ,
  {name:"Mill Bay, British Columbia (2)",
   type:"T",
   latitude:"55.0",
   longitude:"-129.9"}
  ,
  {name:"Kegaska, Québec",
   type:"T",
   latitude:"50.1833",
   longitude:"-61.2667"}
  ,
  {name:"Sanmura Wan, Kagosima, Japan",
   type:"T",
   latitude:"27.8667",
   longitude:"128.967"}
  ,
  {name:"Naibo Wan, Hokkaido, Japan",
   type:"T",
   latitude:"44.7667",
   longitude:"147.2"}
  ,
  {name:"Clearwater Fiord, Cumberland Sound, Nunavut",
   type:"T",
   latitude:"66.6",
   longitude:"-67.3167"}
  ,
  {name:"East Tocoi, St. Johns River, Florida (2)",
   type:"T",
   latitude:"29.8583",
   longitude:"-81.5533"}
  ,
  {name:"Section Cove, British Columbia",
   type:"T",
   latitude:"52.4333",
   longitude:"-131.3833"}
  ,
  {name:"Oak Landing, ICWW, Florida",
   type:"T",
   latitude:"30.2533",
   longitude:"-81.43"}
  ,
  {name:"Kanda, Hukuoka, Japan",
   type:"T",
   latitude:"33.7833",
   longitude:"130.983"}
  ,
  {name:"Monkey Mia, Australia",
   type:"T",
   latitude:"-25.8",
   longitude:"113.7167"}
  ,
  {name:"Macau, Rio Acu, Brazil",
   type:"T",
   latitude:"-5.1167",
   longitude:"-36.6333"}
  ,
  {name:"Kure, Hirosima, Japan (2)",
   type:"T",
   latitude:"34.2333",
   longitude:"132.55"}
  ,
  {name:"Coal Harbour, British Columbia (2)",
   type:"T",
   latitude:"50.6",
   longitude:"-127.5833"}
  ,
  {name:"Hong Kong, China (2)",
   type:"T",
   latitude:"22.2833",
   longitude:"114.1833"}
  ,
  {name:"Cairns, Australia",
   type:"T",
   latitude:"-16.9167",
   longitude:"145.7833"}
  ,
  {name:"Seabreeze Point, British Columbia",
   type:"T",
   latitude:"53.9833",
   longitude:"-130.1833"}
  ,
  {name:"Yamba, Australia",
   type:"T",
   latitude:"-29.4167",
   longitude:"153.35"}
  ,
  {name:"Davis Inlet, Labrador",
   type:"T",
   latitude:"55.8833",
   longitude:"-60.9"}
  ,
  {name:"Tailevu, Fiji Islands",
   type:"T",
   latitude:"-17.65",
   longitude:"178.5833"}
  ,
  {name:"Blaine, Semiahmoo Bay, Washington",
   type:"T",
   latitude:"49.0",
   longitude:"-122.7667"}
  ,
  {name:"Change Island, Newfoundland",
   type:"T",
   latitude:"49.6667",
   longitude:"-54.4167"}
  ,
  {name:"Bangor, Penobscot River, Maine",
   type:"T",
   latitude:"44.795",
   longitude:"-68.7717"}
  ,
  {name:"Davao, Philippines",
   type:"T",
   latitude:"7.0833",
   longitude:"125.6333"}
  ,
  {name:"East Tocoi, St. Johns River, Florida (3)",
   type:"T",
   latitude:"29.8583",
   longitude:"-81.5533"}
  ,
  {name:"Burntcoat Head, Nova Scotia",
   type:"T",
   latitude:"45.3",
   longitude:"-63.8"}
  ,
  {name:"Oita-Turusaki, Oita, Japan",
   type:"T",
   latitude:"33.2667",
   longitude:"131.683"}
  ,
  {name:"Gannet Cay, Australia",
   type:"T",
   latitude:"-21.9833",
   longitude:"152.4667"}
  ,
  {name:"Santa Cruz, California",
   type:"T",
   latitude:"36.9667",
   longitude:"-122.0167"}
  ,
  {name:"Pinang, Malaysia",
   type:"T",
   latitude:"5.4167",
   longitude:"100.35"}
  ,
  {name:"Chinhae, South Korea",
   type:"T",
   latitude:"35.1667",
   longitude:"128.55"}
  ,
  {name:"Tosa-Simizu, Koti, Japan",
   type:"T",
   latitude:"32.7833",
   longitude:"132.967"}
  ,
  {name:"Higasi Ura, Kurile Islands",
   type:"T",
   latitude:"48.7833",
   longitude:"154.083"}
  ,
  {name:"Brunswick Heads, Australia",
   type:"T",
   latitude:"-28.5333",
   longitude:"153.6167"}
  ,
  {name:"Black Creek, S.C.L. RR. bridge, Florida (3)",
   type:"T",
   latitude:"30.08",
   longitude:"-81.7617"}
  ,
  {name:"Karoto-Ko Seto, Hirosima, Japan",
   type:"T",
   latitude:"34.0667",
   longitude:"132.55"}
  ,
  {name:"Massawa, Eritrea",
   type:"T",
   latitude:"15.6167",
   longitude:"39.4667"}
  ,
  {name:"Whaler Bay, British Columbia",
   type:"T",
   latitude:"48.8833",
   longitude:"-123.3333"}
  ,
  {name:"Cape Poge, Chappaquiddick Island, Massachusetts",
   type:"T",
   latitude:"41.4167",
   longitude:"-70.45"}
  ,
  {name:"Flock Pigeon Island, Australia",
   type:"T",
   latitude:"-22.1167",
   longitude:"149.5667"}
  ,
  {name:"Puerto Penasco, Sonora, Mexico (2)",
   type:"T",
   latitude:"31.3017",
   longitude:"-113.3817"}
  ,
  {name:"Québec (Lauzon), Québec (3)",
   type:"T",
   latitude:"46.8333",
   longitude:"-71.1667"}
  ,
  {name:"Santa Isabel, Equatorial Guinea",
   type:"T",
   latitude:"3.7667",
   longitude:"8.7833"}
  ,
  {name:"Uken, Kagosima, Japan",
   type:"T",
   latitude:"28.2833",
   longitude:"129.233"}
  ,
  {name:"Colonia del Sacramento, Rio de la Plata, Uruguay",
   type:"T",
   latitude:"-34.4667",
   longitude:"-57.85"}
  ,
  {name:"Glendale Cove, British Columbia (2)",
   type:"T",
   latitude:"50.0667",
   longitude:"-125.7333"}
  ,
  {name:"Kwajalein Atoll, Marshall Islands",
   type:"T",
   latitude:"8.7367",
   longitude:"167.7383"}
  ,
  {name:"Nigisima, Mie, Japan",
   type:"T",
   latitude:"33.9333",
   longitude:"136.183"}
  ,
  {name:"Uwama, Ehime, Japan",
   type:"T",
   latitude:"33.9667",
   longitude:"132.583"}
  ,
  {name:"Jacksonville, Acosta Bridge, Florida",
   type:"T",
   latitude:"30.325",
   longitude:"-81.665"}
  ,
  {name:"Southwest Point, Québec",
   type:"T",
   latitude:"49.4",
   longitude:"-63.6"}
  ,
  {name:"Aveiro, Portugal",
   type:"T",
   latitude:"40.6333",
   longitude:"-8.75"}
  ,
  {name:"Addenbroke Island, British Columbia (2)",
   type:"T",
   latitude:"51.6",
   longitude:"-127.8167"}
  ,
  {name:"Black Creek, S.C.L. RR. bridge, Florida (2)",
   type:"T",
   latitude:"30.08",
   longitude:"-81.7617"}
  ,
  {name:"Owen Bay, British Columbia (2)",
   type:"T",
   latitude:"50.3167",
   longitude:"-125.2167"}
  ,
  {name:"Dumbarton Bridge, San Francisco Bay, California (2)",
   type:"T",
   latitude:"37.5",
   longitude:"-122.1167"}
  ,
  {name:"Neiafu, Vava`u Group, Tonga",
   type:"T",
   latitude:"-18.65",
   longitude:"-173.9833"}
  ,
  {name:"Nobiru Wan, Miyagi, Japan",
   type:"T",
   latitude:"38.35",
   longitude:"141.15"}
  ,
  {name:"Puerto Penasco, Sonora, Mexico (3)",
   type:"T",
   latitude:"31.3017",
   longitude:"-113.3817"}
  ,
  {name:"Geelong, Australia",
   type:"T",
   latitude:"-38.15",
   longitude:"144.3667"}
  ,
  {name:"Northport, Northport Bay, Long Island Sound, New York (2)",
   type:"T",
   latitude:"40.9",
   longitude:"-73.35"}
  ,
  {name:"Baltimore Harbor Approach, Maryland Current",
   type:"C",
   latitude:"39.0133",
   longitude:"-76.3683"}
  ,
  {name:"Pith Reef, Australia",
   type:"T",
   latitude:"-18.2333",
   longitude:"147.0333"}
  ,
  {name:"Karumo Sima, Hyogo, Japan",
   type:"T",
   latitude:"34.65",
   longitude:"135.167"}
  ,
  {name:"Isanotski Strait (False Pass cannery), Alaska Current",
   type:"C",
   latitude:"54.8667",
   longitude:"-163.4"}
  ,
  {name:"Obama, Hukui, Japan",
   type:"T",
   latitude:"35.5",
   longitude:"135.733"}
  ,
  {name:"Akureyri, Iceland",
   type:"T",
   latitude:"65.6833",
   longitude:"-18.1167"}
  ,
  {name:"Shushartie Bay, British Columbia (2)",
   type:"T",
   latitude:"50.85",
   longitude:"-127.85"}
  ,
  {name:"Rosslyn Bay, Australia",
   type:"T",
   latitude:"-23.1667",
   longitude:"150.7833"}
  ,
  {name:"Gaspé Bay, Québec",
   type:"T",
   latitude:"48.8333",
   longitude:"-64.4833"}
  ,
  {name:"Marovo Lagoon, Solomon Islands",
   type:"T",
   latitude:"-8.5",
   longitude:"157.9667"}
  ,
  {name:"Evandale, New Brunswick",
   type:"T",
   latitude:"45.5833",
   longitude:"-66.0333"}
  ,
  {name:"Boulogne, France",
   type:"T",
   latitude:"50.7333",
   longitude:"1.5833"}
  ,
  {name:"Wallaroo, Australia",
   type:"T",
   latitude:"-33.9",
   longitude:"137.6"}
  ,
  {name:"Ceepeecee, British Columbia",
   type:"T",
   latitude:"49.8667",
   longitude:"-126.7167"}
  ,
  {name:"Portland, Australia (2)",
   type:"T",
   latitude:"-38.35",
   longitude:"141.6167"}
  ,
  {name:"Inukjuak, Québec",
   type:"T",
   latitude:"58.45",
   longitude:"-78.1"}
  ,
  {name:"Saito Saki, Hukuoka, Japan",
   type:"T",
   latitude:"33.65",
   longitude:"130.367"}
  ,
  {name:"Kusimoto, Wakayama, Japan",
   type:"T",
   latitude:"33.4667",
   longitude:"135.783"}
  ,
  {name:"Brundige Inlet, British Columbia",
   type:"T",
   latitude:"54.6167",
   longitude:"-130.85"}
  ,
  {name:"Kuti-Erabu Sima, Kagosima, Japan",
   type:"T",
   latitude:"30.4667",
   longitude:"130.183"}
  ,
  {name:"Mataiva, Tahiti (2)",
   type:"T",
   latitude:"-17.5167",
   longitude:"-149.5167"}
  ,
  {name:"Port Phillip Heads, Australia (2)",
   type:"T",
   latitude:"-38.3",
   longitude:"144.6167"}
  ,
  {name:"Tanjong Sedili Kechil, Malaysia",
   type:"T",
   latitude:"1.85",
   longitude:"104.15"}
  ,
  {name:"Port Burwell, Labrador",
   type:"T",
   latitude:"60.4167",
   longitude:"-64.85"}
  ,
  {name:"Valleyfield, Newfoundland",
   type:"T",
   latitude:"49.1667",
   longitude:"-53.6167"}
  ,
  {name:"Octopus Islands, British Columbia (2)",
   type:"T",
   latitude:"50.2833",
   longitude:"-125.2167"}
  ,
  {name:"Babs Bay, Hudson Bay, Québec",
   type:"T",
   latitude:"60.7667",
   longitude:"-78.3167"}
  ,
  {name:"Bukhta Krasheninikova, Kurile Islands",
   type:"T",
   latitude:"50.2833",
   longitude:"155.333"}
  ,
  {name:"Paspebiac, Québec",
   type:"T",
   latitude:"48.0167",
   longitude:"-65.2333"}
  ,
  {name:"Oslo, Norway",
   type:"T",
   latitude:"59.9167",
   longitude:"10.7333"}
  ,
  {name:"Lancelin, Australia",
   type:"T",
   latitude:"-31.0167",
   longitude:"115.3333"}
  ,
  {name:"Spencer Island, Nova Scotia",
   type:"T",
   latitude:"45.35",
   longitude:"-64.7167"}
  ,
  {name:"Tolchester Beach, Chesapeake Bay, Maryland",
   type:"T",
   latitude:"39.2133",
   longitude:"-76.245"}
  ,
  {name:"Hukue (Goto), Nagasaki, Japan",
   type:"T",
   latitude:"32.7",
   longitude:"128.85"}
  ,
  {name:"Tachin, Thailand",
   type:"T",
   latitude:"13.5333",
   longitude:"100.2833"}
  ,
  {name:"Port Bickerton, Nova Scotia",
   type:"T",
   latitude:"45.1",
   longitude:"-61.7333"}
  ,
  {name:"San Carlos, Equatorial Guinea",
   type:"T",
   latitude:"3.5167",
   longitude:"8.55"}
  ,
  {name:"Bic, Québec",
   type:"T",
   latitude:"48.3833",
   longitude:"-68.7333"}
  ,
  {name:"Hauy Islet, Australia",
   type:"T",
   latitude:"-20.4167",
   longitude:"116.9667"}
  ,
  {name:"Gillies Island, Québec",
   type:"T",
   latitude:"56.55",
   longitude:"-76.6333"}
  ,
  {name:"Devonport, Tasmania",
   type:"T",
   latitude:"-41.1833",
   longitude:"146.3667"}
  ,
  {name:"Plymouth (Devonport), England (2)",
   type:"T",
   latitude:"50.3667",
   longitude:"-4.1833"}
  ,
  {name:"Point Grey, British Columbia",
   type:"T",
   latitude:"49.25",
   longitude:"-123.2667"}
  ,
  {name:"Duchateau Island, Papua New Guinea (2)",
   type:"T",
   latitude:"-11.2833",
   longitude:"152.3667"}
  ,
  {name:"Moss Landing, California",
   type:"T",
   latitude:"36.8017",
   longitude:"-121.79"}
  ,
  {name:"Trondheim, Norway",
   type:"T",
   latitude:"63.4333",
   longitude:"10.4333"}
  ,
  {name:"Florence Cove, British Columbia",
   type:"T",
   latitude:"50.3",
   longitude:"-125.1667"}
  ,
  {name:"Point Tupper, Nova Scotia (2)",
   type:"T",
   latitude:"45.6",
   longitude:"-61.3667"}
  ,
  {name:"Derby, Australia",
   type:"T",
   latitude:"-17.2833",
   longitude:"123.65"}
  ,
  {name:"Hunt Inlet, British Columbia (2)",
   type:"T",
   latitude:"54.0667",
   longitude:"-130.45"}
  ,
  {name:"Elliston, Australia",
   type:"T",
   latitude:"-33.6333",
   longitude:"134.8667"}
  ,
  {name:"Iquique, Chile",
   type:"T",
   latitude:"-20.2167",
   longitude:"-70.1667"}
  ,
  {name:"Mill Cove, Nova Scotia",
   type:"T",
   latitude:"44.5833",
   longitude:"-64.0667"}
  ,
  {name:"Sutherlands Still, Dunns Creek, Florida",
   type:"T",
   latitude:"29.5733",
   longitude:"-81.6033"}
  ,
  {name:"Chiba, Japan",
   type:"T",
   latitude:"35.6",
   longitude:"140.1167"}
  ,
  {name:"Sydney, Australia (3)",
   type:"T",
   latitude:"-33.85",
   longitude:"151.2333"}
  ,
  {name:"Philadelphia, Pennsylvania Current",
   type:"C",
   latitude:"39.95",
   longitude:"-75.1333"}
  ,
  {name:"Cornet Bay, Deception Pass, Washington",
   type:"T",
   latitude:"48.3833",
   longitude:"-122.6333"}
  ,
  {name:"Cape Bryant, Greenland",
   type:"T",
   latitude:"82.3667",
   longitude:"-55.1333"}
  ,
  {name:"Rumoi, Hokkaido, Japan",
   type:"T",
   latitude:"43.95",
   longitude:"141.633"}
  ,
  {name:"Duncan Bay, British Columbia (2)",
   type:"T",
   latitude:"50.0833",
   longitude:"-125.3"}
  ,
  {name:"Redwood City, Wharf 5, California",
   type:"T",
   latitude:"37.5067",
   longitude:"-122.21"}
  ,
  {name:"Arendal, Norway",
   type:"T",
   latitude:"58.45",
   longitude:"8.7667"}
  ,
  {name:"Cape Scott, British Columbia",
   type:"T",
   latitude:"50.7833",
   longitude:"-128.4167"}
  ,
  {name:"Parrsboro, Nova Scotia",
   type:"T",
   latitude:"45.3667",
   longitude:"-64.3333"}
  ,
  {name:"Johns Island, Chassahowitzka Bay, Florida",
   type:"T",
   latitude:"28.6917",
   longitude:"-82.6383"}
  ,
  {name:"Memory Rock, Bahamas",
   type:"T",
   latitude:"26.95",
   longitude:"-79.1167"}
  ,
  {name:"Threemile Slough Entrance, San Joaquin River, California",
   type:"T",
   latitude:"38.0833",
   longitude:"-121.6833"}
  ,
  {name:"McPherson Point, British Columbia (2)",
   type:"T",
   latitude:"54.2333",
   longitude:"-132.9667"}
  ,
  {name:"Morro Bay, California",
   type:"T",
   latitude:"35.367",
   longitude:"-120.85"}
  ,
  {name:"Rimouski, Québec",
   type:"T",
   latitude:"48.4333",
   longitude:"-68.55"}
  ,
  {name:"St. Francis Island, Australia",
   type:"T",
   latitude:"-32.5",
   longitude:"133.3"}
  ,
  {name:"Doctors Lake, Peoria Point, Florida",
   type:"T",
   latitude:"30.12",
   longitude:"-81.7583"}
  ,
  {name:"Cape Saint James, British Columbia",
   type:"T",
   latitude:"51.9333",
   longitude:"-131.0167"}
  ,
  {name:"Port Walcott, Australia (2)",
   type:"T",
   latitude:"-20.5833",
   longitude:"117.1833"}
  ,
  {name:"Yorke Island, British Columbia (2)",
   type:"T",
   latitude:"50.45",
   longitude:"-125.9833"}
  ,
  {name:"Assab, Eritrea",
   type:"T",
   latitude:"12.65",
   longitude:"43.4333"}
  ,
  {name:"St-Joachim, Québec",
   type:"T",
   latitude:"47.05",
   longitude:"-70.85"}
  ,
  {name:"Quathiaski Cove, British Columbia",
   type:"T",
   latitude:"50.05",
   longitude:"-125.2167"}
  ,
  {name:"Cape Tormentine, New Brunswick",
   type:"T",
   latitude:"46.1333",
   longitude:"-63.7667"}
  ,
  {name:"Prudhoe Bay, Dock #2, Alaska",
   type:"T",
   latitude:"70.3883",
   longitude:"-148.51"}
  ,
  {name:"Siogama-Sendai, Miyagi, Japan",
   type:"T",
   latitude:"38.2667",
   longitude:"141.033"}
  ,
  {name:"Port Edward, British Columbia",
   type:"T",
   latitude:"54.2333",
   longitude:"-130.3"}
  ,
  {name:"Zaliv Tukharka, Kurile Islands (2)",
   type:"T",
   latitude:"50.1833",
   longitude:"155.65"}
  ,
  {name:"Hitokappu Wan, Hokkaido, Japan",
   type:"T",
   latitude:"44.9333",
   longitude:"147.633"}
  ,
  {name:"Cap De Rabast, Québec",
   type:"T",
   latitude:"49.95",
   longitude:"-64.15"}
  ,
  {name:"East Narrows, Skidegate Channel, British Columbia",
   type:"T",
   latitude:"53.15",
   longitude:"-132.25"}
  ,
  {name:"Itoman, Okinawa, Japan",
   type:"T",
   latitude:"26.1333",
   longitude:"127.667"}
  ,
  {name:"Ohunakosi, Nagasaki, Japan",
   type:"T",
   latitude:"34.2833",
   longitude:"129.35"}
  ,
  {name:"Vivonne Bay, Australia",
   type:"T",
   latitude:"-36.0",
   longitude:"137.1833"}
  ,
  {name:"Gijón, Spain",
   type:"T",
   latitude:"43.5667",
   longitude:"-5.7"}
  ,
  {name:"Clear Lake, Harris Co. Park, Texas",
   type:"T",
   latitude:"29.5633",
   longitude:"-95.0667"}
  ,
  {name:"Kariya (Suo Nada), Yamaguti, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"131.167"}
  ,
  {name:"Minmaya, Aomori, Japan",
   type:"T",
   latitude:"41.2",
   longitude:"140.417"}
  ,
  {name:"Takamatu, Kagawa, Japan (2)",
   type:"T",
   latitude:"34.35",
   longitude:"134.05"}
  ,
  {name:"North Inian Pass, Cross Sound, Alaska Current",
   type:"C",
   latitude:"58.2833",
   longitude:"-136.3833"}
  ,
  {name:"Cap d'Antifer, France",
   type:"T",
   latitude:"49.65",
   longitude:"0.15"}
  ,
  {name:"Kario, Nagasaki, Japan",
   type:"T",
   latitude:"34.45",
   longitude:"129.3"}
  ,
  {name:"Adelaide Inner Harbour, Australia",
   type:"T",
   latitude:"-34.85",
   longitude:"138.5"}
  ,
  {name:"Wadhams, British Columbia",
   type:"T",
   latitude:"51.5167",
   longitude:"-127.5167"}
  ,
  {name:"Mutine Point, British Columbia (2)",
   type:"T",
   latitude:"48.9333",
   longitude:"-125.0167"}
  ,
  {name:"Tatibana, Tokusima, Japan",
   type:"T",
   latitude:"33.8667",
   longitude:"134.65"}
  ,
  {name:"Yuriage, Miyagi, Japan",
   type:"T",
   latitude:"38.1667",
   longitude:"140.967"}
  ,
  {name:"Macleay Island, Australia",
   type:"T",
   latitude:"-15.95",
   longitude:"123.6833"}
  ,
  {name:"Hudson Bay Passage, British Columbia (2)",
   type:"T",
   latitude:"54.45",
   longitude:"-130.85"}
  ,
  {name:"Bolama, Guinea-Bissau",
   type:"T",
   latitude:"11.5833",
   longitude:"-15.4833"}
  ,
  {name:"Russell Island, Australia",
   type:"T",
   latitude:"-17.2333",
   longitude:"146.1"}
  ,
  {name:"Wakamatu-Hibikinada, Hukuoka, Japan",
   type:"T",
   latitude:"33.9333",
   longitude:"130.85"}
  ,
  {name:"Isle of Springs, Maine",
   type:"T",
   latitude:"43.86",
   longitude:"-69.6867"}
  ,
  {name:"Kasiwazaki (Niigata), Niigata, Japan",
   type:"T",
   latitude:"37.35",
   longitude:"138.517"}
  ,
  {name:"Katurasele, Solomon Islands",
   type:"T",
   latitude:"-7.2",
   longitude:"156.9"}
  ,
  {name:"Savannah (Bull Street), Georgia",
   type:"T",
   latitude:"32.0817",
   longitude:"-81.0917"}
  ,
  {name:"Sino Sima, Aichi, Japan",
   type:"T",
   latitude:"34.6833",
   longitude:"137.0"}
  ,
  {name:"Ancona, Italy",
   type:"T",
   latitude:"43.6167",
   longitude:"13.5"}
  ,
  {name:"Wasizaki, Niigata, Japan",
   type:"T",
   latitude:"38.3167",
   longitude:"138.517"}
  ,
  {name:"Habu (Izu-O Sima), Tokyo, Japan",
   type:"T",
   latitude:"34.6833",
   longitude:"139.433"}
  ,
  {name:"Bergen, Norway (2)",
   type:"T",
   latitude:"60.4",
   longitude:"5.3"}
  ,
  {name:"Tubarão, Brazil",
   type:"T",
   latitude:"-20.2833",
   longitude:"-40.2333"}
  ,
  {name:"Cacheu, Guinea-Bissau",
   type:"T",
   latitude:"12.2833",
   longitude:"-16.1667"}
  ,
  {name:"Guam, Marianas (2)",
   type:"T",
   latitude:"13.4333",
   longitude:"144.65"}
  ,
  {name:"Isla Guadalupe, Baja California Norte, Mexico (2)",
   type:"T",
   latitude:"28.8817",
   longitude:"-118.2933"}
  ,
  {name:"Muroran, Hokkaido, Japan",
   type:"T",
   latitude:"42.35",
   longitude:"140.95"}
  ,
  {name:"Squitty Bay, British Columbia",
   type:"T",
   latitude:"49.45",
   longitude:"-124.0167"}
  ,
  {name:"Yawatahama, Ehime, Japan",
   type:"T",
   latitude:"33.45",
   longitude:"132.4"}
  ,
  {name:"Chesapeake and Delaware Canal, Maryland/Delaware Current",
   type:"C",
   latitude:"39.5333",
   longitude:"-75.8167"}
  ,
  {name:"Calabar, Nigeria",
   type:"T",
   latitude:"4.9667",
   longitude:"8.3167"}
  ,
  {name:"Cuidad del Carmen, Campeche, Mexico",
   type:"T",
   latitude:"18.54",
   longitude:"-91.8383"}
  ,
  {name:"Tawau, Malaysia",
   type:"T",
   latitude:"4.2333",
   longitude:"117.8833"}
  ,
  {name:"Godthåb, Greenland",
   type:"T",
   latitude:"64.1833",
   longitude:"-51.75"}
  ,
  {name:"Moser Channel (swingbridge), Florida Current",
   type:"C",
   latitude:"24.7",
   longitude:"-81.17"}
  ,
  {name:"Hasihama, Ehime, Japan",
   type:"T",
   latitude:"34.1167",
   longitude:"132.967"}
  ,
  {name:"Hawkesbury Island, Torres Strait",
   type:"T",
   latitude:"-10.3833",
   longitude:"142.1333"}
  ,
  {name:"Mikata (Aso Wan), Nagasaki, Japan",
   type:"T",
   latitude:"34.2833",
   longitude:"129.267"}
  ,
  {name:"Richibucto Bar, New Brunswick",
   type:"T",
   latitude:"46.7167",
   longitude:"-64.7833"}
  ,
  {name:"Grand Eddy, Nova Scotia",
   type:"T",
   latitude:"44.4",
   longitude:"-66.2"}
  ,
  {name:"Leslie, Nova Scotia",
   type:"T",
   latitude:"47.6167",
   longitude:"-61.5167"}
  ,
  {name:"Yokkaiti, Mie, Japan (2)",
   type:"T",
   latitude:"34.95",
   longitude:"136.6333"}
  ,
  {name:"River Tyne Entrance, England",
   type:"T",
   latitude:"55.0167",
   longitude:"-1.4"}
  ,
  {name:"Isla Guadalupe, Baja California Norte, Mexico (3)",
   type:"T",
   latitude:"28.8667",
   longitude:"-118.2833"}
  ,
  {name:"Surge Narrows, British Columbia",
   type:"T",
   latitude:"50.2167",
   longitude:"-125.1167"}
  ,
  {name:"Paradwip, India",
   type:"T",
   latitude:"20.2667",
   longitude:"86.6833"}
  ,
  {name:"Ballantyne Cove, Nova Scotia",
   type:"T",
   latitude:"45.8667",
   longitude:"-61.9167"}
  ,
  {name:"Cape Jervis, Australia",
   type:"T",
   latitude:"-35.6167",
   longitude:"138.1"}
  ,
  {name:"Wan Do, South Korea",
   type:"T",
   latitude:"34.3167",
   longitude:"126.75"}
  ,
  {name:"Santo Domingo (Ciudad Trujillo), Dominican Republic",
   type:"T",
   latitude:"18.4667",
   longitude:"-69.8833"}
  ,
  {name:"Sibaura, Tokyo, Japan",
   type:"T",
   latitude:"35.6333",
   longitude:"139.75"}
  ,
  {name:"Progreso, Yucatán, Mexico (2)",
   type:"T",
   latitude:"21.2833",
   longitude:"-89.6667"}
  ,
  {name:"Bluff Harbour, New Zealand",
   type:"T",
   latitude:"-46.6",
   longitude:"168.35"}
  ,
  {name:"Chinde, Mozambique",
   type:"T",
   latitude:"-18.5667",
   longitude:"36.45"}
  ,
  {name:"Paradise River, Labrador",
   type:"T",
   latitude:"53.4333",
   longitude:"-57.2833"}
  ,
  {name:"Boston, Massachusetts (2) (expired 1986-12-31)",
   type:"T",
   latitude:"42.355",
   longitude:"-71.05"}
  ,
  {name:"Huke, Osaka, Japan",
   type:"T",
   latitude:"34.3167",
   longitude:"135.133"}
  ,
  {name:"Cocagne Harbour, New Brunswick",
   type:"T",
   latitude:"46.0333",
   longitude:"-64.6167"}
  ,
  {name:"Kamui Misaki, Hokkaido, Japan",
   type:"T",
   latitude:"43.3333",
   longitude:"140.35"}
  ,
  {name:"Halifax, Nova Scotia (2)",
   type:"T",
   latitude:"44.6667",
   longitude:"-63.5833"}
  ,
  {name:"Sandy Hook, New Jersey",
   type:"T",
   latitude:"40.4667",
   longitude:"-74.0017"}
  ,
  {name:"Loon Island, Nunavut",
   type:"T",
   latitude:"53.8167",
   longitude:"-79.0167"}
  ,
  {name:"Tawara-Ga-Ura, Nagasaki, Japan",
   type:"T",
   latitude:"33.1167",
   longitude:"129.667"}
  ,
  {name:"Cape Aldrich, Nunavut",
   type:"T",
   latitude:"83.1167",
   longitude:"-69.0667"}
  ,
  {name:"Jaluit, Marshall Islands",
   type:"T",
   latitude:"5.9167",
   longitude:"169.6333"}
  ,
  {name:"Harwich, England",
   type:"T",
   latitude:"51.95",
   longitude:"1.2833"}
  ,
  {name:"Gonoura, Nagasaki, Japan",
   type:"T",
   latitude:"33.7333",
   longitude:"129.683"}
  ,
  {name:"Kay Point, Nunavut/NWT",
   type:"T",
   latitude:"69.2833",
   longitude:"-138.4333"}
  ,
  {name:"Irago, Aichi, Japan",
   type:"T",
   latitude:"34.5833",
   longitude:"137.017"}
  ,
  {name:"Cacouna Harbour, Québec",
   type:"T",
   latitude:"47.9333",
   longitude:"-69.5167"}
  ,
  {name:"Sorel, Québec",
   type:"T",
   latitude:"46.05",
   longitude:"-73.1167"}
  ,
  {name:"Sechelt Rapids, British Columbia Current",
   type:"C",
   latitude:"49.7383",
   longitude:"-123.8983"}
  ,
  {name:"Kotomari, Kurile Islands",
   type:"T",
   latitude:"50.8167",
   longitude:"156.5"}
  ,
  {name:"Bayonne Bridge, Kill van Kull, New York Current",
   type:"C",
   latitude:"40.6417",
   longitude:"-74.1433"}
  ,
  {name:"Ensenada, Baja California Norte, Mexico (3)",
   type:"T",
   latitude:"31.85",
   longitude:"-116.6333"}
  ,
  {name:"Point Tupper, Nova Scotia",
   type:"T",
   latitude:"45.6",
   longitude:"-61.3667"}
  ,
  {name:"North Goulburn Island, Australia",
   type:"T",
   latitude:"-11.55",
   longitude:"133.4333"}
  ,
  {name:"Creal Reef, Australia",
   type:"T",
   latitude:"-20.5333",
   longitude:"150.3667"}
  ,
  {name:"Diana Bay, Québec (2)",
   type:"T",
   latitude:"60.8667",
   longitude:"-70.0667"}
  ,
  {name:"Makwaziniht Island, British Columbia",
   type:"T",
   latitude:"50.55",
   longitude:"-127.55"}
  ,
  {name:"Kimitu, Tiba, Japan",
   type:"T",
   latitude:"35.35",
   longitude:"139.867"}
  ,
  {name:"Traverse St-Roch, Québec",
   type:"T",
   latitude:"47.4",
   longitude:"-70.2333"}
  ,
  {name:"Denman Island, British Columbia (2)",
   type:"T",
   latitude:"49.5333",
   longitude:"-124.8167"}
  ,
  {name:"Mosqueiro, Brazil",
   type:"T",
   latitude:"-1.1833",
   longitude:"-48.4667"}
  ,
  {name:"Ponta Delgada, São Miguel, Azores",
   type:"T",
   latitude:"37.7333",
   longitude:"-25.6667"}
  ,
  {name:"West Quoddy Head, Maine",
   type:"T",
   latitude:"44.8167",
   longitude:"-66.9667"}
  ,
  {name:"Bakar, Croatia",
   type:"T",
   latitude:"45.3",
   longitude:"14.5333"}
  ,
  {name:"Ensenada, Baja California Norte, Mexico (2)",
   type:"T",
   latitude:"31.85",
   longitude:"-116.6333"}
  ,
  {name:"Two Rocks Marina, Australia",
   type:"T",
   latitude:"-31.5",
   longitude:"115.5833"}
  ,
  {name:"Five Islands, Nova Scotia (2)",
   type:"T",
   latitude:"45.3833",
   longitude:"-64.0667"}
  ,
  {name:"Mizu-No-Ura (Kyusyu/w.), Nagasaki, Japan",
   type:"T",
   latitude:"32.75",
   longitude:"129.867"}
  ,
  {name:"Canaveral Harbor Entrance, Florida",
   type:"T",
   latitude:"28.4083",
   longitude:"-80.6017"}
  ,
  {name:"Gibsons Landing, British Columbia",
   type:"T",
   latitude:"49.4",
   longitude:"-123.05"}
  ,
  {name:"Port Moody, British Columbia",
   type:"T",
   latitude:"49.2833",
   longitude:"-122.8667"}
  ,
  {name:"Sendai (Kagosima), Kagosima, Japan",
   type:"T",
   latitude:"31.85",
   longitude:"130.217"}
  ,
  {name:"Savannah River Entrance, Georgia (2) (expired 1989-12-31)",
   type:"T",
   latitude:"32.0333",
   longitude:"-80.9017"}
  ,
  {name:"Deauville, France",
   type:"T",
   latitude:"49.22",
   longitude:"-0.05"}
  ,
  {name:"Santa Elena, Puerto, Argentina",
   type:"T",
   latitude:"-44.5167",
   longitude:"-65.3667"}
  ,
  {name:"Siriyamisaki, Aomori, Japan",
   type:"T",
   latitude:"41.4167",
   longitude:"141.433"}
  ,
  {name:"Cape Bounty, Nunavut",
   type:"T",
   latitude:"74.85",
   longitude:"-109.5333"}
  ,
  {name:"Kennedy Cove, British Columbia",
   type:"T",
   latitude:"49.15",
   longitude:"-125.6667"}
  ,
  {name:"Cape Legendre, Australia",
   type:"T",
   latitude:"-20.35",
   longitude:"116.8333"}
  ,
  {name:"Tosaki, Kagosima, Japan",
   type:"T",
   latitude:"31.65",
   longitude:"130.3"}
  ,
  {name:"Tern Island, Australia",
   type:"T",
   latitude:"-11.0",
   longitude:"142.75"}
  ,
  {name:"Syakotan, Hokkaido, Japan",
   type:"T",
   latitude:"43.8667",
   longitude:"146.817"}
  ,
  {name:"River Tees, England",
   type:"T",
   latitude:"54.6333",
   longitude:"-1.1667"}
  ,
  {name:"Uramu Island, Papua New Guinea",
   type:"T",
   latitude:"-7.6667",
   longitude:"144.65"}
  ,
  {name:"North Sydney, Nova Scotia (2)",
   type:"T",
   latitude:"46.2167",
   longitude:"-60.25"}
  ,
  {name:"Kisiwada, Osaka, Japan",
   type:"T",
   latitude:"34.4667",
   longitude:"135.367"}
  ,
  {name:"Belliveau Village, New Brunswick",
   type:"T",
   latitude:"45.9333",
   longitude:"-64.6167"}
  ,
  {name:"Burnie, Tasmania",
   type:"T",
   latitude:"-41.05",
   longitude:"145.95"}
  ,
  {name:"Jazirat Halul, Qatar",
   type:"T",
   latitude:"25.6667",
   longitude:"52.4"}
  ,
  {name:"Kingston, Australia",
   type:"T",
   latitude:"-36.8333",
   longitude:"139.85"}
  ,
  {name:"Daytona Beach (Ocean), Florida",
   type:"T",
   latitude:"29.2283",
   longitude:"-81.005"}
  ,
  {name:"Crescent Bay, Washington",
   type:"T",
   latitude:"48.1667",
   longitude:"-123.7333"}
  ,
  {name:"Cordova, Alaska",
   type:"T",
   latitude:"60.5583",
   longitude:"-145.7533"}
  ,
  {name:"Tuxpan, Veracruz, Mexico",
   type:"T",
   latitude:"21.0",
   longitude:"-97.3333"}
  ,
  {name:"Kota Kinabalu, Malaysia",
   type:"T",
   latitude:"5.9833",
   longitude:"116.0667"}
  ,
  {name:"Graham Pond, Prince Edward Island",
   type:"T",
   latitude:"46.1",
   longitude:"-62.45"}
  ,
  {name:"Hebron, Hebron Fjord, Labrador",
   type:"T",
   latitude:"58.1833",
   longitude:"-62.6167"}
  ,
  {name:"Onomichi, Japan",
   type:"T",
   latitude:"34.4",
   longitude:"133.1833"}
  ,
  {name:"Tomo, Hirosima, Japan",
   type:"T",
   latitude:"34.3833",
   longitude:"133.383"}
  ,
  {name:"Yunotu, Simane, Japan",
   type:"T",
   latitude:"35.1",
   longitude:"132.35"}
  ,
  {name:"Huangpu, China",
   type:"T",
   latitude:"23.0833",
   longitude:"113.4333"}
  ,
  {name:"Port Gregory, Australia",
   type:"T",
   latitude:"-28.2",
   longitude:"114.25"}
  ,
  {name:"Rib Reef, Australia",
   type:"T",
   latitude:"-18.4667",
   longitude:"146.8667"}
  ,
  {name:"Gabo Island, Australia",
   type:"T",
   latitude:"-37.5667",
   longitude:"149.9167"}
  ,
  {name:"William Head, British Columbia",
   type:"T",
   latitude:"48.3333",
   longitude:"-123.5333"}
  ,
  {name:"Hososima, Miyazaki, Japan",
   type:"T",
   latitude:"32.4333",
   longitude:"131.667"}
  ,
  {name:"Nakazato, Okinawa, Japan",
   type:"T",
   latitude:"26.35",
   longitude:"126.817"}
  ,
  {name:"North Point, Prince Edward Island",
   type:"T",
   latitude:"47.0667",
   longitude:"-63.9833"}
  ,
  {name:"Horten, Norway",
   type:"T",
   latitude:"59.4333",
   longitude:"10.5"}
  ,
  {name:"Al Fujayrah, U.A.E.",
   type:"T",
   latitude:"25.1333",
   longitude:"56.35"}
  ,
  {name:"Oamaru, New Zealand",
   type:"T",
   latitude:"-45.1",
   longitude:"170.9667"}
  ,
  {name:"Osaka, Osaka, Japan",
   type:"T",
   latitude:"34.65",
   longitude:"135.433"}
  ,
  {name:"Point Reyes, California",
   type:"T",
   latitude:"37.9967",
   longitude:"-122.975"}
  ,
  {name:"Navarre Beach, Florida",
   type:"T",
   latitude:"30.3767",
   longitude:"-86.865"}
  ,
  {name:"Darnley Island, Coral Sea",
   type:"T",
   latitude:"-9.6",
   longitude:"143.7667"}
  ,
  {name:"Portland, England (2)",
   type:"T",
   latitude:"50.5667",
   longitude:"-2.4333"}
  ,
  {name:"Viana do Castelo, Portugal",
   type:"T",
   latitude:"41.6833",
   longitude:"-8.8333"}
  ,
  {name:"Hagemeister Island (north end), Alaska",
   type:"T",
   latitude:"58.7767",
   longitude:"-160.7767"}
  ,
  {name:"Hentona, Okinawa, Japan",
   type:"T",
   latitude:"26.75",
   longitude:"128.183"}
  ,
  {name:"Stopper Islands, British Columbia (2)",
   type:"T",
   latitude:"49.0",
   longitude:"-125.35"}
  ,
  {name:"Aden, Yemen (2)",
   type:"T",
   latitude:"12.7833",
   longitude:"44.9833"}
  ,
  {name:"Hólmavík, Iceland",
   type:"T",
   latitude:"65.705",
   longitude:"-21.725"}
  ,
  {name:"Lushun, China",
   type:"T",
   latitude:"38.8",
   longitude:"121.25"}
  ,
  {name:"Bahía de los Ángeles, Baja California Norte, Mexico",
   type:"T",
   latitude:"28.95",
   longitude:"-113.55"}
  ,
  {name:"Longbranch (USCOE dredge depot), Florida (2)",
   type:"T",
   latitude:"30.36",
   longitude:"-81.62"}
  ,
  {name:"Akureyri, Iceland (2)",
   type:"T",
   latitude:"65.6833",
   longitude:"-18.1167"}
  ,
  {name:"Wakamatu (Kanmon), Hukuoka, Japan",
   type:"T",
   latitude:"33.9",
   longitude:"130.817"}
  ,
  {name:"Miya, Aichi, Japan",
   type:"T",
   latitude:"34.8167",
   longitude:"137.25"}
  ,
  {name:"Murphy Cove, Nova Scotia",
   type:"T",
   latitude:"44.7833",
   longitude:"-62.75"}
  ,
  {name:"Cape Jack, Nova Scotia",
   type:"T",
   latitude:"45.7",
   longitude:"-61.55"}
  ,
  {name:"Boca De Cangrejos, Isla Verde, San Juan, Puerto Rico",
   type:"T",
   latitude:"18.46",
   longitude:"-65.9933"}
  ,
  {name:"Hukusima (Sibusi Wan), Miyazaki, Japan",
   type:"T",
   latitude:"31.45",
   longitude:"131.2"}
  ,
  {name:"Sandheads (Station Harry), British Columbia",
   type:"T",
   latitude:"49.1333",
   longitude:"-123.2833"}
  ,
  {name:"Simonoseki Sanbasi, Yamaguti, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"130.933"}
  ,
  {name:"Omu, Hokkaido, Japan",
   type:"T",
   latitude:"44.5833",
   longitude:"142.967"}
  ,
  {name:"Cunningham Inlet, Nunavut",
   type:"T",
   latitude:"74.1333",
   longitude:"-93.8833"}
  ,
  {name:"Onoda, Yamaguti, Japan",
   type:"T",
   latitude:"33.9667",
   longitude:"131.183"}
  ,
  {name:"Port Hawkesbury, Nova Scotia",
   type:"T",
   latitude:"45.6167",
   longitude:"-61.3667"}
  ,
  {name:"Tago, Sizuoka, Japan",
   type:"T",
   latitude:"34.8",
   longitude:"138.767"}
  ,
  {name:"Puerto Angel, Oaxaca, Mexico",
   type:"T",
   latitude:"15.6567",
   longitude:"-96.4933"}
  ,
  {name:"Adele Island, Australia",
   type:"T",
   latitude:"-15.5167",
   longitude:"123.15"}
  ,
  {name:"Daikon Sima, Simane, Japan",
   type:"T",
   latitude:"35.5",
   longitude:"133.167"}
  ,
  {name:"Kralendijk, Bonaire",
   type:"T",
   latitude:"12.15",
   longitude:"-68.2833"}
  ,
  {name:"Point Atkinson, British Columbia",
   type:"T",
   latitude:"49.3333",
   longitude:"-123.25"}
  ,
  {name:"Portsmouth, England",
   type:"T",
   latitude:"50.8",
   longitude:"-1.1167"}
  ,
  {name:"Saint Thomas, Saint Thomas",
   type:"T",
   latitude:"18.3333",
   longitude:"-64.9333"}
  ,
  {name:"Hirosima, Hirosima, Japan",
   type:"T",
   latitude:"34.35",
   longitude:"132.467"}
  ,
  {name:"North West Island, Australia",
   type:"T",
   latitude:"-20.3667",
   longitude:"115.5167"}
  ,
  {name:"Arkhangel'sk, Russia",
   type:"T",
   latitude:"64.5333",
   longitude:"40.4833"}
  ,
  {name:"Doctors Lake, Peoria Point, Florida (2)",
   type:"T",
   latitude:"30.12",
   longitude:"-81.7583"}
  ,
  {name:"Sugawa, Nagasaki, Japan",
   type:"T",
   latitude:"32.65",
   longitude:"130.3"}
  ,
  {name:"Bilbao, Spain",
   type:"T",
   latitude:"43.3333",
   longitude:"-3.0333"}
  ,
  {name:"Rota, Spain",
   type:"T",
   latitude:"36.6167",
   longitude:"-6.35"}
  ,
  {name:"Guam, Marianas",
   type:"T",
   latitude:"13.33",
   longitude:"144.66"}
  ,
  {name:"Gold River, British Columbia (2)",
   type:"T",
   latitude:"49.6833",
   longitude:"-126.1333"}
  ,
  {name:"Minami-Daito Sima, Okinawa, Japan",
   type:"T",
   latitude:"25.8167",
   longitude:"131.233"}
  ,
  {name:"Tanabe, Wakayama, Japan",
   type:"T",
   latitude:"33.7167",
   longitude:"135.367"}
  ,
  {name:"Puerto Iradier, Equatorial Guinea",
   type:"T",
   latitude:"1.0833",
   longitude:"9.7"}
  ,
  {name:"Gabriola Pass, British Columbia",
   type:"T",
   latitude:"49.1333",
   longitude:"-123.7167"}
  ,
  {name:"Westport, New Zealand",
   type:"T",
   latitude:"-41.75",
   longitude:"171.6"}
  ,
  {name:"Alameda, San Francisco Bay, California",
   type:"T",
   latitude:"37.7717",
   longitude:"-122.2983"}
  ,
  {name:"Piney Point, St. Johns River, Florida",
   type:"T",
   latitude:"30.2283",
   longitude:"-81.6633"}
  ,
  {name:"Pugwash, Nova Scotia",
   type:"T",
   latitude:"45.85",
   longitude:"-63.6833"}
  ,
  {name:"Mayport (ferry dock), Florida (5)",
   type:"T",
   latitude:"30.3917",
   longitude:"-81.4317"}
  ,
  {name:"Saltery Bay, British Columbia",
   type:"T",
   latitude:"49.7833",
   longitude:"-124.1833"}
  ,
  {name:"Davis Strait, Nunavut",
   type:"T",
   latitude:"66.2667",
   longitude:"-58.3833"}
  ,
  {name:"Ucluelet, British Columbia",
   type:"T",
   latitude:"48.95",
   longitude:"-125.55"}
  ,
  {name:"Doctors Lake, Peoria Point, Florida (3)",
   type:"T",
   latitude:"30.12",
   longitude:"-81.7583"}
  ,
  {name:"Kiritappu, Hokkaido, Japan",
   type:"T",
   latitude:"43.0833",
   longitude:"145.133"}
  ,
  {name:"Riley Cove, British Columbia",
   type:"T",
   latitude:"49.3833",
   longitude:"-126.2167"}
  ,
  {name:"Admiralty Inlet, Washington Current",
   type:"C",
   latitude:"48.03",
   longitude:"-122.6367"}
  ,
  {name:"Izumozaki, Niigata, Japan",
   type:"T",
   latitude:"37.55",
   longitude:"138.667"}
  ,
  {name:"Bonny, Nigeria",
   type:"T",
   latitude:"4.45",
   longitude:"7.1667"}
  ,
  {name:"Yagi, Iwate, Japan",
   type:"T",
   latitude:"40.35",
   longitude:"141.767"}
  ,
  {name:"Savage Harbour, Prince Edward Island",
   type:"T",
   latitude:"46.4333",
   longitude:"-62.85"}
  ,
  {name:"Johnstown, Nova Scotia",
   type:"T",
   latitude:"45.8",
   longitude:"-60.75"}
  ,
  {name:"Mayport (ferry dock), Florida (4)",
   type:"T",
   latitude:"30.3917",
   longitude:"-81.4317"}
  ,
  {name:"Seal Cove, British Columbia (2)",
   type:"T",
   latitude:"54.3333",
   longitude:"-130.2833"}
  ,
  {name:"Nosiro, Akita, Japan",
   type:"T",
   latitude:"40.2167",
   longitude:"140.0"}
  ,
  {name:"Valdes Island, British Columbia",
   type:"T",
   latitude:"49.05",
   longitude:"-123.6167"}
  ,
  {name:"Ste-Anne-De-Beaupré, Québec",
   type:"T",
   latitude:"47.0167",
   longitude:"-70.9333"}
  ,
  {name:"Carelmapu, Chile",
   type:"T",
   latitude:"-41.75",
   longitude:"-73.7167"}
  ,
  {name:"Mo i Rana, Norway",
   type:"T",
   latitude:"66.3167",
   longitude:"14.1333"}
  ,
  {name:"Carnarvon, Australia (2)",
   type:"T",
   latitude:"-24.7833",
   longitude:"113.65"}
  ,
  {name:"Kiyobe, Hokkaido, Japan",
   type:"T",
   latitude:"41.5333",
   longitude:"140.0"}
  ,
  {name:"Depuch Island, Australia",
   type:"T",
   latitude:"-20.6167",
   longitude:"117.75"}
  ,
  {name:"Nagayama, Okinawa, Japan",
   type:"T",
   latitude:"24.8",
   longitude:"125.2"}
  ,
  {name:"Steamboat Island, Australia",
   type:"T",
   latitude:"-20.8167",
   longitude:"116.0667"}
  ,
  {name:"Quequen, Argentina",
   type:"T",
   latitude:"-38.5833",
   longitude:"-58.7"}
  ,
  {name:"Bukhta Broutona, Kurile Islands",
   type:"T",
   latitude:"47.15",
   longitude:"152.25"}
  ,
  {name:"Shaat al Arab, Iraq",
   type:"T",
   latitude:"29.8333",
   longitude:"48.7167"}
  ,
  {name:"Toyama, Toyama, Japan",
   type:"T",
   latitude:"36.7667",
   longitude:"137.233"}
  ,
  {name:"Chatham Point, British Columbia (2)",
   type:"T",
   latitude:"50.0333",
   longitude:"-125.4333"}
  ,
  {name:"Sheerness, England (2)",
   type:"T",
   latitude:"51.45",
   longitude:"0.75"}
  ,
  {name:"Ste-Anne-Des-Monts, Québec",
   type:"T",
   latitude:"49.1333",
   longitude:"-66.4833"}
  ,
  {name:"Mayport (ferry dock), Florida (3)",
   type:"T",
   latitude:"30.3917",
   longitude:"-81.4317"}
  ,
  {name:"Taiohae, Marquesas Islands",
   type:"T",
   latitude:"-8.9167",
   longitude:"-140.1"}
  ,
  {name:"Galle, Sri Lanka",
   type:"T",
   latitude:"6.0333",
   longitude:"80.2167"}
  ,
  {name:"Shields Bay, British Columbia (2)",
   type:"T",
   latitude:"53.3167",
   longitude:"-132.4167"}
  ,
  {name:"Ashmore Reef, Australia",
   type:"T",
   latitude:"-12.2167",
   longitude:"123.0167"}
  ,
  {name:"Hurukamappu Wan, Hokkaido, Japan",
   type:"T",
   latitude:"44.0333",
   longitude:"145.85"}
  ,
  {name:"Hanga Piko, Easter Island (2)",
   type:"T",
   latitude:"-27.15",
   longitude:"-109.45"}
  ,
  {name:"Wasini Island, Kenya",
   type:"T",
   latitude:"-4.65",
   longitude:"39.35"}
  ,
  {name:"Isikawa, Okinawa, Japan",
   type:"T",
   latitude:"26.4167",
   longitude:"127.85"}
  ,
  {name:"South Pass, Louisiana",
   type:"T",
   latitude:"28.99",
   longitude:"-89.14"}
  ,
  {name:"Büsum, Germany",
   type:"T",
   latitude:"54.1167",
   longitude:"8.85"}
  ,
  {name:"Kariya (Osaka Wan), Hyogo, Japan",
   type:"T",
   latitude:"34.5167",
   longitude:"135.0"}
  ,
  {name:"Mayport (ferry dock), Florida (2)",
   type:"T",
   latitude:"30.3917",
   longitude:"-81.4317"}
  ,
  {name:"Hukuro Ura, Kumamoto, Japan",
   type:"T",
   latitude:"32.1833",
   longitude:"130.367"}
  ,
  {name:"Twin Island, Torres Strait (2)",
   type:"T",
   latitude:"-10.4667",
   longitude:"142.4333"}
  ,
  {name:"Pisiktarfik Island, Nunavut",
   type:"T",
   latitude:"72.5833",
   longitude:"-80.05"}
  ,
  {name:"Kikori, Papua New Guinea (2)",
   type:"T",
   latitude:"-7.4167",
   longitude:"144.25"}
  ,
  {name:"Norwegian Bay, Australia",
   type:"T",
   latitude:"-22.5667",
   longitude:"113.7"}
  ,
  {name:"San Juan Channel (South Entrance), Washington Current",
   type:"C",
   latitude:"48.4667",
   longitude:"-122.95"}
  ,
  {name:"Baie Des Moutons, Québec",
   type:"T",
   latitude:"50.7667",
   longitude:"-59.0333"}
  ,
  {name:"Kogusi, Okayama, Japan",
   type:"T",
   latitude:"34.6",
   longitude:"134.033"}
  ,
  {name:"Mizushima, Japan",
   type:"T",
   latitude:"34.5167",
   longitude:"133.7333"}
  ,
  {name:"Bahía de Ballenas, Baja California Sur, Mexico",
   type:"T",
   latitude:"26.7167",
   longitude:"-113.5667"}
  ,
  {name:"Terschelling, Netherlands",
   type:"T",
   latitude:"53.3667",
   longitude:"5.2167"}
  ,
  {name:"Port Washington, Manhasset Bay, Long Island Sound, New York",
   type:"T",
   latitude:"40.8333",
   longitude:"-73.7"}
  ,
  {name:"Grande Entree, Nova Scotia",
   type:"T",
   latitude:"47.55",
   longitude:"-61.55"}
  ,
  {name:"Raine Island, Endeavour Strait",
   type:"T",
   latitude:"-11.6",
   longitude:"144.05"}
  ,
  {name:"Neville Island, Labrador",
   type:"T",
   latitude:"52.55",
   longitude:"-56.1167"}
  ,
  {name:"Komatusima, Tokusima, Japan",
   type:"T",
   latitude:"34.0",
   longitude:"134.583"}
  ,
  {name:"Zariv Natalii, Kurile Islands",
   type:"T",
   latitude:"46.1",
   longitude:"150.167"}
  ,
  {name:"Seymour Narrows, British Columbia Current",
   type:"C",
   latitude:"50.1333",
   longitude:"-125.35"}
  ,
  {name:"Brundige Inlet, British Columbia (2)",
   type:"T",
   latitude:"54.6167",
   longitude:"-130.85"}
  ,
  {name:"Jazirat Das, U.A.E.",
   type:"T",
   latitude:"25.15",
   longitude:"52.8833"}
  ,
  {name:"Little River, British Columbia (2)",
   type:"T",
   latitude:"49.7333",
   longitude:"-124.9167"}
  ,
  {name:"Porto Corsini, Italy",
   type:"T",
   latitude:"44.5",
   longitude:"12.2833"}
  ,
  {name:"Hamilton Bank 789, Labrador",
   type:"T",
   latitude:"53.7333",
   longitude:"-55.45"}
  ,
  {name:"Iwaya (Awazi Sima), Hyogo, Japan",
   type:"T",
   latitude:"34.6",
   longitude:"135.017"}
  ,
  {name:"Marblehead Channel, Massachusetts Current",
   type:"C",
   latitude:"42.5",
   longitude:"-70.8167"}
  ,
  {name:"Obbia, Somalia (2)",
   type:"T",
   latitude:"5.3333",
   longitude:"48.5"}
  ,
  {name:"Barnard Harbour, British Columbia (2)",
   type:"T",
   latitude:"53.0833",
   longitude:"-129.1167"}
  ,
  {name:"Vancouver, British Columbia (2)",
   type:"T",
   latitude:"49.2833",
   longitude:"-123.1167"}
  ,
  {name:"Iluka, Australia",
   type:"T",
   latitude:"-29.4167",
   longitude:"153.3667"}
  ,
  {name:"Key West (Naval Base), Florida",
   type:"T",
   latitude:"24.5533",
   longitude:"-81.8083"}
  ,
  {name:"Fundy (Offshore 4), Nova Scotia",
   type:"T",
   latitude:"40.75",
   longitude:"-66.85"}
  ,
  {name:"Mayport (ferry dock), Florida (8)",
   type:"T",
   latitude:"30.3917",
   longitude:"-81.4317"}
  ,
  {name:"Awase, Okinawa, Japan",
   type:"T",
   latitude:"26.3167",
   longitude:"127.85"}
  ,
  {name:"Aransas Channel, Texas",
   type:"T",
   latitude:"27.8383",
   longitude:"-97.0517"}
  ,
  {name:"Broad Cove Marsh, Nova Scotia",
   type:"T",
   latitude:"46.3",
   longitude:"-61.2667"}
  ,
  {name:"Pelican Harbour, Abaco Island, Bahamas",
   type:"T",
   latitude:"26.3833",
   longitude:"-76.9667"}
  ,
  {name:"Catalina Harbor, California",
   type:"T",
   latitude:"33.4317",
   longitude:"-118.5033"}
  ,
  {name:"Sarina Inlet, Australia",
   type:"T",
   latitude:"-21.4",
   longitude:"149.3333"}
  ,
  {name:"Marsden Point, New Zealand (2)",
   type:"T",
   latitude:"-35.8333",
   longitude:"174.5"}
  ,
  {name:"La Jolla, Scripps Pier, California (2)",
   type:"T",
   latitude:"32.8667",
   longitude:"-117.2567"}
  ,
  {name:"Lord Howe Island, Tasman Sea",
   type:"T",
   latitude:"-31.5333",
   longitude:"159.0667"}
  ,
  {name:"Old Tracadie Gully entrance, New Brunswick",
   type:"T",
   latitude:"47.5167",
   longitude:"-64.8667"}
  ,
  {name:"Takasima, Nagasaki, Japan",
   type:"T",
   latitude:"32.65",
   longitude:"129.75"}
  ,
  {name:"Vancouver, British Columbia (3)",
   type:"T",
   latitude:"49.2833",
   longitude:"-123.1167"}
  ,
  {name:"Wakamatu (Goto), Nagasaki, Japan",
   type:"T",
   latitude:"32.8833",
   longitude:"129.017"}
  ,
  {name:"Eskimo Point, Nunavut",
   type:"T",
   latitude:"61.1167",
   longitude:"-94.0667"}
  ,
  {name:"Bedford Institute, Nova Scotia",
   type:"T",
   latitude:"44.6833",
   longitude:"-63.6167"}
  ,
  {name:"Clearwater Beach, Florida",
   type:"T",
   latitude:"27.9767",
   longitude:"-82.8317"}
  ,
  {name:"Eastport, Maine",
   type:"T",
   latitude:"44.9033",
   longitude:"-66.985"}
  ,
  {name:"Mayport (ferry dock), Florida (7)",
   type:"T",
   latitude:"30.3917",
   longitude:"-81.4317"}
  ,
  {name:"Cardwell, Australia",
   type:"T",
   latitude:"-18.2667",
   longitude:"146.0167"}
  ,
  {name:"Ogi Sima, Kagawa, Japan",
   type:"T",
   latitude:"34.4333",
   longitude:"134.05"}
  ,
  {name:"San Blas, Argentina",
   type:"T",
   latitude:"-40.55",
   longitude:"-62.2333"}
  ,
  {name:"Bata, Equatorial Guinea",
   type:"T",
   latitude:"1.8667",
   longitude:"9.7667"}
  ,
  {name:"Otabu Sima, Okayama, Japan",
   type:"T",
   latitude:"34.6833",
   longitude:"134.3"}
  ,
  {name:"Cape Sorell, Pilot Bay, Tasmania",
   type:"T",
   latitude:"-42.2",
   longitude:"145.2167"}
  ,
  {name:"Bear Island, Nunavut",
   type:"T",
   latitude:"54.35",
   longitude:"-81.0833"}
  ,
  {name:"Resolute, Nunavut (2)",
   type:"T",
   latitude:"74.6833",
   longitude:"-94.9"}
  ,
  {name:"Miho, Sizuoka, Japan",
   type:"T",
   latitude:"35.0",
   longitude:"138.517"}
  ,
  {name:"Esquimalt, British Columbia (2)",
   type:"T",
   latitude:"48.4333",
   longitude:"-123.4333"}
  ,
  {name:"Oki (Kanmon), Hukuoka, Japan",
   type:"T",
   latitude:"33.8667",
   longitude:"130.75"}
  ,
  {name:"Unnamed Reef No. 1, Australia",
   type:"T",
   latitude:"-17.8667",
   longitude:"146.7167"}
  ,
  {name:"Kingsley Creek, RR. bridge, Florida (2)",
   type:"T",
   latitude:"30.6317",
   longitude:"-81.4767"}
  ,
  {name:"Mayport (ferry dock), Florida (6)",
   type:"T",
   latitude:"30.3917",
   longitude:"-81.4317"}
  ,
  {name:"Benner Bay, St. Thomas, Virgin Islands",
   type:"T",
   latitude:"18.32",
   longitude:"-64.87"}
  ,
  {name:"Tamanoura, Nagasaki, Japan",
   type:"T",
   latitude:"32.6167",
   longitude:"128.617"}
  ,
  {name:"Zamami, Okinawa, Japan",
   type:"T",
   latitude:"26.2167",
   longitude:"127.3"}
  ,
  {name:"Mito (Utiura), Sizuoka, Japan",
   type:"T",
   latitude:"35.0167",
   longitude:"138.9"}
  ,
  {name:"Neko, Antarctica",
   type:"T",
   latitude:"-64.8",
   longitude:"-62.3833"}
  ,
  {name:"Thio, New Caledonia",
   type:"T",
   latitude:"-21.6167",
   longitude:"166.2333"}
  ,
  {name:"Samuel Island (North Shore), British Columbia",
   type:"T",
   latitude:"48.8167",
   longitude:"-123.2"}
  ,
  {name:"Yavaros, Sonora, Mexico (2)",
   type:"T",
   latitude:"26.7",
   longitude:"-109.5"}
  ,
  {name:"Baillie Island, Nunavut/NWT",
   type:"T",
   latitude:"70.55",
   longitude:"-128.1333"}
  ,
  {name:"Funchal, Madeira",
   type:"T",
   latitude:"32.6333",
   longitude:"-16.9167"}
  ,
  {name:"Longbranch (USCOE dredge depot), Florida (5)",
   type:"T",
   latitude:"30.36",
   longitude:"-81.62"}
  ,
  {name:"Aberystwyth, Wales",
   type:"T",
   latitude:"52.4",
   longitude:"-4.0833"}
  ,
  {name:"Clarks Harbour, Nova Scotia",
   type:"T",
   latitude:"43.45",
   longitude:"-65.6333"}
  ,
  {name:"Economy (Inshore 5), Nova Scotia",
   type:"T",
   latitude:"45.3167",
   longitude:"-63.9"}
  ,
  {name:"La Plata, Argentina",
   type:"T",
   latitude:"-34.8333",
   longitude:"-57.8833"}
  ,
  {name:"Bhavnagar, India",
   type:"T",
   latitude:"21.8",
   longitude:"72.15"}
  ,
  {name:"Sikine Sima, Tokyo, Japan",
   type:"T",
   latitude:"34.3167",
   longitude:"139.217"}
  ,
  {name:"Big Bay, British Columbia",
   type:"T",
   latitude:"50.4",
   longitude:"-125.1333"}
  ,
  {name:"Bassein, Myanmar",
   type:"T",
   latitude:"16.7833",
   longitude:"94.7833"}
  ,
  {name:"Greely Fiord, Nunavut",
   type:"T",
   latitude:"80.6",
   longitude:"-79.5833"}
  ,
  {name:"Balikpapan, Borneo, Indonesia",
   type:"T",
   latitude:"-1.2667",
   longitude:"116.8"}
  ,
  {name:"Little Whale River, Québec",
   type:"T",
   latitude:"56.0",
   longitude:"-74.7667"}
  ,
  {name:"Fourchu, Nova Scotia",
   type:"T",
   latitude:"45.7167",
   longitude:"-60.25"}
  ,
  {name:"High Peak Island, Australia",
   type:"T",
   latitude:"-21.95",
   longitude:"150.6833"}
  ,
  {name:"Patos Island, Washington",
   type:"T",
   latitude:"48.7833",
   longitude:"-122.9667"}
  ,
  {name:"Mitlenatch Island, British Columbia",
   type:"T",
   latitude:"49.95",
   longitude:"-125.0"}
  ,
  {name:"Long Island, Nunavut",
   type:"T",
   latitude:"54.7667",
   longitude:"-79.7333"}
  ,
  {name:"Longbranch (USCOE dredge depot), Florida (6)",
   type:"T",
   latitude:"30.36",
   longitude:"-81.62"}
  ,
  {name:"First Narrows, British Columbia Current",
   type:"C",
   latitude:"49.3167",
   longitude:"-123.1333"}
  ,
  {name:"Inubo Saki, Tiba, Japan",
   type:"T",
   latitude:"35.7",
   longitude:"140.867"}
  ,
  {name:"Tavernier, Florida",
   type:"T",
   latitude:"25.005",
   longitude:"-80.5167"}
  ,
  {name:"St. Barbe Bay, Newfoundland",
   type:"T",
   latitude:"51.2",
   longitude:"-56.7667"}
  ,
  {name:"Tobata, Hukuoka, Japan",
   type:"T",
   latitude:"33.9",
   longitude:"130.817"}
  ,
  {name:"Cape Saint James, British Columbia (2)",
   type:"T",
   latitude:"51.9333",
   longitude:"-131.0167"}
  ,
  {name:"Zyo-Ga-Sima, Kanagawa, Japan",
   type:"T",
   latitude:"35.1333",
   longitude:"139.617"}
  ,
  {name:"Bay Of Woe, Nunavut",
   type:"T",
   latitude:"76.4167",
   longitude:"-89.0667"}
  ,
  {name:"Shaw Island, Australia",
   type:"T",
   latitude:"-20.5",
   longitude:"149.0667"}
  ,
  {name:"Port Union, Newfoundland",
   type:"T",
   latitude:"48.5",
   longitude:"-53.0833"}
  ,
  {name:"Newcastle, Australia (2)",
   type:"T",
   latitude:"-32.9333",
   longitude:"151.7833"}
  ,
  {name:"Chinnampo, North Korea",
   type:"T",
   latitude:"38.6833",
   longitude:"125.3833"}
  ,
  {name:"Narvik, Norway (2)",
   type:"T",
   latitude:"68.4333",
   longitude:"17.4167"}
  ,
  {name:"Kodai, Nagasaki, Japan",
   type:"T",
   latitude:"33.0667",
   longitude:"129.75"}
  ,
  {name:"Port Hedland, Australia (2)",
   type:"T",
   latitude:"-20.3",
   longitude:"118.5833"}
  ,
  {name:"Rosales, Argentina",
   type:"T",
   latitude:"-38.9167",
   longitude:"-62.0667"}
  ,
  {name:"Parkers Cove, Nova Scotia (2)",
   type:"T",
   latitude:"44.8",
   longitude:"-65.5333"}
  ,
  {name:"Longbranch (USCOE dredge depot), Florida (3)",
   type:"T",
   latitude:"30.36",
   longitude:"-81.62"}
  ,
  {name:"Awazu, Tokusima, Japan",
   type:"T",
   latitude:"34.1333",
   longitude:"134.617"}
  ,
  {name:"Meaipe, Brazil",
   type:"T",
   latitude:"-20.75",
   longitude:"-40.5333"}
  ,
  {name:"Sydney, Australia",
   type:"T",
   latitude:"-33.85",
   longitude:"151.2333"}
  ,
  {name:"Titi Sima, Tokyo, Japan",
   type:"T",
   latitude:"27.0833",
   longitude:"142.183"}
  ,
  {name:"Koyo, Hirosima, Japan",
   type:"T",
   latitude:"34.2333",
   longitude:"132.717"}
  ,
  {name:"Daru, Papua New Guinea",
   type:"T",
   latitude:"-9.0667",
   longitude:"143.2"}
  ,
  {name:"Port Louis, British Columbia (2)",
   type:"T",
   latitude:"53.6833",
   longitude:"-132.9667"}
  ,
  {name:"Nususonga, Solomon Islands",
   type:"T",
   latitude:"-8.3333",
   longitude:"157.2333"}
  ,
  {name:"Oku-No-Uti, Hirosima, Japan",
   type:"T",
   latitude:"34.15",
   longitude:"132.533"}
  ,
  {name:"Kodiak, Alaska (2)",
   type:"T",
   latitude:"57.7833",
   longitude:"-152.4"}
  ,
  {name:"Longbranch (USCOE dredge depot), Florida (4)",
   type:"T",
   latitude:"30.36",
   longitude:"-81.62"}
  ,
  {name:"Lorient, France",
   type:"T",
   latitude:"47.75",
   longitude:"-3.35"}
  ,
  {name:"Ao Sima, Ehime, Japan",
   type:"T",
   latitude:"33.7333",
   longitude:"132.483"}
  ,
  {name:"Quathiaski Cove, British Columbia (2)",
   type:"T",
   latitude:"50.05",
   longitude:"-125.2167"}
  ,
  {name:"Cape Dyer, Baffin Island, Nunavut",
   type:"T",
   latitude:"66.55",
   longitude:"-61.0667"}
  ,
  {name:"Smithers Island, British Columbia (2)",
   type:"T",
   latitude:"52.75",
   longitude:"-129.0667"}
  ,
  {name:"Hammerfest, Norway",
   type:"T",
   latitude:"70.6667",
   longitude:"23.6833"}
  ,
  {name:"Indian Harbour, Nova Scotia",
   type:"T",
   latitude:"44.5167",
   longitude:"-63.9333"}
  ,
  {name:"Yakutat, Yakutat Bay, Alaska (2)",
   type:"T",
   latitude:"59.5483",
   longitude:"-139.735"}
  ,
  {name:"Everett, Washington",
   type:"T",
   latitude:"47.9833",
   longitude:"-122.2167"}
  ,
  {name:"La Tabatière, Québec",
   type:"T",
   latitude:"50.8333",
   longitude:"-58.9667"}
  ,
  {name:"Sasebo, Nagasaki, Japan (2)",
   type:"T",
   latitude:"33.1667",
   longitude:"129.7"}
  ,
  {name:"Trois-Rivières, Québec",
   type:"T",
   latitude:"46.35",
   longitude:"-72.55"}
  ,
  {name:"Yosioka, Hokkaido, Japan",
   type:"T",
   latitude:"41.45",
   longitude:"140.233"}
  ,
  {name:"Sullivan Bay, British Columbia (2)",
   type:"T",
   latitude:"50.8833",
   longitude:"-126.0833"}
  ,
  {name:"Tiverton (Boar's Head), St. Mary Bay, Nova Scotia",
   type:"T",
   latitude:"44.4",
   longitude:"-66.2167"}
  ,
  {name:"Hopedale, Labrador",
   type:"T",
   latitude:"55.45",
   longitude:"-60.2167"}
  ,
  {name:"Aburatubo, Kanagawa, Japan",
   type:"T",
   latitude:"35.15",
   longitude:"139.617"}
  ,
  {name:"Casey, Antarctica",
   type:"T",
   latitude:"-66.25",
   longitude:"110.5167"}
  ,
  {name:"Iqaluit, Nunavut (2)",
   type:"T",
   latitude:"63.7167",
   longitude:"-68.5333"}
  ,
  {name:"Alberton, Prince Edward Island",
   type:"T",
   latitude:"46.8",
   longitude:"-64.0667"}
  ,
  {name:"Shortland Island, Solomon Islands",
   type:"T",
   latitude:"-10.5333",
   longitude:"151.0833"}
  ,
  {name:"Salisbury, Maryland (2 miles below) Current",
   type:"C",
   latitude:"38.34",
   longitude:"-75.6383"}
  ,
  {name:"Murotozaki, Koti, Japan",
   type:"T",
   latitude:"33.2667",
   longitude:"134.167"}
  ,
  {name:"Wakayama, Wakayama, Japan (2)",
   type:"T",
   latitude:"34.2167",
   longitude:"135.15"}
  ,
  {name:"Apalachicola, Apalachicola Bay, Florida",
   type:"T",
   latitude:"29.7267",
   longitude:"-84.9817"}
  ,
  {name:"Dunedin, New Zealand",
   type:"T",
   latitude:"-45.8833",
   longitude:"170.5"}
  ,
  {name:"False Strait, Nunavut",
   type:"T",
   latitude:"71.9667",
   longitude:"-95.1667"}
  ,
  {name:"Woodlark Island, Papua New Guinea (2)",
   type:"T",
   latitude:"-9.25",
   longitude:"152.9667"}
  ,
  {name:"Alameda, San Francisco Bay, California (2)",
   type:"T",
   latitude:"37.7717",
   longitude:"-122.2983"}
  ,
  {name:"Cape Hatteras (fishing pier), North Carolina (3)",
   type:"T",
   latitude:"35.2233",
   longitude:"-75.635"}
  ,
  {name:"Jacksonville, Navy Fuel Depot, St. Johns River, Florida (3)",
   type:"T",
   latitude:"30.4",
   longitude:"-81.6267"}
  ,
  {name:"Larsen Island, British Columbia",
   type:"T",
   latitude:"53.6167",
   longitude:"-130.5667"}
  ,
  {name:"Orange Park, St. Johns River, Florida",
   type:"T",
   latitude:"30.1683",
   longitude:"-81.695"}
  ,
  {name:"Pointe Noire, Congo",
   type:"T",
   latitude:"-4.7833",
   longitude:"11.8333"}
  ,
  {name:"Powell River (Strait of Georgia), British Columbia",
   type:"T",
   latitude:"49.8667",
   longitude:"-124.55"}
  ,
  {name:"Ad Dawhah, Qatar",
   type:"T",
   latitude:"25.3",
   longitude:"51.5167"}
  ,
  {name:"Port Vincent, Australia",
   type:"T",
   latitude:"-34.7667",
   longitude:"137.85"}
  ,
  {name:"Saint-Malo, France",
   type:"T",
   latitude:"48.6333",
   longitude:"-2.0333"}
  ,
  {name:"Yavaros, Sonora, Mexico",
   type:"T",
   latitude:"26.7",
   longitude:"-109.5"}
  ,
  {name:"Skinner Cove, Nova Scotia",
   type:"T",
   latitude:"45.8",
   longitude:"-63.05"}
  ,
  {name:"Charlotte Amalie, St. Thomas, Virgin Islands",
   type:"T",
   latitude:"18.335",
   longitude:"-64.9183"}
  ,
  {name:"Eureka, Humboldt Bay, California (2)",
   type:"T",
   latitude:"40.75",
   longitude:"-124.2333"}
  ,
  {name:"La Grande Rivière, Québec",
   type:"T",
   latitude:"53.8167",
   longitude:"-78.9167"}
  ,
  {name:"Long Harbour, Newfoundland",
   type:"T",
   latitude:"47.4333",
   longitude:"-54.8167"}
  ,
  {name:"Lance Cove, Newfoundland",
   type:"T",
   latitude:"47.0833",
   longitude:"-52.0333"}
  ,
  {name:"Maatsuyker Island, Tasmania",
   type:"T",
   latitude:"-43.6667",
   longitude:"146.3167"}
  ,
  {name:"North Arm, British Columbia",
   type:"T",
   latitude:"49.0833",
   longitude:"-123.1333"}
  ,
  {name:"Seward, Resurrection Bay, Alaska (2)",
   type:"T",
   latitude:"60.1",
   longitude:"-149.45"}
  ,
  {name:"Lawyer Islands, British Columbia",
   type:"T",
   latitude:"54.1333",
   longitude:"-130.3333"}
  ,
  {name:"Tomales Bay Entrance, California",
   type:"T",
   latitude:"38.2283",
   longitude:"-122.9767"}
  ,
  {name:"Saiki-Nagasima, Oita, Japan",
   type:"T",
   latitude:"32.9667",
   longitude:"131.917"}
  ,
  {name:"Jacksonville, Navy Fuel Depot, St. Johns River, Florida (4)",
   type:"T",
   latitude:"30.4",
   longitude:"-81.6267"}
  ,
  {name:"Oyster Point Marina, San Francisco Bay, California",
   type:"T",
   latitude:"37.665",
   longitude:"-122.3767"}
  ,
  {name:"Shediac Bay, New Brunswick",
   type:"T",
   latitude:"46.25",
   longitude:"-64.5333"}
  ,
  {name:"Susami, Wakayama, Japan",
   type:"T",
   latitude:"33.55",
   longitude:"135.5"}
  ,
  {name:"Crescent City, California",
   type:"T",
   latitude:"41.745",
   longitude:"-124.1833"}
  ,
  {name:"Miyazaki (Toyama), Toyama, Japan",
   type:"T",
   latitude:"36.9667",
   longitude:"137.583"}
  ,
  {name:"Tampico, Tamaulipas, Mexico",
   type:"T",
   latitude:"22.2167",
   longitude:"-97.855"}
  ,
  {name:"Johnstone Strait Central, British Columbia Current",
   type:"C",
   latitude:"50.4717",
   longitude:"-126.1367"}
  ,
  {name:"Schooner Harbour, Baffin Island, Nunavut",
   type:"T",
   latitude:"64.4167",
   longitude:"-78.0"}
  ,
  {name:"Wilmington, North Carolina",
   type:"T",
   latitude:"34.2267",
   longitude:"-77.9533"}
  ,
  {name:"Bolivar Roads, Texas Current",
   type:"C",
   latitude:"29.3433",
   longitude:"-94.7817"}
  ,
  {name:"White Rock, British Columbia",
   type:"T",
   latitude:"49.0167",
   longitude:"-122.8"}
  ,
  {name:"Brest, France (2)",
   type:"T",
   latitude:"48.3833",
   longitude:"-4.5"}
  ,
  {name:"Mina Al Ahmadi, Kuwait",
   type:"T",
   latitude:"29.0667",
   longitude:"48.1667"}
  ,
  {name:"Nisikomi Wan, Kagosima, Japan",
   type:"T",
   latitude:"28.25",
   longitude:"129.167"}
  ,
  {name:"North Barnard Island, Australia (2)",
   type:"T",
   latitude:"-17.6833",
   longitude:"146.1833"}
  ,
  {name:"Atlantic City (Steel Pier), New Jersey (3)",
   type:"T",
   latitude:"39.355",
   longitude:"-74.4183"}
  ,
  {name:"Bukhta Shelekhovo, Kurile Islands",
   type:"T",
   latitude:"50.3833",
   longitude:"155.583"}
  ,
  {name:"Jacksonville, Navy Fuel Depot, St. Johns River, Florida (5)",
   type:"T",
   latitude:"30.4",
   longitude:"-81.6267"}
  ,
  {name:"Edgartown, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.3883",
   longitude:"-70.5117"}
  ,
  {name:"Havre de Grace, Susquehanna River, Maryland",
   type:"T",
   latitude:"39.5367",
   longitude:"-76.09"}
  ,
  {name:"Hornby Island, British Columbia (2)",
   type:"T",
   latitude:"49.05",
   longitude:"-124.6833"}
  ,
  {name:"St. Johns River at Racy Point, Florida",
   type:"T",
   latitude:"29.8019",
   longitude:"-81.5497"}
  ,
  {name:"Bloody Point, Daufuskie Island, New River, South Carolina",
   type:"T",
   latitude:"32.0833",
   longitude:"-80.8833"}
  ,
  {name:"Wonsan, North Korea",
   type:"T",
   latitude:"39.3667",
   longitude:"127.4333"}
  ,
  {name:"Pee Shoal, Australia",
   type:"T",
   latitude:"-11.7667",
   longitude:"124.8333"}
  ,
  {name:"Tori Sima, Tokyo, Japan",
   type:"T",
   latitude:"30.4833",
   longitude:"140.317"}
  ,
  {name:"Port Clinton, Australia",
   type:"T",
   latitude:"-22.5333",
   longitude:"150.75"}
  ,
  {name:"Bakkai, Hokkaido, Japan",
   type:"T",
   latitude:"45.3167",
   longitude:"141.617"}
  ,
  {name:"Brest, France (3)",
   type:"T",
   latitude:"48.3833",
   longitude:"-4.5"}
  ,
  {name:"Iqaluit S Farthest, Nunavut",
   type:"T",
   latitude:"63.4833",
   longitude:"-68.0333"}
  ,
  {name:"Alameda, San Francisco Bay, California (3)",
   type:"T",
   latitude:"37.7717",
   longitude:"-122.2983"}
  ,
  {name:"Loggieville, New Brunswick",
   type:"T",
   latitude:"47.0667",
   longitude:"-65.3833"}
  ,
  {name:"Jacksonville, Navy Fuel Depot, St. Johns River, Florida (6)",
   type:"T",
   latitude:"30.4",
   longitude:"-81.6267"}
  ,
  {name:"Port Townsend, Washington",
   type:"T",
   latitude:"48.1117",
   longitude:"-122.7583"}
  ,
  {name:"Pigeon Key, south side, Hawk Channel, Florida",
   type:"T",
   latitude:"24.7033",
   longitude:"-81.155"}
  ,
  {name:"Blanche Port, Australia",
   type:"T",
   latitude:"-32.7667",
   longitude:"134.2"}
  ,
  {name:"Kami Sima, Aichi, Japan",
   type:"T",
   latitude:"34.55",
   longitude:"136.983"}
  ,
  {name:"Aulitiving Island, Nunavut",
   type:"T",
   latitude:"69.5167",
   longitude:"-67.15"}
  ,
  {name:"Stavanger, Norway",
   type:"T",
   latitude:"58.9833",
   longitude:"5.7333"}
  ,
  {name:"Willis Island, Coral Sea",
   type:"T",
   latitude:"-16.2167",
   longitude:"150.0167"}
  ,
  {name:"Hiagari, Hukuoka, Japan",
   type:"T",
   latitude:"33.9",
   longitude:"130.883"}
  ,
  {name:"Forestville, Québec",
   type:"T",
   latitude:"48.7333",
   longitude:"-69.0833"}
  ,
  {name:"Olympia, Washington",
   type:"T",
   latitude:"47.05",
   longitude:"-122.9"}
  ,
  {name:"Egg Island, British Columbia",
   type:"T",
   latitude:"51.25",
   longitude:"-127.8333"}
  ,
  {name:"Charles Island, Washington",
   type:"T",
   latitude:"48.45",
   longitude:"-122.9"}
  ,
  {name:"Palermo, Argentina",
   type:"T",
   latitude:"-34.5667",
   longitude:"-58.4"}
  ,
  {name:"Florence Cove, British Columbia (2)",
   type:"T",
   latitude:"50.3",
   longitude:"-125.0167"}
  ,
  {name:"Egg Island, British Columbia (2)",
   type:"T",
   latitude:"51.25",
   longitude:"-127.0833"}
  ,
  {name:"Hvalba, Faroe Islands",
   type:"T",
   latitude:"61.6",
   longitude:"-6.9417"}
  ,
  {name:"Jordans Point, Labrador",
   type:"T",
   latitude:"54.2167",
   longitude:"-58.2333"}
  ,
  {name:"Omura, Nagasaki, Japan",
   type:"T",
   latitude:"32.9",
   longitude:"129.95"}
  ,
  {name:"Alberta Pool Elev., British Columbia",
   type:"T",
   latitude:"49.3",
   longitude:"-123.0333"}
  ,
  {name:"Palatka, St. Johns River, Florida",
   type:"T",
   latitude:"29.6433",
   longitude:"-81.6317"}
  ,
  {name:"Terrington Basin, Labrador",
   type:"T",
   latitude:"53.35",
   longitude:"-60.4"}
  ,
  {name:"Dionisio Point, British Columbia (2)",
   type:"T",
   latitude:"49.0167",
   longitude:"-123.5667"}
  ,
  {name:"Sooke Basin, British Columbia",
   type:"T",
   latitude:"48.3833",
   longitude:"-123.6833"}
  ,
  {name:"Raivavae, Austral Islands",
   type:"T",
   latitude:"-23.8667",
   longitude:"-147.6833"}
  ,
  {name:"Kenneth Passage, British Columbia",
   type:"T",
   latitude:"50.95",
   longitude:"-126.8"}
  ,
  {name:"Hrutafjordur, Iceland",
   type:"T",
   latitude:"65.25",
   longitude:"-21.1167"}
  ,
  {name:"Makemo Atoll, Tuamotu Archipelago",
   type:"T",
   latitude:"-16.6333",
   longitude:"-143.5667"}
  ,
  {name:"Kakazi, Oita, Japan",
   type:"T",
   latitude:"33.6833",
   longitude:"131.517"}
  ,
  {name:"Wachapreague, Wachapreague Channel, Virginia",
   type:"T",
   latitude:"37.6067",
   longitude:"-75.6867"}
  ,
  {name:"Nantucket, Nantucket Island, Massachusetts",
   type:"T",
   latitude:"41.285",
   longitude:"-70.0967"}
  ,
  {name:"St. Alban's, Newfoundland",
   type:"T",
   latitude:"47.8667",
   longitude:"-55.8333"}
  ,
  {name:"Bella Coola, British Columbia",
   type:"T",
   latitude:"52.3833",
   longitude:"-126.8"}
  ,
  {name:"Newport, Wales",
   type:"T",
   latitude:"51.5667",
   longitude:"-2.9833"}
  ,
  {name:"Grist Mill, Québec",
   type:"T",
   latitude:"46.65",
   longitude:"-71.9"}
  ,
  {name:"Talcahuano, Chile",
   type:"T",
   latitude:"-36.6833",
   longitude:"-73.1"}
  ,
  {name:"Port Moody, British Columbia (2)",
   type:"T",
   latitude:"49.2833",
   longitude:"-122.8667"}
  ,
  {name:"Cabo Frio, Brazil",
   type:"T",
   latitude:"-22.9667",
   longitude:"-42.0167"}
  ,
  {name:"Clarence Harbor, Long Island, Bahamas",
   type:"T",
   latitude:"23.1",
   longitude:"-75.9833"}
  ,
  {name:"Saint Servan, France",
   type:"T",
   latitude:"48.6333",
   longitude:"-2.0333"}
  ,
  {name:"Port Louis, British Columbia",
   type:"T",
   latitude:"53.6833",
   longitude:"-132.9667"}
  ,
  {name:"Saku Sima, Aichi, Japan",
   type:"T",
   latitude:"34.7333",
   longitude:"137.05"}
  ,
  {name:"Sproat Narrows, British Columbia",
   type:"T",
   latitude:"49.1",
   longitude:"-124.8333"}
  ,
  {name:"Hall Beach, Foxe Basin, Nunavut",
   type:"T",
   latitude:"68.75",
   longitude:"-81.2167"}
  ,
  {name:"Wasque Point, Chappaquiddick Island, Massachusetts",
   type:"T",
   latitude:"41.3633",
   longitude:"-70.45"}
  ,
  {name:"Santa Monica, California",
   type:"T",
   latitude:"34.0083",
   longitude:"-118.5"}
  ,
  {name:"Bay St. Louis, Mississippi",
   type:"T",
   latitude:"30.3067",
   longitude:"-89.3283"}
  ,
  {name:"Southampton, England",
   type:"T",
   latitude:"50.9",
   longitude:"-1.4"}
  ,
  {name:"Bay St. Lawrence, Nova Scotia",
   type:"T",
   latitude:"47.0167",
   longitude:"-60.45"}
  ,
  {name:"Chassahowitzka, Chassahowitzka River, Florida",
   type:"T",
   latitude:"28.715",
   longitude:"-82.5767"}
  ,
  {name:"West Advocate, Nova Scotia",
   type:"T",
   latitude:"45.35",
   longitude:"-64.8167"}
  ,
  {name:"Sumoto, Hyogo, Japan",
   type:"T",
   latitude:"34.3333",
   longitude:"134.917"}
  ,
  {name:"Vieux-Boucau, France",
   type:"T",
   latitude:"43.5167",
   longitude:"-1.5333"}
  ,
  {name:"Húsavík, Iceland",
   type:"T",
   latitude:"66.045",
   longitude:"-17.3583"}
  ,
  {name:"Port-aux-Francais, Kerguelen Islands",
   type:"T",
   latitude:"-49.35",
   longitude:"70.2167"}
  ,
  {name:"Ensenada, Baja California Norte, Mexico",
   type:"T",
   latitude:"31.85",
   longitude:"-116.6333"}
  ,
  {name:"Treadwell Bay, British Columbia",
   type:"T",
   latitude:"51.1",
   longitude:"-127.5333"}
  ,
  {name:"Riley Cove, British Columbia (2)",
   type:"T",
   latitude:"49.3833",
   longitude:"-126.2167"}
  ,
  {name:"Preedy Harbour, British Columbia (2)",
   type:"T",
   latitude:"48.9833",
   longitude:"-123.0667"}
  ,
  {name:"Burnt Church, New Brunswick",
   type:"T",
   latitude:"47.2",
   longitude:"-65.1333"}
  ,
  {name:"Gatcombe Head, Australia",
   type:"T",
   latitude:"-23.8833",
   longitude:"151.3833"}
  ,
  {name:"Taech'on, South Korea",
   type:"T",
   latitude:"36.3833",
   longitude:"126.4333"}
  ,
  {name:"Natashquan, Québec",
   type:"T",
   latitude:"50.1833",
   longitude:"-61.0833"}
  ,
  {name:"Wool Bay, Australia",
   type:"T",
   latitude:"-35.0",
   longitude:"137.75"}
  ,
  {name:"Tanjung Priok, Java, Indonesia",
   type:"T",
   latitude:"-6.1",
   longitude:"106.8667"}
  ,
  {name:"Seminole Shores, Florida",
   type:"T",
   latitude:"27.1833",
   longitude:"-80.1583"}
  ,
  {name:"Gordon Islands, British Columbia (2)",
   type:"T",
   latitude:"52.1",
   longitude:"-131.2167"}
  ,
  {name:"Yaizu, Sizuoka, Japan",
   type:"T",
   latitude:"34.8667",
   longitude:"138.333"}
  ,
  {name:"Bloedel, British Columbia",
   type:"T",
   latitude:"50.1167",
   longitude:"-125.3833"}
  ,
  {name:"Kerema, Papua New Guinea",
   type:"T",
   latitude:"-7.9667",
   longitude:"145.75"}
  ,
  {name:"Hog Bay, Australia",
   type:"T",
   latitude:"-35.7333",
   longitude:"137.95"}
  ,
  {name:"Key Colony Beach, Florida",
   type:"T",
   latitude:"24.7183",
   longitude:"-81.0167"}
  ,
  {name:"Port Neville, British Columbia",
   type:"T",
   latitude:"50.5",
   longitude:"-126.0833"}
  ,
  {name:"Arno Bay, Australia",
   type:"T",
   latitude:"-33.9167",
   longitude:"136.5833"}
  ,
  {name:"Joggins Wharf, Nova Scotia",
   type:"T",
   latitude:"45.6833",
   longitude:"-64.4667"}
  ,
  {name:"Advocate, Nova Scotia",
   type:"T",
   latitude:"45.3333",
   longitude:"-64.7833"}
  ,
  {name:"Nantucket, Nantucket Island, Massachusetts (2)",
   type:"T",
   latitude:"41.2867",
   longitude:"-70.095"}
  ,
  {name:"Playalinda Beach, Florida",
   type:"T",
   latitude:"28.65",
   longitude:"-80.6"}
  ,
  {name:"Fundy (Offshore 22b), Nova Scotia",
   type:"T",
   latitude:"42.05",
   longitude:"-65.6333"}
  ,
  {name:"Punta Gorda, Belize",
   type:"T",
   latitude:"16.1",
   longitude:"-88.8167"}
  ,
  {name:"Carleton Centre, Québec",
   type:"T",
   latitude:"48.1",
   longitude:"-66.1333"}
  ,
  {name:"Pointe Au Platon, Québec",
   type:"T",
   latitude:"46.6536",
   longitude:"-71.8263"}
  ,
  {name:"Mctavish Island, Québec",
   type:"T",
   latitude:"57.05",
   longitude:"-76.8667"}
  ,
  {name:"Shingle Bay, British Columbia (2)",
   type:"T",
   latitude:"53.25",
   longitude:"-131.8167"}
  ,
  {name:"Agadir, Morocco",
   type:"T",
   latitude:"30.4167",
   longitude:"-9.6167"}
  ,
  {name:"Zozo-No-Seto, Kumamoto, Japan",
   type:"T",
   latitude:"32.5833",
   longitude:"130.467"}
  ,
  {name:"Hobart, Tasmania",
   type:"T",
   latitude:"-42.8833",
   longitude:"147.3333"}
  ,
  {name:"Sfax, Tunisia",
   type:"T",
   latitude:"34.7333",
   longitude:"10.7667"}
  ,
  {name:"Islas Ano Nuevo, Argentina",
   type:"T",
   latitude:"-54.65",
   longitude:"-64.1333"}
  ,
  {name:"Cook's Harbour, Newfoundland",
   type:"T",
   latitude:"51.6167",
   longitude:"-55.8667"}
  ,
  {name:"Nyu, Hukui, Japan",
   type:"T",
   latitude:"35.7167",
   longitude:"135.967"}
  ,
  {name:"Mobile Bay Entrance, Alabama Current",
   type:"C",
   latitude:"30.2333",
   longitude:"-88.0333"}
  ,
  {name:"Narvaez Bay, British Columbia",
   type:"T",
   latitude:"48.7667",
   longitude:"-123.1"}
  ,
  {name:"Hyde Parker Island, Nunavut",
   type:"T",
   latitude:"76.4833",
   longitude:"-97.2167"}
  ,
  {name:"Rio Vista, Sacramento River, California",
   type:"T",
   latitude:"38.145",
   longitude:"-121.6917"}
  ,
  {name:"Sauðárkrókur, Iceland",
   type:"T",
   latitude:"65.7566",
   longitude:"-19.6466"}
  ,
  {name:"Bunker Island Light, Nova Scotia",
   type:"T",
   latitude:"43.8167",
   longitude:"-66.15"}
  ,
  {name:"Salmon Cove, British Columbia",
   type:"T",
   latitude:"55.2667",
   longitude:"-129.85"}
  ,
  {name:"Hong Kong, China",
   type:"T",
   latitude:"22.2833",
   longitude:"114.1833"}
  ,
  {name:"Izaki, Yamaguti, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"130.917"}
  ,
  {name:"Southwest Pass, Mississippi River Delta, Louisiana",
   type:"T",
   latitude:"28.9333",
   longitude:"-89.4333"}
  ,
  {name:"Upper Attawaspiskat, Ontario",
   type:"T",
   latitude:"52.9167",
   longitude:"-82.4333"}
  ,
  {name:"Churchill, Manitoba",
   type:"T",
   latitude:"58.7833",
   longitude:"-94.2"}
  ,
  {name:"West Point, Prince Edward Island",
   type:"T",
   latitude:"46.6167",
   longitude:"-64.3833"}
  ,
  {name:"Cabedelo, Brazil",
   type:"T",
   latitude:"-6.9667",
   longitude:"-34.8333"}
  ,
  {name:"Ike-No-Ura, Kumamoto, Japan",
   type:"T",
   latitude:"32.3833",
   longitude:"130.35"}
  ,
  {name:"Rørvik, Norway",
   type:"T",
   latitude:"64.8667",
   longitude:"11.25"}
  ,
  {name:"Bremerton, Washington",
   type:"T",
   latitude:"47.5667",
   longitude:"-122.6333"}
  ,
  {name:"Grand Bay, Newfoundland",
   type:"T",
   latitude:"47.6",
   longitude:"-59.1667"}
  ,
  {name:"Belanger Island, Québec",
   type:"T",
   latitude:"56.1333",
   longitude:"-76.7167"}
  ,
  {name:"Ketchikan, Alaska",
   type:"T",
   latitude:"55.3333",
   longitude:"-131.625"}
  ,
  {name:"Oryuzako, Miyazaki, Japan",
   type:"T",
   latitude:"31.7833",
   longitude:"131.467"}
  ,
  {name:"Hatakezimo, Nagasaki, Japan",
   type:"T",
   latitude:"33.0667",
   longitude:"129.733"}
  ,
  {name:"Akune, Kagosima, Japan",
   type:"T",
   latitude:"32.0167",
   longitude:"130.2"}
  ,
  {name:"Green Turtle Cay, Bahamas",
   type:"T",
   latitude:"26.7667",
   longitude:"-77.3"}
  ,
  {name:"Port Alice, British Columbia",
   type:"T",
   latitude:"50.3833",
   longitude:"-127.45"}
  ,
  {name:"Trenton, Delaware River, New Jersey",
   type:"T",
   latitude:"40.1883",
   longitude:"-74.755"}
  ,
  {name:"Brentwood Bay, British Columbia",
   type:"T",
   latitude:"48.5833",
   longitude:"-123.4667"}
  ,
  {name:"Nassau, New Providence Island, Bahamas (3)",
   type:"T",
   latitude:"25.0833",
   longitude:"-77.35"}
  ,
  {name:"Za`farana, Egypt",
   type:"T",
   latitude:"29.0",
   longitude:"32.6667"}
  ,
  {name:"Suva Harbor, Fiji Islands",
   type:"T",
   latitude:"-18.1333",
   longitude:"178.4333"}
  ,
  {name:"Naufrage, Prince Edward Island",
   type:"T",
   latitude:"46.4667",
   longitude:"-62.4167"}
  ,
  {name:"Bahía Buen Suceso, Argentina",
   type:"T",
   latitude:"-54.8167",
   longitude:"-65.2167"}
  ,
  {name:"Tofino, British Columbia (2)",
   type:"T",
   latitude:"49.15",
   longitude:"-125.9167"}
  ,
  {name:"Victoria, British Columbia",
   type:"T",
   latitude:"48.4167",
   longitude:"-123.3667"}
  ,
  {name:"Johnson Point, British Columbia",
   type:"T",
   latitude:"51.1167",
   longitude:"-127.5333"}
  ,
  {name:"Denham, Australia",
   type:"T",
   latitude:"-25.4333",
   longitude:"113.5333"}
  ,
  {name:"Ulneung Do, South Korea",
   type:"T",
   latitude:"37.5",
   longitude:"130.9167"}
  ,
  {name:"Alert, Nunavut",
   type:"T",
   latitude:"82.05",
   longitude:"-62.3167"}
  ,
  {name:"Recife, Brazil",
   type:"T",
   latitude:"-8.05",
   longitude:"-34.8667"}
  ,
  {name:"Nassau, New Providence Island, Bahamas (2)",
   type:"T",
   latitude:"25.0833",
   longitude:"-77.35"}
  ,
  {name:"Jackos Point, Newfoundland",
   type:"T",
   latitude:"59.45",
   longitude:"-55.1167"}
  ,
  {name:"Cobb Point Bar Light, Maryland",
   type:"T",
   latitude:"38.25",
   longitude:"-76.8333"}
  ,
  {name:"Horozuki, Aomori, Japan",
   type:"T",
   latitude:"41.2167",
   longitude:"140.55"}
  ,
  {name:"Pointe Howatson, Québec",
   type:"T",
   latitude:"48.1333",
   longitude:"-65.0833"}
  ,
  {name:"São Sebastião, Brazil",
   type:"T",
   latitude:"-23.8",
   longitude:"-45.3833"}
  ,
  {name:"Hunger Harbour, British Columbia",
   type:"T",
   latitude:"52.75",
   longitude:"-132.0333"}
  ,
  {name:"Klemtu, British Columbia",
   type:"T",
   latitude:"52.6",
   longitude:"-128.5167"}
  ,
  {name:"Mcbean Island, Nunavut",
   type:"T",
   latitude:"72.6333",
   longitude:"-89.6333"}
  ,
  {name:"Abidjan, Cote D'Ivoire",
   type:"T",
   latitude:"5.25",
   longitude:"-4.0"}
  ,
  {name:"Malibu Outer, British Columbia",
   type:"T",
   latitude:"50.0167",
   longitude:"-123.85"}
  ,
  {name:"Miscou Harbour, New Brunswick",
   type:"T",
   latitude:"47.9",
   longitude:"-64.5833"}
  ,
  {name:"Douala, Cameroon",
   type:"T",
   latitude:"4.05",
   longitude:"9.6833"}
  ,
  {name:"Galveston (Galveston Channel), Texas",
   type:"T",
   latitude:"29.31",
   longitude:"-94.7933"}
  ,
  {name:"Fulford Harbour, British Columbia (2)",
   type:"T",
   latitude:"48.7667",
   longitude:"-123.45"}
  ,
  {name:"Inokusi, Oita, Japan",
   type:"T",
   latitude:"32.8",
   longitude:"131.9"}
  ,
  {name:"Chesapeake Bay Entrance, Virginia Current (1) (expired 1987-12-31)",
   type:"C",
   latitude:"36.98",
   longitude:"-76.0067"}
  ,
  {name:"El Golfo de Santa Clara, Sonora, Mexico",
   type:"T",
   latitude:"31.65",
   longitude:"-114.5833"}
  ,
  {name:"Cape Skogn, Nunavut",
   type:"T",
   latitude:"75.7667",
   longitude:"-84.2167"}
  ,
  {name:"Cedar Key, Way Key, Florida",
   type:"T",
   latitude:"29.135",
   longitude:"-83.0317"}
  ,
  {name:"Friday Harbor, San Juan Channel, Washington",
   type:"T",
   latitude:"48.55",
   longitude:"-123.0"}
  ,
  {name:"Omodaka Wan, Nagasaki, Japan",
   type:"T",
   latitude:"33.0667",
   longitude:"129.667"}
  ,
  {name:"Mangrove Point, Crystal Bay, Florida",
   type:"T",
   latitude:"28.87",
   longitude:"-82.7233"}
  ,
  {name:"Nice, France",
   type:"T",
   latitude:"43.7167",
   longitude:"7.3"}
  ,
  {name:"Kerema, Papua New Guinea (2)",
   type:"T",
   latitude:"-7.9667",
   longitude:"145.75"}
  ,
  {name:"Londonderry, Northern Ireland",
   type:"T",
   latitude:"55.0",
   longitude:"-7.3167"}
  ,
  {name:"Nakatu, Oita, Japan",
   type:"T",
   latitude:"33.6",
   longitude:"131.25"}
  ,
  {name:"Prudhoe Bay, Alaska",
   type:"T",
   latitude:"70.4",
   longitude:"-148.5267"}
  ,
  {name:"Vancouver, Columbia River, Washington (dubious accuracy)",
   type:"T",
   latitude:"45.6267",
   longitude:"-122.6833"}
  ,
  {name:"Norwegian Bay, Nunavut",
   type:"T",
   latitude:"77.7",
   longitude:"-88.95"}
  ,
  {name:"Colombo, Sri Lanka",
   type:"T",
   latitude:"6.95",
   longitude:"79.85"}
  ,
  {name:"Blind Bay, British Columbia (2)",
   type:"T",
   latitude:"49.7167",
   longitude:"-124.1833"}
  ,
  {name:"Fort George Island, Fort George River, Florida",
   type:"T",
   latitude:"30.44",
   longitude:"-81.4383"}
  ,
  {name:"Harrington Reef, Endeavour Strait",
   type:"T",
   latitude:"-10.8167",
   longitude:"142.7167"}
  ,
  {name:"Port McNeill, British Columbia",
   type:"T",
   latitude:"50.6",
   longitude:"-127.0833"}
  ,
  {name:"Haverstraw (Hudson River), New York Current",
   type:"C",
   latitude:"41.2",
   longitude:"-73.95"}
  ,
  {name:"Smokey, Labrador",
   type:"T",
   latitude:"54.4667",
   longitude:"-57.25"}
  ,
  {name:"Birnie Island, British Columbia",
   type:"T",
   latitude:"54.6",
   longitude:"-130.4667"}
  ,
  {name:"Cove Point (1.1 mi. NE of), Maryland Current",
   type:"C",
   latitude:"38.3817",
   longitude:"-76.36"}
  ,
  {name:"Venice Inlet (inside), Florida",
   type:"T",
   latitude:"27.1233",
   longitude:"-82.47"}
  ,
  {name:"Caravalla Cove, Labrador",
   type:"T",
   latitude:"54.05",
   longitude:"-58.5833"}
  ,
  {name:"Kirkcaldie Reef, Torres Strait",
   type:"T",
   latitude:"-10.4167",
   longitude:"142.8"}
  ,
  {name:"Oak Bay, British Columbia (2)",
   type:"T",
   latitude:"48.4333",
   longitude:"-123.3"}
  ,
  {name:"Sebastian, Indian River, Florida",
   type:"T",
   latitude:"27.8117",
   longitude:"-80.465"}
  ,
  {name:"Macquarie Island",
   type:"T",
   latitude:"-54.5167",
   longitude:"158.9333"}
  ,
  {name:"Savannah, Georgia (expired 1988-12-31)",
   type:"T",
   latitude:"32.08",
   longitude:"-81.0817"}
  ,
  {name:"Duffus Point, Nova Scotia",
   type:"T",
   latitude:"46.2833",
   longitude:"-60.4167"}
  ,
  {name:"Buenaventura, Colombia",
   type:"T",
   latitude:"3.9",
   longitude:"-77.1"}
  ,
  {name:"Dublon Island, Chuuk, F.S.M.",
   type:"T",
   latitude:"7.33",
   longitude:"151.58"}
  ,
  {name:"Salmon River Bridge, Nova Scotia",
   type:"T",
   latitude:"44.7667",
   longitude:"-63.05"}
  ,
  {name:"Hisi Ura, Simane, Japan",
   type:"T",
   latitude:"36.1",
   longitude:"133.083"}
  ,
  {name:"London Bridge, England",
   type:"T",
   latitude:"51.5",
   longitude:"-0.0833"}
  ,
  {name:"Itukusima, Hirosima, Japan",
   type:"T",
   latitude:"34.3",
   longitude:"132.317"}
  ,
  {name:"Bellingham, Washington (2)",
   type:"T",
   latitude:"48.75",
   longitude:"-122.05"}
  ,
  {name:"Salisbury, Wicomico River, Chesapeake Bay, Maryland",
   type:"T",
   latitude:"38.365",
   longitude:"-75.6067"}
  ,
  {name:"Taraku Sima, Hokkaido, Japan",
   type:"T",
   latitude:"43.6333",
   longitude:"146.367"}
  ,
  {name:"Dodd Narrows, British Columbia Current",
   type:"C",
   latitude:"49.1367",
   longitude:"-123.8167"}
  ,
  {name:"Lyttelton, New Zealand",
   type:"T",
   latitude:"-43.6",
   longitude:"172.7167"}
  ,
  {name:"Itikawa, Tiba, Japan",
   type:"T",
   latitude:"35.6833",
   longitude:"139.95"}
  ,
  {name:"Darwin, Australia (2)",
   type:"T",
   latitude:"-12.4667",
   longitude:"130.85"}
  ,
  {name:"Yosizu, Mie, Japan",
   type:"T",
   latitude:"34.2667",
   longitude:"136.5"}
  ,
  {name:"Digges Harbour, Nunavut",
   type:"T",
   latitude:"62.5667",
   longitude:"-77.8667"}
  ,
  {name:"Humboldt Bay, North Spit, California",
   type:"T",
   latitude:"40.7667",
   longitude:"-124.2167"}
  ,
  {name:"Port Clements, British Columbia",
   type:"T",
   latitude:"53.6833",
   longitude:"-132.1667"}
  ,
  {name:"Hinotu Ura, Simane, Japan",
   type:"T",
   latitude:"36.0833",
   longitude:"133.067"}
  ,
  {name:"Kumul Tkr Mrg, Papua New Guinea (2)",
   type:"T",
   latitude:"-8.1333",
   longitude:"144.5667"}
  ,
  {name:"Jacksonville, Navy Fuel Depot, St. Johns River, Florida (2)",
   type:"T",
   latitude:"30.4",
   longitude:"-81.6267"}
  ,
  {name:"Hase, Saga, Japan",
   type:"T",
   latitude:"33.3167",
   longitude:"129.817"}
  ,
  {name:"Ine, Kyoto, Japan",
   type:"T",
   latitude:"35.6667",
   longitude:"135.283"}
  ,
  {name:"Off Lake Tashmoo, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.4667",
   longitude:"-70.6333"}
  ,
  {name:"Tomioka (Kii Suido), Tokusima, Japan",
   type:"T",
   latitude:"33.9167",
   longitude:"134.7"}
  ,
  {name:"Roberts Creek, British Columbia (2)",
   type:"T",
   latitude:"49.4167",
   longitude:"-123.6333"}
  ,
  {name:"Larsen Island, British Columbia (2)",
   type:"T",
   latitude:"53.6167",
   longitude:"-130.5667"}
  ,
  {name:"Palo Alto Yacht Harbor, California",
   type:"T",
   latitude:"37.45",
   longitude:"-122.1"}
  ,
  {name:"North Lubec, Maine",
   type:"T",
   latitude:"44.87",
   longitude:"-67.018"}
  ,
  {name:"Patricia Bay, British Columbia",
   type:"T",
   latitude:"48.65",
   longitude:"-123.45"}
  ,
  {name:"Pointe-Aux-Orignaux, Québec",
   type:"T",
   latitude:"47.4833",
   longitude:"-70.0333"}
  ,
  {name:"Ocean Falls, British Columbia (2)",
   type:"T",
   latitude:"52.35",
   longitude:"-127.6833"}
  ,
  {name:"Cuxhaven, Germany (2)",
   type:"T",
   latitude:"53.8667",
   longitude:"8.7167"}
  ,
  {name:"Great Sound, Ireland Island, Bermuda",
   type:"T",
   latitude:"32.3167",
   longitude:"-64.8333"}
  ,
  {name:"Kusiro, Hokkaido, Japan",
   type:"T",
   latitude:"42.9667",
   longitude:"144.383"}
  ,
  {name:"Summerford, Newfoundland",
   type:"T",
   latitude:"49.4833",
   longitude:"-54.7833"}
  ,
  {name:"Fulton, St. Johns River, Florida (2)",
   type:"T",
   latitude:"30.39",
   longitude:"-81.5067"}
  ,
  {name:"Reyd Otkrytyy, Kurile Islands",
   type:"T",
   latitude:"45.85",
   longitude:"149.733"}
  ,
  {name:"Goose Island, British Columbia (2)",
   type:"T",
   latitude:"52.0",
   longitude:"-128.4167"}
  ,
  {name:"Melchior, Antarctica",
   type:"T",
   latitude:"-64.3333",
   longitude:"-62.9833"}
  ,
  {name:"Habu (In-No-Sima), Hirosima, Japan",
   type:"T",
   latitude:"34.2667",
   longitude:"133.2"}
  ,
  {name:"Orange Park, St. Johns River, Florida (2)",
   type:"T",
   latitude:"30.1683",
   longitude:"-81.695"}
  ,
  {name:"Baxters Harbour, Nova Scotia",
   type:"T",
   latitude:"45.2333",
   longitude:"-64.5167"}
  ,
  {name:"Imabari, Ehime, Japan",
   type:"T",
   latitude:"34.0667",
   longitude:"133.0"}
  ,
  {name:"Cap-Aux-Corbeaux, Québec",
   type:"T",
   latitude:"47.4333",
   longitude:"-70.45"}
  ,
  {name:"Dreger Harbour, Papua New Guinea",
   type:"T",
   latitude:"-6.65",
   longitude:"147.8667"}
  ,
  {name:"Horseshoe, British Columbia",
   type:"T",
   latitude:"49.3333",
   longitude:"-123.25"}
  ,
  {name:"Port Harvey, British Columbia (2)",
   type:"T",
   latitude:"50.5667",
   longitude:"-126.2667"}
  ,
  {name:"Point Danger, Australia",
   type:"T",
   latitude:"-28.1667",
   longitude:"153.55"}
  ,
  {name:"Winter Harbour, British Columbia",
   type:"T",
   latitude:"50.5167",
   longitude:"-128.0333"}
  ,
  {name:"Freeport, DOW Barge Canal, Texas",
   type:"T",
   latitude:"28.9483",
   longitude:"-95.3083"}
  ,
  {name:"Lunenburg, Nova Scotia (2)",
   type:"T",
   latitude:"44.3667",
   longitude:"-64.3167"}
  ,
  {name:"Okitu, Sizuoka, Japan",
   type:"T",
   latitude:"35.05",
   longitude:"138.517"}
  ,
  {name:"Piney Point, St. Johns River, Florida (2)",
   type:"T",
   latitude:"30.2283",
   longitude:"-81.6633"}
  ,
  {name:"Port Marnham, Labrador",
   type:"T",
   latitude:"52.3833",
   longitude:"-55.7333"}
  ,
  {name:"Toke Point, Willapa Bay, Washington (2)",
   type:"T",
   latitude:"46.7067",
   longitude:"-123.965"}
  ,
  {name:"Kings Bay, Crystal River, Florida",
   type:"T",
   latitude:"28.8983",
   longitude:"-82.5983"}
  ,
  {name:"Njarðvík, Iceland",
   type:"T",
   latitude:"63.9833",
   longitude:"-22.5333"}
  ,
  {name:"Tomarigauti, Oita, Japan",
   type:"T",
   latitude:"33.1333",
   longitude:"131.9"}
  ,
  {name:"Fulton, St. Johns River, Florida (3)",
   type:"T",
   latitude:"30.39",
   longitude:"-81.5067"}
  ,
  {name:"Lockeport, Nova Scotia",
   type:"T",
   latitude:"43.7",
   longitude:"-65.1167"}
  ,
  {name:"Ostrov Toporkova, Kuril Islands, Russia",
   type:"T",
   latitude:"48.0833",
   longitude:"153.2667"}
  ,
  {name:"James Bay, St. Helena",
   type:"T",
   latitude:"-15.9167",
   longitude:"-5.7167"}
  ,
  {name:"Akutan Pass, Aleutian Islands, Alaska Current",
   type:"C",
   latitude:"54.0217",
   longitude:"-166.0517"}
  ,
  {name:"Couteau Bay, Newfoundland",
   type:"T",
   latitude:"47.7167",
   longitude:"-58.05"}
  ,
  {name:"Cristóbal, Panama",
   type:"T",
   latitude:"9.35",
   longitude:"-79.9"}
  ,
  {name:"Orange Park, St. Johns River, Florida (3)",
   type:"T",
   latitude:"30.1683",
   longitude:"-81.695"}
  ,
  {name:"Ceepeecee, British Columbia (2)",
   type:"T",
   latitude:"49.8667",
   longitude:"-126.7167"}
  ,
  {name:"Middle Cove, Newfoundland",
   type:"T",
   latitude:"47.6667",
   longitude:"-52.7"}
  ,
  {name:"Norris Cove, Bonne Bay, Newfoundland",
   type:"T",
   latitude:"49.5167",
   longitude:"-57.8667"}
  ,
  {name:"North Kopak Island, Québec",
   type:"T",
   latitude:"60.0",
   longitude:"-77.75"}
  ,
  {name:"Kemano Bay, British Columbia",
   type:"T",
   latitude:"53.5167",
   longitude:"-128.1167"}
  ,
  {name:"Georgina Point, British Columbia (2)",
   type:"T",
   latitude:"48.8667",
   longitude:"-123.2833"}
  ,
  {name:"Nushagak Bay (Clark's Point), Alaska",
   type:"T",
   latitude:"58.8483",
   longitude:"-158.5517"}
  ,
  {name:"Port Kem, Russia",
   type:"T",
   latitude:"64.9833",
   longitude:"34.7833"}
  ,
  {name:"Roche Bay, Nunavut",
   type:"T",
   latitude:"68.4167",
   longitude:"-82.6167"}
  ,
  {name:"Twillingate, Newfoundland",
   type:"T",
   latitude:"49.65",
   longitude:"-54.7667"}
  ,
  {name:"Delaware Bay Entrance, Delaware Current (1) (expired 1986-12-31)",
   type:"C",
   latitude:"38.7817",
   longitude:"-75.0433"}
  ,
  {name:"Haiki Jetty (S.side), Nagasaki, Japan",
   type:"T",
   latitude:"33.1333",
   longitude:"129.8"}
  ,
  {name:"Tórshavn, Faroe Islands",
   type:"T",
   latitude:"62.01",
   longitude:"-6.775"}
  ,
  {name:"Rosario Strait, Washington Current",
   type:"C",
   latitude:"48.4583",
   longitude:"-122.78"}
  ,
  {name:"Cap Chat, Québec",
   type:"T",
   latitude:"49.1",
   longitude:"-66.75"}
  ,
  {name:"Abbapoola Creek entrance, Stono River, South Carolina",
   type:"T",
   latitude:"32.6767",
   longitude:"-80.0067"}
  ,
  {name:"Progreso, Yucatán, Mexico",
   type:"T",
   latitude:"21.3",
   longitude:"-83.325"}
  ,
  {name:"Montague Harbour, British Columbia (2)",
   type:"T",
   latitude:"48.8833",
   longitude:"-123.3833"}
  ,
  {name:"Colonial Beach, Potomac River, Virginia",
   type:"T",
   latitude:"38.2517",
   longitude:"-76.96"}
  ,
  {name:"Greenock, Scotland",
   type:"T",
   latitude:"55.9667",
   longitude:"-4.8167"}
  ,
  {name:"Pelabuhan Kelang, Malaysia",
   type:"T",
   latitude:"3.0",
   longitude:"101.3833"}
  ,
  {name:"Juan De Fuca Strait (East), British Columbia Current",
   type:"C",
   latitude:"48.2317",
   longitude:"-123.53"}
  ,
  {name:"Liverpool, England",
   type:"T",
   latitude:"53.4167",
   longitude:"-3.0"}
  ,
  {name:"Himezi-Sikama, Hyogo, Japan",
   type:"T",
   latitude:"34.7833",
   longitude:"134.667"}
  ,
  {name:"Sept-Îles, Québec",
   type:"T",
   latitude:"50.1833",
   longitude:"-66.3667"}
  ,
  {name:"Villagarcia, Spain",
   type:"T",
   latitude:"42.6167",
   longitude:"-8.7833"}
  ,
  {name:"Sherbrooke, Nova Scotia",
   type:"T",
   latitude:"45.1333",
   longitude:"-61.9833"}
  ,
  {name:"Siokubi Misaki, Hokkaido, Japan",
   type:"T",
   latitude:"41.7167",
   longitude:"140.967"}
  ,
  {name:"Cedar Heights, Broward River, St. Johns River, Florida",
   type:"T",
   latitude:"30.4367",
   longitude:"-81.6417"}
  ,
  {name:"Chise P'o, South Korea",
   type:"T",
   latitude:"34.8333",
   longitude:"128.7167"}
  ,
  {name:"St. John's, Newfoundland",
   type:"T",
   latitude:"47.5667",
   longitude:"-52.7"}
  ,
  {name:"Crescent Beach, British Columbia",
   type:"T",
   latitude:"49.0333",
   longitude:"-122.8833"}
  ,
  {name:"Breakwater Harbor, Delaware",
   type:"T",
   latitude:"38.7817",
   longitude:"-75.12"}
  ,
  {name:"Grand Isle, USCG Station, East Point, Louisiana",
   type:"T",
   latitude:"29.2633",
   longitude:"-89.9567"}
  ,
  {name:"Port Nelson, Manitoba",
   type:"T",
   latitude:"57.0",
   longitude:"-92.05"}
  ,
  {name:"Banjul, Gambia",
   type:"T",
   latitude:"13.45",
   longitude:"-16.5833"}
  ,
  {name:"Kitimat, British Columbia (2)",
   type:"T",
   latitude:"53.9833",
   longitude:"-128.7"}
  ,
  {name:"Puerto Penasco, Sonora, Mexico",
   type:"T",
   latitude:"31.3",
   longitude:"-113.5333"}
  ,
  {name:"Wei-Hai-Wei, China",
   type:"T",
   latitude:"37.5",
   longitude:"122.1667"}
  ,
  {name:"Uchucklesit Inlet, British Columbia (2)",
   type:"T",
   latitude:"49.0",
   longitude:"-125.0"}
  ,
  {name:"Portsmouth, Norfolk Naval Shipyard, Virginia",
   type:"T",
   latitude:"36.8217",
   longitude:"-76.2933"}
  ,
  {name:"Naarai, Tiba, Japan",
   type:"T",
   latitude:"35.7",
   longitude:"140.85"}
  ,
  {name:"Bill Of Portland Island, Québec",
   type:"T",
   latitude:"55.0333",
   longitude:"-77.75"}
  ,
  {name:"Coyote Point Marina, San Francisco Bay, California",
   type:"T",
   latitude:"37.5917",
   longitude:"-122.3133"}
  ,
  {name:"Hakata-Hunadamari, Hukuoka, Japan (2)",
   type:"T",
   latitude:"33.6",
   longitude:"130.4"}
  ,
  {name:"Boat Harbour, British Columbia",
   type:"T",
   latitude:"49.1",
   longitude:"-123.8"}
  ,
  {name:"Dumbarton Bridge, San Francisco Bay, California Current",
   type:"C",
   latitude:"37.51",
   longitude:"-122.12"}
  ,
  {name:"Haverstraw, Hudson River, New York",
   type:"T",
   latitude:"41.1967",
   longitude:"-73.9583"}
  ,
  {name:"Massacre Bay, Attu Island, Alaska",
   type:"T",
   latitude:"52.84",
   longitude:"173.195"}
  ,
  {name:"Klaxton Creek, British Columbia (2)",
   type:"T",
   latitude:"54.0833",
   longitude:"-130.0833"}
  ,
  {name:"Puerto Vallarta, Jalisco, Mexico",
   type:"T",
   latitude:"20.615",
   longitude:"-105.245"}
  ,
  {name:"Scotia Bay, Laurie Island, South Orkneys",
   type:"T",
   latitude:"-60.7333",
   longitude:"-44.65"}
  ,
  {name:"Hama-Onisibetu, Hokkaido, Japan",
   type:"T",
   latitude:"45.3333",
   longitude:"142.167"}
  ,
  {name:"Millerand, Québec",
   type:"T",
   latitude:"47.1167",
   longitude:"-61.8833"}
  ,
  {name:"Tanger, Morocco",
   type:"T",
   latitude:"35.7833",
   longitude:"-5.8"}
  ,
  {name:"Usuyong, South Korea",
   type:"T",
   latitude:"34.5833",
   longitude:"126.2833"}
  ,
  {name:"Uchucklesit Inlet, British Columbia (3)",
   type:"T",
   latitude:"49.0167",
   longitude:"-125.05"}
  ,
  {name:"Loutit Bay, Australia",
   type:"T",
   latitude:"-38.55",
   longitude:"143.9833"}
  ,
  {name:"Albany, Australia",
   type:"T",
   latitude:"-35.0333",
   longitude:"117.8833"}
  ,
  {name:"Merigomish Harbour, Nova Scotia",
   type:"T",
   latitude:"45.65",
   longitude:"-62.45"}
  ,
  {name:"Mitukue, Ehime, Japan",
   type:"T",
   latitude:"33.45",
   longitude:"132.233"}
  ,
  {name:"Susaki (Koti), Koti, Japan",
   type:"T",
   latitude:"33.4",
   longitude:"133.283"}
  ,
  {name:"Wakkanai, Hokkaido, Japan",
   type:"T",
   latitude:"45.4167",
   longitude:"141.683"}
  ,
  {name:"Ganges Harbour, British Columbia (2)",
   type:"T",
   latitude:"48.85",
   longitude:"-123.05"}
  ,
  {name:"South West Rocks, Australia",
   type:"T",
   latitude:"-30.9",
   longitude:"153.0167"}
  ,
  {name:"Browse Island, Australia",
   type:"T",
   latitude:"-14.1",
   longitude:"123.55"}
  ,
  {name:"Port Hardy, British Columbia",
   type:"T",
   latitude:"50.7167",
   longitude:"-127.4833"}
  ,
  {name:"Gotu, Simane, Japan",
   type:"T",
   latitude:"35.0167",
   longitude:"132.233"}
  ,
  {name:"Grindstone (Ray .4), New Brunswick",
   type:"T",
   latitude:"45.7167",
   longitude:"-64.6"}
  ,
  {name:"Garnet Point, Maine",
   type:"T",
   latitude:"44.9167",
   longitude:"-67.1167"}
  ,
  {name:"Chemanius, British Columbia (2)",
   type:"T",
   latitude:"48.9167",
   longitude:"-123.7"}
  ,
  {name:"Gakiya, Okinawa, Japan",
   type:"T",
   latitude:"27.0333",
   longitude:"127.967"}
  ,
  {name:"Mucuripe, Brazil",
   type:"T",
   latitude:"-3.7",
   longitude:"-38.4667"}
  ,
  {name:"Wakimoto, Hokkaido, Japan",
   type:"T",
   latitude:"41.5667",
   longitude:"140.417"}
  ,
  {name:"Krabi, Thailand",
   type:"T",
   latitude:"8.056",
   longitude:"98.922"}
  ,
  {name:"Marco, Big Marco River, Florida",
   type:"T",
   latitude:"25.9717",
   longitude:"-81.7333"}
  ,
  {name:"Rangoon River, Myanmar",
   type:"T",
   latitude:"16.4833",
   longitude:"96.3"}
  ,
  {name:"Sirahama (Iriomote), Okinawa, Japan",
   type:"T",
   latitude:"24.35",
   longitude:"123.75"}
  ,
  {name:"Fulton, St. Johns River, Florida (4)",
   type:"T",
   latitude:"30.39",
   longitude:"-81.5067"}
  ,
  {name:"Campbellton, New Brunswick",
   type:"T",
   latitude:"47.9947",
   longitude:"-66.6811"}
  ,
  {name:"Uraga, Kanagawa, Japan",
   type:"T",
   latitude:"35.2333",
   longitude:"139.717"}
  ,
  {name:"Key West, Florida (expired 1986-12-31)",
   type:"T",
   latitude:"24.5533",
   longitude:"-81.8083"}
  ,
  {name:"Higasi-Sizunai, Hokkaido, Japan",
   type:"T",
   latitude:"42.2833",
   longitude:"142.467"}
  ,
  {name:"Isaac's Harbour, Nova Scotia",
   type:"T",
   latitude:"45.1833",
   longitude:"-61.6667"}
  ,
  {name:"Long Beach, Terminal Island, California",
   type:"T",
   latitude:"33.7517",
   longitude:"-118.2267"}
  ,
  {name:"Fairhaven, New Brunswick",
   type:"T",
   latitude:"44.9667",
   longitude:"-67.0167"}
  ,
  {name:"Kii-Katuura, Wakayama, Japan",
   type:"T",
   latitude:"33.6333",
   longitude:"135.95"}
  ,
  {name:"Oban, Scotland",
   type:"T",
   latitude:"56.4167",
   longitude:"-5.4833"}
  ,
  {name:"Akasaki, Tottori, Japan",
   type:"T",
   latitude:"35.5167",
   longitude:"133.667"}
  ,
  {name:"Diana Bay, Québec",
   type:"T",
   latitude:"60.8667",
   longitude:"-70.0667"}
  ,
  {name:"Port Warrender, Australia",
   type:"T",
   latitude:"-14.5167",
   longitude:"125.9"}
  ,
  {name:"Santa Cruz de Tenerife, Canary Islands (2)",
   type:"T",
   latitude:"28.4833",
   longitude:"-16.2333"}
  ,
  {name:"Port-Alfred, Québec (2)",
   type:"T",
   latitude:"48.3167",
   longitude:"-70.8833"}
  ,
  {name:"Singapore (Victoria Dock) (2)",
   type:"T",
   latitude:"1.2667",
   longitude:"103.85"}
  ,
  {name:"Townsville, Australia (2)",
   type:"T",
   latitude:"-19.2667",
   longitude:"146.8333"}
  ,
  {name:"Manzanillo, Colima, Mexico (2)",
   type:"T",
   latitude:"19.0533",
   longitude:"-104.33"}
  ,
  {name:"Tamatave, Madagascar",
   type:"T",
   latitude:"-18.15",
   longitude:"49.4333"}
  ,
  {name:"Blind Channel, British Columbia",
   type:"T",
   latitude:"50.4167",
   longitude:"-125.5"}
  ,
  {name:"Port Hastings, Strait of Canso, Nova Scotia",
   type:"T",
   latitude:"45.65",
   longitude:"-61.4"}
  ,
  {name:"Denman Island, British Columbia",
   type:"T",
   latitude:"49.5333",
   longitude:"-124.8167"}
  ,
  {name:"Wellhouse Rock, River Severn, England",
   type:"T",
   latitude:"51.7333",
   longitude:"-2.4833"}
  ,
  {name:"Helgoland, Germany (2)",
   type:"T",
   latitude:"54.1833",
   longitude:"7.9"}
  ,
  {name:"Topolobampo, Sinaloa, Mexico (2)",
   type:"T",
   latitude:"25.6",
   longitude:"-109.0483"}
  ,
  {name:"Kuala Batu Pahat, Malaysia",
   type:"T",
   latitude:"1.8",
   longitude:"102.8833"}
  ,
  {name:"Port Dufferin, Nova Scotia",
   type:"T",
   latitude:"44.9",
   longitude:"-62.3667"}
  ,
  {name:"Suarji Island, Torres Strait",
   type:"T",
   latitude:"-10.1667",
   longitude:"142.5167"}
  ,
  {name:"Belleoram, Newfoundland",
   type:"T",
   latitude:"47.5333",
   longitude:"-55.4167"}
  ,
  {name:"Muroo, Hirosima, Japan",
   type:"T",
   latitude:"34.1",
   longitude:"132.55"}
  ,
  {name:"Port Jefferson, Long Island Sound, New York",
   type:"T",
   latitude:"40.95",
   longitude:"-73.0767"}
  ,
  {name:"Sandwich Bay (East Arm), Labrador",
   type:"T",
   latitude:"53.5667",
   longitude:"-57.1667"}
  ,
  {name:"Amherst, Myanmar",
   type:"T",
   latitude:"16.0833",
   longitude:"97.5667"}
  ,
  {name:"Ohu, Okinawa, Japan",
   type:"T",
   latitude:"26.1333",
   longitude:"127.783"}
  ,
  {name:"Sungai Sarawak, Malaysia",
   type:"T",
   latitude:"1.75",
   longitude:"110.5"}
  ,
  {name:"Big Paradise Island, Wando River, South Carolina",
   type:"T",
   latitude:"32.915",
   longitude:"-79.7467"}
  ,
  {name:"Becancour, Québec",
   type:"T",
   latitude:"46.4",
   longitude:"-72.3833"}
  ,
  {name:"Pikyulik Island, Payne River, Québec",
   type:"T",
   latitude:"60.0",
   longitude:"-69.9167"}
  ,
  {name:"Sebastian Inlet bridge, Indian River, Florida",
   type:"T",
   latitude:"27.86",
   longitude:"-80.4483"}
  ,
  {name:"Shingle Bay, Nunavut/NWT",
   type:"T",
   latitude:"68.9333",
   longitude:"-137.2"}
  ,
  {name:"Takezaki Sima (Oura), Saga, Japan",
   type:"T",
   latitude:"32.95",
   longitude:"130.217"}
  ,
  {name:"Prideaux Haven, British Columbia",
   type:"T",
   latitude:"50.15",
   longitude:"-124.6667"}
  ,
  {name:"Dublon Island, Chuuk, F.S.M. (2)",
   type:"T",
   latitude:"7.3667",
   longitude:"151.8833"}
  ,
  {name:"Beypore, India",
   type:"T",
   latitude:"11.1667",
   longitude:"75.8"}
  ,
  {name:"Kuru Sima, Ehime, Japan",
   type:"T",
   latitude:"34.1167",
   longitude:"132.967"}
  ,
  {name:"Vigo, Spain",
   type:"T",
   latitude:"42.25",
   longitude:"-8.7167"}
  ,
  {name:"Yokohama-Sinko, Kanagawa, Japan",
   type:"T",
   latitude:"35.45",
   longitude:"139.633"}
  ,
  {name:"Porlier Pass, British Columbia (2)",
   type:"T",
   latitude:"49.0167",
   longitude:"-123.5833"}
  ,
  {name:"Flinders Island, Australia",
   type:"T",
   latitude:"-14.1667",
   longitude:"144.1667"}
  ,
  {name:"Port De St-Pierre, Newfoundland",
   type:"T",
   latitude:"46.8167",
   longitude:"-56.1833"}
  ,
  {name:"Wainwright Basin, British Columbia",
   type:"T",
   latitude:"54.25",
   longitude:"-130.2667"}
  ,
  {name:"Elbow Point, Australia",
   type:"T",
   latitude:"-25.7833",
   longitude:"153.0333"}
  ,
  {name:"Borkum, Germany",
   type:"T",
   latitude:"53.5833",
   longitude:"6.6667"}
  ,
  {name:"Lac St-Pierre, Québec",
   type:"T",
   latitude:"46.1833",
   longitude:"-72.9"}
  ,
  {name:"Purfur Cove, Nunavut",
   type:"T",
   latitude:"69.0833",
   longitude:"-84.2167"}
  ,
  {name:"Salvador, Brazil",
   type:"T",
   latitude:"-12.95",
   longitude:"-38.5167"}
  ,
  {name:"Bahía Thetis, Argentina",
   type:"T",
   latitude:"-54.6333",
   longitude:"-65.25"}
  ,
  {name:"Gibsons, British Columbia",
   type:"T",
   latitude:"49.4",
   longitude:"-123.5"}
  ,
  {name:"Weehawken, Days Point, New Jersey",
   type:"T",
   latitude:"40.7667",
   longitude:"-74.0167"}
  ,
  {name:"Kemano Bay, British Columbia (2)",
   type:"T",
   latitude:"53.5167",
   longitude:"-128.1167"}
  ,
  {name:"Nain, Labrador",
   type:"T",
   latitude:"56.5333",
   longitude:"-61.6833"}
  ,
  {name:"Warnbro Sound, Australia",
   type:"T",
   latitude:"-32.3167",
   longitude:"115.7167"}
  ,
  {name:"Brisbane Port Off., Australia",
   type:"T",
   latitude:"-27.4833",
   longitude:"153.0333"}
  ,
  {name:"Hope Bay, British Columbia",
   type:"T",
   latitude:"48.8",
   longitude:"-123.2667"}
  ,
  {name:"Julington Creek, Florida",
   type:"T",
   latitude:"30.135",
   longitude:"-81.63"}
  ,
  {name:"Miike, Hukuoka, Japan",
   type:"T",
   latitude:"33.0167",
   longitude:"130.417"}
  ,
  {name:"Mocimboa da Praia, Mozambique",
   type:"T",
   latitude:"-11.3333",
   longitude:"40.3667"}
  ,
  {name:"Cape Sharp, Nova Scotia",
   type:"T",
   latitude:"45.3667",
   longitude:"-64.3833"}
  ,
  {name:"Belém, Pará, Brazil",
   type:"T",
   latitude:"-1.4333",
   longitude:"-48.5"}
  ,
  {name:"Tikuzen Oosima, Hukuoka, Japan",
   type:"T",
   latitude:"33.9",
   longitude:"130.433"}
  ,
  {name:"South Yarmouth, Bass River, Nantucket Sound, Massachusetts",
   type:"T",
   latitude:"41.665",
   longitude:"-70.1833"}
  ,
  {name:"Mizusima, Okayama, Japan",
   type:"T",
   latitude:"34.5167",
   longitude:"133.75"}
  ,
  {name:"Palmetto Bluff, St. Johns River, Florida",
   type:"T",
   latitude:"29.7633",
   longitude:"-81.5617"}
  ,
  {name:"Sakitu Wan, Kumamoto, Japan",
   type:"T",
   latitude:"32.3167",
   longitude:"130.017"}
  ,
  {name:"Man O' War Bay, Cameroon",
   type:"T",
   latitude:"3.9667",
   longitude:"9.2167"}
  ,
  {name:"Port De Laperriere, Nunavut",
   type:"T",
   latitude:"62.5667",
   longitude:"-78.0667"}
  ,
  {name:"Kottoi, Yamaguti, Japan",
   type:"T",
   latitude:"34.3167",
   longitude:"130.9"}
  ,
  {name:"Godfrey Point, British Columbia",
   type:"T",
   latitude:"54.0167",
   longitude:"-130.2333"}
  ,
  {name:"Shoal Bay, British Columbia",
   type:"T",
   latitude:"50.4667",
   longitude:"-125.3667"}
  ,
  {name:"Asamusi, Aomori, Japan",
   type:"T",
   latitude:"40.9",
   longitude:"140.867"}
  ,
  {name:"Port Angeles, Washington (2)",
   type:"T",
   latitude:"48.1167",
   longitude:"-123.4333"}
  ,
  {name:"Hibernia (780-1080), Newfoundland",
   type:"T",
   latitude:"46.5667",
   longitude:"-48.7333"}
  ,
  {name:"Usuka Wan, Nagasaki, Japan",
   type:"T",
   latitude:"33.3833",
   longitude:"129.533"}
  ,
  {name:"Kahului, Kahului Harbor, Hawaii",
   type:"T",
   latitude:"20.8983",
   longitude:"-156.4717"}
  ,
  {name:"Silva Bay, British Columbia",
   type:"T",
   latitude:"49.15",
   longitude:"-123.7"}
  ,
  {name:"Kiptopeke Beach, Chesapeake Bay, Virginia",
   type:"T",
   latitude:"37.1667",
   longitude:"-75.9883"}
  ,
  {name:"Tuckahoe, Tuckahoe River, New Jersey",
   type:"T",
   latitude:"39.295",
   longitude:"-74.7483"}
  ,
  {name:"Brisbane Bar, Australia (2)",
   type:"T",
   latitude:"-27.3333",
   longitude:"153.1667"}
  ,
  {name:"Fair Isle, Shetland Islands, Scotland",
   type:"T",
   latitude:"59.55",
   longitude:"-1.6333"}
  ,
  {name:"Charleston, South Carolina",
   type:"T",
   latitude:"32.7817",
   longitude:"-79.925"}
  ,
  {name:"Kópasker, Iceland",
   type:"T",
   latitude:"66.3",
   longitude:"-16.4666"}
  ,
  {name:"Uno, Okayama, Japan (2)",
   type:"T",
   latitude:"34.5",
   longitude:"133.95"}
  ,
  {name:"Alert Bay, British Columbia",
   type:"T",
   latitude:"50.5833",
   longitude:"-126.9333"}
  ,
  {name:"Amelia City, South Amelia River, Florida",
   type:"T",
   latitude:"30.5867",
   longitude:"-81.4633"}
  ,
  {name:"Tilting Harbour, Newfoundland",
   type:"T",
   latitude:"49.7",
   longitude:"-54.05"}
  ,
  {name:"Ross Island, Antarctica",
   type:"T",
   latitude:"-77.8667",
   longitude:"166.8"}
  ,
  {name:"Pacofi Bay, British Columbia",
   type:"T",
   latitude:"52.8333",
   longitude:"-131.8833"}
  ,
  {name:"Exploits Upper Harbour, Newfoundland",
   type:"T",
   latitude:"49.5167",
   longitude:"-55.0667"}
  ,
  {name:"Dauphin Island, Alabama",
   type:"T",
   latitude:"30.25",
   longitude:"-88.075"}
  ,
  {name:"Newby Shoal, Australia",
   type:"T",
   latitude:"-11.8667",
   longitude:"129.1833"}
  ,
  {name:"Baudin Island, Australia",
   type:"T",
   latitude:"-14.1333",
   longitude:"125.6"}
  ,
  {name:"Charleston Harbor Entrance, South Carolina Current",
   type:"C",
   latitude:"32.7567",
   longitude:"-79.87"}
  ,
  {name:"Comox, British Columbia",
   type:"T",
   latitude:"49.6667",
   longitude:"-124.9167"}
  ,
  {name:"Onomiti, Hirosima, Japan",
   type:"T",
   latitude:"34.4",
   longitude:"133.2"}
  ,
  {name:"La Jolla, Scripps Pier, California",
   type:"T",
   latitude:"32.8667",
   longitude:"-117.2567"}
  ,
  {name:"Sutherlands Still, Dunns Creek, Florida (3)",
   type:"T",
   latitude:"29.5733",
   longitude:"-81.6033"}
  ,
  {name:"Picton, New Zealand",
   type:"T",
   latitude:"-41.2833",
   longitude:"174.0"}
  ,
  {name:"Copper Islands, British Columbia (2)",
   type:"T",
   latitude:"52.35",
   longitude:"-131.1667"}
  ,
  {name:"Zaliv Mil'na, Kurile Islands",
   type:"T",
   latitude:"46.8667",
   longitude:"151.883"}
  ,
  {name:"Cypremort Point, Louisiana",
   type:"T",
   latitude:"29.7117",
   longitude:"-91.8783"}
  ,
  {name:"Hanabutihama, Miyagi, Japan",
   type:"T",
   latitude:"38.3",
   longitude:"141.083"}
  ,
  {name:"Vila Real de Santo Antonio, Portugal",
   type:"T",
   latitude:"37.1833",
   longitude:"-7.4"}
  ,
  {name:"Little Coyote Point, California Current",
   type:"C",
   latitude:"37.5903",
   longitude:"-122.2487"}
  ,
  {name:"Rivière-Du-Loup, Québec",
   type:"T",
   latitude:"47.85",
   longitude:"-69.5667"}
  ,
  {name:"Hyannis Port, Nantucket Sound, Massachusetts",
   type:"T",
   latitude:"41.6317",
   longitude:"-70.305"}
  ,
  {name:"Brisbane Bar, Australia (3)",
   type:"T",
   latitude:"-27.3333",
   longitude:"153.1667"}
  ,
  {name:"Hiketa, Kagawa, Japan",
   type:"T",
   latitude:"34.2333",
   longitude:"134.4"}
  ,
  {name:"Naze, Kagosima, Japan",
   type:"T",
   latitude:"28.3833",
   longitude:"129.5"}
  ,
  {name:"Nw Crocodile Island, Australia",
   type:"T",
   latitude:"-11.75",
   longitude:"135.0833"}
  ,
  {name:"Skerry Bay, British Columbia",
   type:"T",
   latitude:"49.05",
   longitude:"-124.2333"}
  ,
  {name:"Kahuka (Rebun-To), Hokkaido, Japan",
   type:"T",
   latitude:"45.3",
   longitude:"141.05"}
  ,
  {name:"Niigata, Niigata, Japan",
   type:"T",
   latitude:"37.9333",
   longitude:"139.067"}
  ,
  {name:"Redonda Bay, British Columbia",
   type:"T",
   latitude:"50.2667",
   longitude:"-124.9833"}
  ,
  {name:"Buntzen Lake, British Columbia (2)",
   type:"T",
   latitude:"49.3667",
   longitude:"-122.8833"}
  ,
  {name:"Sutherlands Still, Dunns Creek, Florida (2)",
   type:"T",
   latitude:"29.5733",
   longitude:"-81.6033"}
  ,
  {name:"Trepassey Harbour, Newfoundland",
   type:"T",
   latitude:"46.7333",
   longitude:"-53.3667"}
  ,
  {name:"Portage Inlet, British Columbia",
   type:"T",
   latitude:"48.45",
   longitude:"-123.4167"}
  ,
  {name:"Cocodrie, Terrebonne Bay, Louisiana",
   type:"T",
   latitude:"29.245",
   longitude:"-90.6617"}
  ,
  {name:"Pulau Besin, Myanmar",
   type:"T",
   latitude:"9.9833",
   longitude:"98.4833"}
  ,
  {name:"Cassini Island, Australia",
   type:"T",
   latitude:"-13.95",
   longitude:"125.6667"}
  ,
  {name:"Port of Spain, Trinidad",
   type:"T",
   latitude:"10.65",
   longitude:"-61.5167"}
  ,
  {name:"Iwaya (Hukuoka), Hukuoka, Japan",
   type:"T",
   latitude:"33.9333",
   longitude:"130.683"}
  ,
  {name:"Refuge Bay, British Columbia (2)",
   type:"T",
   latitude:"54.05",
   longitude:"-130.5333"}
  ,
  {name:"Ungowa, Australia",
   type:"T",
   latitude:"-25.5",
   longitude:"152.9833"}
  ,
  {name:"St-Lawrence Mooring, Québec",
   type:"T",
   latitude:"47.4667",
   longitude:"-70.1"}
  ,
  {name:"Walvis Bay, Namibia",
   type:"T",
   latitude:"-22.95",
   longitude:"14.5"}
  ,
  {name:"Geranium Harbour, Australia",
   type:"T",
   latitude:"-13.9333",
   longitude:"126.5833"}
  ,
  {name:"Swartz Bay, British Columbia (2)",
   type:"T",
   latitude:"48.6833",
   longitude:"-123.4"}
  ,
  {name:"Nassau, New Providence Island, Bahamas",
   type:"T",
   latitude:"25.0833",
   longitude:"-77.35"}
  ,
  {name:"Libreville, Gabon",
   type:"T",
   latitude:"0.3833",
   longitude:"9.4333"}
  ,
  {name:"Cedar Heights, Broward River, St. Johns River, Florida (2)",
   type:"T",
   latitude:"30.4367",
   longitude:"-81.6417"}
  ,
  {name:"Ko-Sagi Sima, Hirosima, Japan",
   type:"T",
   latitude:"34.3667",
   longitude:"133.1"}
  ,
  {name:"Ainoura, Nagasaki, Japan",
   type:"T",
   latitude:"33.1833",
   longitude:"129.633"}
  ,
  {name:"Gosling Island, British Columbia (2)",
   type:"T",
   latitude:"51.9",
   longitude:"-128.4333"}
  ,
  {name:"False Creek, British Columbia",
   type:"T",
   latitude:"49.2667",
   longitude:"-123.1333"}
  ,
  {name:"Simoda, Sizuoka, Japan",
   type:"T",
   latitude:"34.6667",
   longitude:"138.95"}
  ,
  {name:"Cape Wilson 3, Nunavut",
   type:"T",
   latitude:"67.0",
   longitude:"-81.45"}
  ,
  {name:"Gogo Sima, Ehime, Japan",
   type:"T",
   latitude:"33.9167",
   longitude:"132.683"}
  ,
  {name:"Pablo Creek entrance, St. Johns River, Florida",
   type:"T",
   latitude:"30.3767",
   longitude:"-81.4483"}
  ,
  {name:"Admiralty Island, Nunavut",
   type:"T",
   latitude:"69.45",
   longitude:"-100.9833"}
  ,
  {name:"Boot Key Harbor, Vaca Key, Florida",
   type:"T",
   latitude:"24.7067",
   longitude:"-81.0967"}
  ,
  {name:"Takihama, Ehime, Japan",
   type:"T",
   latitude:"33.9833",
   longitude:"133.35"}
  ,
  {name:"Usibuka, Kumamoto, Japan",
   type:"T",
   latitude:"32.2",
   longitude:"130.017"}
  ,
  {name:"Hudson Strait Station 808, Québec",
   type:"T",
   latitude:"62.0",
   longitude:"-71.5833"}
  ,
  {name:"Sagi, Simane, Japan",
   type:"T",
   latitude:"35.45",
   longitude:"132.683"}
  ,
  {name:"Mawson, Antarctica",
   type:"T",
   latitude:"-67.6",
   longitude:"62.8833"}
  ,
  {name:"Onahama, Fukusima, Japan (2)",
   type:"T",
   latitude:"36.9333",
   longitude:"140.9"}
  ,
  {name:"Cap D'espoir, Québec",
   type:"T",
   latitude:"48.4269",
   longitude:"-64.3314"}
  ,
  {name:"Port Manatee, Tampa Bay, Florida Current",
   type:"C",
   latitude:"27.6617",
   longitude:"-82.6"}
  ,
  {name:"Mina Salman, Bahrain",
   type:"T",
   latitude:"26.2333",
   longitude:"50.6"}
  ,
  {name:"Blaine, Semiahmoo Bay, Washington (2)",
   type:"T",
   latitude:"49.0",
   longitude:"-122.7667"}
  ,
  {name:"Devonport, Tasmania (2)",
   type:"T",
   latitude:"-41.15",
   longitude:"146.3833"}
  ,
  {name:"Calcutta (Garden Reach), India",
   type:"T",
   latitude:"22.55",
   longitude:"88.3"}
  ,
  {name:"Telegraph Harbour, British Columbia",
   type:"T",
   latitude:"48.9667",
   longitude:"-123.0667"}
  ,
  {name:"Skagway, Alaska",
   type:"T",
   latitude:"59.45",
   longitude:"-135.325"}
  ,
  {name:"Miiraku, Nagasaki, Japan",
   type:"T",
   latitude:"32.75",
   longitude:"128.7"}
  ,
  {name:"Aohama, Hukuoka, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"131.017"}
  ,
  {name:"Burgoyne Bay, British Columbia",
   type:"T",
   latitude:"48.7833",
   longitude:"-123.5167"}
  ,
  {name:"Fitzroy Island, Australia",
   type:"T",
   latitude:"-16.9167",
   longitude:"146.0"}
  ,
  {name:"Point Maud, Australia",
   type:"T",
   latitude:"-23.1167",
   longitude:"113.7833"}
  ,
  {name:"Mozambique, Mozambique",
   type:"T",
   latitude:"-15.0333",
   longitude:"40.7333"}
  ,
  {name:"Cherbourg, France (2)",
   type:"T",
   latitude:"49.65",
   longitude:"-1.6333"}
  ,
  {name:"Sandy Point, North Caicos Island",
   type:"T",
   latitude:"21.9333",
   longitude:"-72.05"}
  ,
  {name:"Surf Inlet, British Columbia (2)",
   type:"T",
   latitude:"53.0333",
   longitude:"-128.9"}
  ,
  {name:"Barrington Passage, Nova Scotia",
   type:"T",
   latitude:"43.5333",
   longitude:"-65.6167"}
  ,
  {name:"Durban, South Africa (2)",
   type:"T",
   latitude:"-29.8667",
   longitude:"31.05"}
  ,
  {name:"Arakawa (Tamanoura), Nagasaki, Japan",
   type:"T",
   latitude:"32.6667",
   longitude:"128.683"}
  ,
  {name:"Tacoma, Washington",
   type:"T",
   latitude:"47.2833",
   longitude:"-122.4167"}
  ,
  {name:"Monterey, Monterey Harbor, California",
   type:"T",
   latitude:"36.605",
   longitude:"-121.8883"}
  ,
  {name:"Saanichton Bay, British Columbia",
   type:"T",
   latitude:"48.6",
   longitude:"-123.3833"}
  ,
  {name:"Fernandina Beach, Amelia River, Florida (2)",
   type:"T",
   latitude:"30.6717",
   longitude:"-81.4667"}
  ,
  {name:"Arica, Chile",
   type:"T",
   latitude:"-18.4667",
   longitude:"-70.3333"}
  ,
  {name:"Turtle Head, Torres Strait",
   type:"T",
   latitude:"-10.5167",
   longitude:"142.2167"}
  ,
  {name:"Manasquan Inlet, USCG Station, New Jersey",
   type:"T",
   latitude:"40.1017",
   longitude:"-74.035"}
  ,
  {name:"Napier, New Zealand",
   type:"T",
   latitude:"-39.4833",
   longitude:"176.9167"}
  ,
  {name:"Komun Do, South Korea",
   type:"T",
   latitude:"34.0",
   longitude:"127.3"}
  ,
  {name:"Quatsino Village, British Columbia",
   type:"T",
   latitude:"50.5333",
   longitude:"-127.6333"}
  ,
  {name:"Pelham Bay, Belcher Channel, Nunavut (2)",
   type:"T",
   latitude:"76.75",
   longitude:"-96.9"}
  ,
  {name:"Port Clements, British Columbia (2)",
   type:"T",
   latitude:"53.6833",
   longitude:"-132.1667"}
  ,
  {name:"Puerto Nuevo, Ecuador",
   type:"T",
   latitude:"-2.2667",
   longitude:"-79.9167"}
  ,
  {name:"Zadar, Croatia",
   type:"T",
   latitude:"44.0833",
   longitude:"15.2667"}
  ,
  {name:"Milford Haven, Wales",
   type:"T",
   latitude:"51.7",
   longitude:"-5.0167"}
  ,
  {name:"Nyube, Kagawa, Japan",
   type:"T",
   latitude:"34.4833",
   longitude:"134.2"}
  ,
  {name:"Fernandina Beach, Amelia River, Florida (3)",
   type:"T",
   latitude:"30.6717",
   longitude:"-81.4667"}
  ,
  {name:"Jensen Bay, Australia",
   type:"T",
   latitude:"-11.1833",
   longitude:"136.6833"}
  ,
  {name:"North Shields, England",
   type:"T",
   latitude:"55.0167",
   longitude:"-1.4333"}
  ,
  {name:"Wainwright Basin, British Columbia (2)",
   type:"T",
   latitude:"54.25",
   longitude:"-130.2333"}
  ,
  {name:"Amagasaki, Hyogo, Japan",
   type:"T",
   latitude:"34.7",
   longitude:"135.4"}
  ,
  {name:"Alotau, Papua New Guinea",
   type:"T",
   latitude:"-10.3167",
   longitude:"150.45"}
  ,
  {name:"San Juan, Argentina",
   type:"T",
   latitude:"-54.75",
   longitude:"-63.8833"}
  ,
  {name:"Suez, Egypt",
   type:"T",
   latitude:"29.9333",
   longitude:"32.55"}
  ,
  {name:"Tampa Bay (Sunshine Skyway Bridge), Florida Current",
   type:"C",
   latitude:"27.62",
   longitude:"-82.655"}
  ,
  {name:"Zeballos, British Columbia",
   type:"T",
   latitude:"49.9833",
   longitude:"-126.85"}
  ,
  {name:"Little Talbot Island, Florida (4)",
   type:"T",
   latitude:"30.43",
   longitude:"-81.405"}
  ,
  {name:"Ólafsfjörður, Iceland",
   type:"T",
   latitude:"66.075",
   longitude:"-18.65"}
  ,
  {name:"Charlestown, Northeast River, Maryland",
   type:"T",
   latitude:"39.5733",
   longitude:"-75.97"}
  ,
  {name:"St. Marks River Entrance, Florida",
   type:"T",
   latitude:"30.0783",
   longitude:"-84.1783"}
  ,
  {name:"Parsons Bay, Tasmania",
   type:"T",
   latitude:"-43.1",
   longitude:"147.75"}
  ,
  {name:"Nevlunghavn, Norway",
   type:"T",
   latitude:"58.9667",
   longitude:"9.8833"}
  ,
  {name:"East Narrows Dolphin, British Columbia",
   type:"T",
   latitude:"53.15",
   longitude:"-132.25"}
  ,
  {name:"Hukaura, Aomori, Japan",
   type:"T",
   latitude:"40.65",
   longitude:"139.933"}
  ,
  {name:"Balboa, Panama",
   type:"T",
   latitude:"8.9667",
   longitude:"-79.5667"}
  ,
  {name:"Virginia Beach, Virginia",
   type:"T",
   latitude:"36.8433",
   longitude:"-75.9717"}
  ,
  {name:"Elbow Cay, Cay Sal Bank, Bahamas",
   type:"T",
   latitude:"23.95",
   longitude:"-80.4667"}
  ,
  {name:"Fernandina Beach, Amelia River, Florida (4)",
   type:"T",
   latitude:"30.6717",
   longitude:"-81.4667"}
  ,
  {name:"Port Douglas, Australia",
   type:"T",
   latitude:"-16.4833",
   longitude:"145.4667"}
  ,
  {name:"Matugae, Nagasaki, Japan (2)",
   type:"T",
   latitude:"32.7333",
   longitude:"129.8667"}
  ,
  {name:"Puerto Gallegos, Argentina",
   type:"T",
   latitude:"-51.6",
   longitude:"-69.0167"}
  ,
  {name:"Chesapeake Bay Entrance, Virginia Current (2)",
   type:"C",
   latitude:"36.98",
   longitude:"-75.9983"}
  ,
  {name:"Nouadhibou, Mauritania",
   type:"T",
   latitude:"20.9167",
   longitude:"-17.0333"}
  ,
  {name:"Church Point, Nova Scotia",
   type:"T",
   latitude:"44.3333",
   longitude:"-66.1167"}
  ,
  {name:"Kristiansund, Norway",
   type:"T",
   latitude:"63.1167",
   longitude:"7.75"}
  ,
  {name:"Grondines, Québec",
   type:"T",
   latitude:"46.5833",
   longitude:"-72.0333"}
  ,
  {name:"Mackay Outer Harbour, Australia",
   type:"T",
   latitude:"-21.1167",
   longitude:"149.2333"}
  ,
  {name:"Katasima (Sukumo Wan), Koti, Japan",
   type:"T",
   latitude:"32.9",
   longitude:"132.7"}
  ,
  {name:"Port Augusta, Australia (2)",
   type:"T",
   latitude:"-32.5",
   longitude:"137.7667"}
  ,
  {name:"Auld Cove, Nova Scotia",
   type:"T",
   latitude:"45.65",
   longitude:"-61.4333"}
  ,
  {name:"Nagappattinam, India",
   type:"T",
   latitude:"10.7667",
   longitude:"79.85"}
  ,
  {name:"Salem, Massachusetts",
   type:"T",
   latitude:"42.5183",
   longitude:"-70.8867"}
  ,
  {name:"Coffin Point, Maine",
   type:"T",
   latitude:"44.8667",
   longitude:"-67.1333"}
  ,
  {name:"Jar Island, Australia",
   type:"T",
   latitude:"-14.15",
   longitude:"126.2333"}
  ,
  {name:"Fernandina Beach, Amelia River, Florida (5)",
   type:"T",
   latitude:"30.6717",
   longitude:"-81.4667"}
  ,
  {name:"Mocamedes, Angola",
   type:"T",
   latitude:"-15.2",
   longitude:"12.15"}
  ,
  {name:"Thursday Island, Torres Strait",
   type:"T",
   latitude:"-10.5833",
   longitude:"142.2167"}
  ,
  {name:"Flowers Cove, Newfoundland",
   type:"T",
   latitude:"51.3",
   longitude:"-56.7333"}
  ,
  {name:"Tadoussac, Saguenay River, Québec",
   type:"T",
   latitude:"48.1333",
   longitude:"-69.7167"}
  ,
  {name:"Caleta la Misión, Argentina",
   type:"T",
   latitude:"-53.7",
   longitude:"-67.8333"}
  ,
  {name:"Eisvík, Faroe Islands",
   type:"T",
   latitude:"62.3033",
   longitude:"-6.4713"}
  ,
  {name:"Drainey Inlet, British Columbia",
   type:"T",
   latitude:"51.4833",
   longitude:"-127.55"}
  ,
  {name:"Okawati Wan, Nagasaki, Japan",
   type:"T",
   latitude:"34.6833",
   longitude:"129.417"}
  ,
  {name:"Uwazima, Ehime, Japan",
   type:"T",
   latitude:"33.2333",
   longitude:"132.55"}
  ,
  {name:"Little Talbot Island, Florida (2)",
   type:"T",
   latitude:"30.43",
   longitude:"-81.405"}
  ,
  {name:"St. Petersburg, Florida",
   type:"T",
   latitude:"27.76",
   longitude:"-82.6267"}
  ,
  {name:"Oga, Akita, Japan",
   type:"T",
   latitude:"39.9333",
   longitude:"139.7"}
  ,
  {name:"Aransas Pass, Texas Current",
   type:"C",
   latitude:"27.8333",
   longitude:"-97.045"}
  ,
  {name:"Fernandina Beach, Amelia River, Florida (6)",
   type:"T",
   latitude:"30.6717",
   longitude:"-81.4667"}
  ,
  {name:"Green Island, Australia",
   type:"T",
   latitude:"-16.75",
   longitude:"145.9667"}
  ,
  {name:"Shortt Island, India",
   type:"T",
   latitude:"20.7833",
   longitude:"87.0667"}
  ,
  {name:"Stanovan, British Columbia",
   type:"T",
   latitude:"49.2833",
   longitude:"-123.0"}
  ,
  {name:"Vieques Passage, Puerto Rico Current",
   type:"C",
   latitude:"18.1883",
   longitude:"-65.6183"}
  ,
  {name:"Koartac, Québec",
   type:"T",
   latitude:"61.05",
   longitude:"-69.6333"}
  ,
  {name:"Troughton Island, Australia",
   type:"T",
   latitude:"-13.75",
   longitude:"126.1333"}
  ,
  {name:"Baten, Okinawa, Japan",
   type:"T",
   latitude:"26.1833",
   longitude:"127.783"}
  ,
  {name:"Little Talbot Island, Florida (3)",
   type:"T",
   latitude:"30.43",
   longitude:"-81.405"}
  ,
  {name:"Vaca Key, Florida Bay, Florida",
   type:"T",
   latitude:"24.7117",
   longitude:"-81.105"}
  ,
  {name:"Pedder Bay, British Columbia (2)",
   type:"T",
   latitude:"48.3333",
   longitude:"-123.55"}
  ,
  {name:"Steveston, British Columbia",
   type:"T",
   latitude:"49.1167",
   longitude:"-123.1667"}
  ,
  {name:"Lowestoft, England",
   type:"T",
   latitude:"52.4333",
   longitude:"1.75"}
  ,
  {name:"Nezumi Sima, Nagasaki, Japan",
   type:"T",
   latitude:"32.7167",
   longitude:"129.833"}
  ,
  {name:"Otrick Island, Nunavut",
   type:"T",
   latitude:"72.6",
   longitude:"-95.55"}
  ,
  {name:"Minjiang Kou, China",
   type:"T",
   latitude:"26.1333",
   longitude:"119.6333"}
  ,
  {name:"Tianjin Xingang, China",
   type:"T",
   latitude:"38.9833",
   longitude:"117.7"}
  ,
  {name:"Isla Martin Garcia, Argentina",
   type:"T",
   latitude:"-34.1833",
   longitude:"-58.25"}
  ,
  {name:"Stonehaven, New Brunswick",
   type:"T",
   latitude:"47.75",
   longitude:"-65.35"}
  ,
  {name:"Bassein River, Myanmar",
   type:"T",
   latitude:"15.8667",
   longitude:"94.2833"}
  ,
  {name:"Cordero Islands, British Columbia (2)",
   type:"T",
   latitude:"50.4333",
   longitude:"-125.4833"}
  ,
  {name:"Fernandina Beach, Amelia River, Florida (7)",
   type:"T",
   latitude:"30.6717",
   longitude:"-81.4667"}
  ,
  {name:"Kariya (Saga), Saga, Japan",
   type:"T",
   latitude:"33.4667",
   longitude:"129.85"}
  ,
  {name:"Salmon Cove, British Columbia (2)",
   type:"T",
   latitude:"55.2667",
   longitude:"-129.85"}
  ,
  {name:"Oki (Haha Sima), Tokyo, Japan",
   type:"T",
   latitude:"26.6333",
   longitude:"142.15"}
  ,
  {name:"Eden, Australia (2)",
   type:"T",
   latitude:"-37.0667",
   longitude:"149.9"}
  ,
  {name:"Shute Harbour, Australia",
   type:"T",
   latitude:"-20.2833",
   longitude:"148.7833"}
  ,
  {name:"Robinhood, Sasanoa River, Maine",
   type:"T",
   latitude:"43.8533",
   longitude:"-69.7333"}
  ,
  {name:"Mereworth Sound, British Columbia",
   type:"T",
   latitude:"51.0167",
   longitude:"-127.4167"}
  ,
  {name:"Centre Island, Australia",
   type:"T",
   latitude:"-15.75",
   longitude:"136.8167"}
  ,
  {name:"Georgetown, St. Johns River, Florida (3)",
   type:"T",
   latitude:"29.385",
   longitude:"-81.6367"}
  ,
  {name:"Turning Island, Nunavut",
   type:"T",
   latitude:"53.85",
   longitude:"-79.2167"}
  ,
  {name:"Cabot Strait, Nova Scotia",
   type:"T",
   latitude:"46.5833",
   longitude:"-59.75"}
  ,
  {name:"Fernandina Beach, Amelia River, Florida (8)",
   type:"T",
   latitude:"30.6717",
   longitude:"-81.4667"}
  ,
  {name:"Makuti, Kanagawa, Japan",
   type:"T",
   latitude:"35.15",
   longitude:"139.683"}
  ,
  {name:"East Strait Island, Torres Strait",
   type:"T",
   latitude:"-10.5",
   longitude:"142.45"}
  ,
  {name:"Darwin, Australia",
   type:"T",
   latitude:"-12.4667",
   longitude:"130.85"}
  ,
  {name:"Makkovik, Labrador",
   type:"T",
   latitude:"55.0833",
   longitude:"-59.1667"}
  ,
  {name:"Chipiona, Spain",
   type:"T",
   latitude:"36.75",
   longitude:"-6.4333"}
  ,
  {name:"Arisaig, Nova Scotia",
   type:"T",
   latitude:"45.7667",
   longitude:"-62.0167"}
  ,
  {name:"Vila do Porto, Santa Maria, Azores (2)",
   type:"T",
   latitude:"36.95",
   longitude:"-25.15"}
  ,
  {name:"Oro Bay, Papua New Guinea",
   type:"T",
   latitude:"-8.8833",
   longitude:"148.4833"}
  ,
  {name:"Tangao, Vanuatu",
   type:"T",
   latitude:"-15.5833",
   longitude:"166.9833"}
  ,
  {name:"Iriribusi, Hokkaido, Japan",
   type:"T",
   latitude:"44.7167",
   longitude:"147.35"}
  ,
  {name:"Owase, Mie, Japan",
   type:"T",
   latitude:"34.0667",
   longitude:"136.217"}
  ,
  {name:"Georgetown, St. Johns River, Florida (2)",
   type:"T",
   latitude:"29.385",
   longitude:"-81.6367"}
  ,
  {name:"Westport River Entrance, Massachusetts Current",
   type:"C",
   latitude:"41.5083",
   longitude:"-71.0883"}
  ,
  {name:"Port Essington, British Columbia",
   type:"T",
   latitude:"54.1667",
   longitude:"-129.9667"}
  ,
  {name:"Banda Harbour (Naira), Indonesia",
   type:"T",
   latitude:"-4.5333",
   longitude:"129.7167"}
  ,
  {name:"Waddington Harbour, British Columbia",
   type:"T",
   latitude:"50.9333",
   longitude:"-124.85"}
  ,
  {name:"Union Seamount, British Columbia",
   type:"T",
   latitude:"49.5833",
   longitude:"-132.7833"}
  ,
  {name:"Unnamed Reef No. 1, Australia (2)",
   type:"T",
   latitude:"-17.8667",
   longitude:"146.7167"}
  ,
  {name:"Cam Ranh, Vietnam",
   type:"T",
   latitude:"11.8833",
   longitude:"109.2"}
  ,
  {name:"Coffs Harbour, Australia",
   type:"T",
   latitude:"-30.3",
   longitude:"153.15"}
  ,
  {name:"Rose River, Australia",
   type:"T",
   latitude:"-14.2833",
   longitude:"135.7167"}
  ,
  {name:"Aden, Yemen",
   type:"T",
   latitude:"12.7833",
   longitude:"44.9833"}
  ,
  {name:"Douala, Cameroon (2)",
   type:"T",
   latitude:"4.05",
   longitude:"9.6667"}
  ,
  {name:"Georgetown, Tasmania",
   type:"T",
   latitude:"-41.1167",
   longitude:"146.8167"}
  ,
  {name:"Naozhou Dao, China",
   type:"T",
   latitude:"20.95",
   longitude:"110.6"}
  ,
  {name:"Woods Hole Oceanographic Institute, Massachusetts",
   type:"T",
   latitude:"41.525",
   longitude:"-70.6733"}
  ,
  {name:"Rijeka, Croatia",
   type:"T",
   latitude:"45.3333",
   longitude:"14.4167"}
  ,
  {name:"Tuktoyaktuk, Nunavut/NWT (2)",
   type:"T",
   latitude:"69.45",
   longitude:"-133.0"}
  ,
  {name:"Puerto de la Luz, Gran Canaria, Canary Islands",
   type:"T",
   latitude:"28.15",
   longitude:"-15.4167"}
  ,
  {name:"Lae, Papua New Guinea",
   type:"T",
   latitude:"-6.75",
   longitude:"147.0"}
  ,
  {name:"Gorge-Tillicum Bridge, British Columbia Current",
   type:"C",
   latitude:"48.45",
   longitude:"-123.4"}
  ,
  {name:"Gøta, Faroe Islands",
   type:"T",
   latitude:"62.1968",
   longitude:"-6.7405"}
  ,
  {name:"Barra do Riacho, Brazil",
   type:"T",
   latitude:"-19.8333",
   longitude:"-40.05"}
  ,
  {name:"Dingwall (Was 1510), Nova Scotia",
   type:"T",
   latitude:"46.9",
   longitude:"-60.4667"}
  ,
  {name:"Shinnecock Canal, Railroad Bridge, New York Current",
   type:"C",
   latitude:"40.8867",
   longitude:"-72.5017"}
  ,
  {name:"West Narrows, Nova Scotia",
   type:"T",
   latitude:"44.4",
   longitude:"-66.2167"}
  ,
  {name:"Strendur, Faroe Islands",
   type:"T",
   latitude:"62.1093",
   longitude:"-6.7565"}
  ,
  {name:"Dutch Harbor, Alaska (expired 1988-12-31)",
   type:"T",
   latitude:"53.8917",
   longitude:"-166.5367"}
  ,
  {name:"Pieman River, Tasmania",
   type:"T",
   latitude:"-41.6833",
   longitude:"145.1"}
  ,
  {name:"Jennis Bay, British Columbia (2)",
   type:"T",
   latitude:"50.9167",
   longitude:"-127.0167"}
  ,
  {name:"Komoda, Nagasaki, Japan",
   type:"T",
   latitude:"34.2333",
   longitude:"129.2"}
  ,
  {name:"Lynher Bank, Australia",
   type:"T",
   latitude:"-15.4667",
   longitude:"122.0167"}
  ,
  {name:"Bolinao, Philippines",
   type:"T",
   latitude:"16.4",
   longitude:"119.9"}
  ,
  {name:"Acadia Cove, Nunavut",
   type:"T",
   latitude:"61.35",
   longitude:"-64.9167"}
  ,
  {name:"Valdes Island, British Columbia (2)",
   type:"T",
   latitude:"49.05",
   longitude:"-123.6167"}
  ,
  {name:"Lewisetta, Potomac River, Virginia",
   type:"T",
   latitude:"37.9967",
   longitude:"-76.4633"}
  ,
  {name:"Marseille, France",
   type:"T",
   latitude:"43.3",
   longitude:"5.3667"}
  ,
  {name:"Clapboard Creek, Pelotes Island, St. Johns River, Florida (3)",
   type:"T",
   latitude:"30.4067",
   longitude:"-81.51"}
  ,
  {name:"Bedwell Harbour, British Columbia",
   type:"T",
   latitude:"48.7333",
   longitude:"-123.2333"}
  ,
  {name:"Otaru, Hokkaido, Japan (2)",
   type:"T",
   latitude:"43.2167",
   longitude:"141.0167"}
  ,
  {name:"Norfolk Island, Tasman Sea",
   type:"T",
   latitude:"-29.0667",
   longitude:"167.9333"}
  ,
  {name:"Antwerpen, Belgium",
   type:"T",
   latitude:"51.2333",
   longitude:"4.4"}
  ,
  {name:"Qlawdzeet Anchorage, British Columbia (2)",
   type:"T",
   latitude:"54.2167",
   longitude:"-130.7667"}
  ,
  {name:"East Tocoi, St. Johns River, Florida",
   type:"T",
   latitude:"29.8583",
   longitude:"-81.5533"}
  ,
  {name:"Port Moresby, Papua New Guinea (2)",
   type:"T",
   latitude:"-9.4833",
   longitude:"147.1333"}
  ,
  {name:"Isla De Cozumel, Mexico",
   type:"T",
   latitude:"20.5",
   longitude:"-87.0"}
  ,
  {name:"Panama City Beach, Florida",
   type:"T",
   latitude:"30.2133",
   longitude:"-85.88"}
  ,
  {name:"Aratu, Brazil",
   type:"T",
   latitude:"-12.7833",
   longitude:"-38.5"}
  ,
  {name:"Narvik, Norway",
   type:"T",
   latitude:"68.4167",
   longitude:"17.4"}
  ,
  {name:"Klakksvík, Faroe Islands",
   type:"T",
   latitude:"62.254",
   longitude:"-6.5813"}
  ,
  {name:"Port Kembla, Australia",
   type:"T",
   latitude:"-34.4833",
   longitude:"150.9167"}
  ,
  {name:"Hunters Point, San Francisco Bay, California (2)",
   type:"T",
   latitude:"37.7333",
   longitude:"-122.35"}
  ,
  {name:"Newcastle, Australia",
   type:"T",
   latitude:"-32.9333",
   longitude:"151.7833"}
  ,
  {name:"Clapboard Creek, Pelotes Island, St. Johns River, Florida (4)",
   type:"T",
   latitude:"30.4067",
   longitude:"-81.51"}
  ,
  {name:"Immigration Wharf, Québec",
   type:"T",
   latitude:"46.8",
   longitude:"-71.2333"}
  ,
  {name:"Togi Ura, Nagasaki, Japan",
   type:"T",
   latitude:"32.75",
   longitude:"128.833"}
  ,
  {name:"Wakatu, Saga, Japan",
   type:"T",
   latitude:"33.2167",
   longitude:"130.35"}
  ,
  {name:"Port Moresby, Papua New Guinea (3)",
   type:"T",
   latitude:"-9.4833",
   longitude:"147.1"}
  ,
  {name:"Gladstone, Australia",
   type:"T",
   latitude:"-23.8333",
   longitude:"151.25"}
  ,
  {name:"Eta Uti, Hirosima, Japan",
   type:"T",
   latitude:"34.25",
   longitude:"132.467"}
  ,
  {name:"Geraldton, Australia",
   type:"T",
   latitude:"-28.7833",
   longitude:"114.5833"}
  ,
  {name:"San Juan, Puerto Rico",
   type:"T",
   latitude:"18.4617",
   longitude:"-66.1167"}
  ,
  {name:"Shiogama, Japan",
   type:"T",
   latitude:"38.3167",
   longitude:"141.1167"}
  ,
  {name:"Punta Arenas, Chile",
   type:"T",
   latitude:"-53.1667",
   longitude:"-70.9"}
  ,
  {name:"Sibetoro, Hokkaido, Japan",
   type:"T",
   latitude:"45.5",
   longitude:"148.617"}
  ,
  {name:"Anse Aux Gascons, Québec",
   type:"T",
   latitude:"48.1833",
   longitude:"-64.8667"}
  ,
  {name:"Mogadishu, Somalia",
   type:"T",
   latitude:"2.0333",
   longitude:"45.35"}
  ,
  {name:"Cape May, ferry terminal, Delaware Bay, New Jersey",
   type:"T",
   latitude:"38.9683",
   longitude:"-74.96"}
  ,
  {name:"Copper Islands, British Columbia",
   type:"T",
   latitude:"52.35",
   longitude:"-131.1667"}
  ,
  {name:"Daytona Beach Shores (Sunglow Pier), Florida (3)",
   type:"T",
   latitude:"29.1467",
   longitude:"-80.9633"}
  ,
  {name:"Ecstall River, British Columbia",
   type:"T",
   latitude:"54.0",
   longitude:"-129.7667"}
  ,
  {name:"Yotukura, Fukusima, Japan",
   type:"T",
   latitude:"37.1",
   longitude:"141.0"}
  ,
  {name:"Durban, South Africa",
   type:"T",
   latitude:"-29.8667",
   longitude:"31.05"}
  ,
  {name:"Tasmania Island, Nunavut",
   type:"T",
   latitude:"71.2",
   longitude:"-96.4167"}
  ,
  {name:"Boston Harbor, Massachusetts Current",
   type:"C",
   latitude:"42.3383",
   longitude:"-70.9567"}
  ,
  {name:"Come By Chance, Newfoundland",
   type:"T",
   latitude:"47.8167",
   longitude:"-54.0167"}
  ,
  {name:"Noumea, New Caledonia",
   type:"T",
   latitude:"-22.3",
   longitude:"166.4333"}
  ,
  {name:"Santa Monica, Municipal Pier, California",
   type:"T",
   latitude:"34.0067",
   longitude:"-118.4983"}
  ,
  {name:"Cape Cod Canal, Massachusetts Current",
   type:"C",
   latitude:"41.7417",
   longitude:"-70.6133"}
  ,
  {name:"Great St. Lawrence Harbour, Newfoundland",
   type:"T",
   latitude:"46.9",
   longitude:"-55.3667"}
  ,
  {name:"Hartley Bay, British Columbia",
   type:"T",
   latitude:"53.4333",
   longitude:"-129.25"}
  ,
  {name:"Surf Inlet, British Columbia",
   type:"T",
   latitude:"53.0333",
   longitude:"-128.9"}
  ,
  {name:"Clapboard Creek, Pelotes Island, St. Johns River, Florida (2)",
   type:"T",
   latitude:"30.4067",
   longitude:"-81.51"}
  ,
  {name:"Iqaluit, Nunavut",
   type:"T",
   latitude:"63.7167",
   longitude:"-68.5333"}
  ,
  {name:"Makung, China",
   type:"T",
   latitude:"23.55",
   longitude:"119.55"}
  ,
  {name:"O Ura (Tane-Ga-Sima), Kagosima, Japan",
   type:"T",
   latitude:"30.45",
   longitude:"130.967"}
  ,
  {name:"Twin Rivers Marina, Crystal River, Florida",
   type:"T",
   latitude:"28.905",
   longitude:"-82.6383"}
  ,
  {name:"Ina, Nagasaki, Japan",
   type:"T",
   latitude:"34.55",
   longitude:"129.317"}
  ,
  {name:"Cedar Tree Neck, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.4333",
   longitude:"-70.7"}
  ,
  {name:"Daytona Beach Shores (Sunglow Pier), Florida (2)",
   type:"T",
   latitude:"29.1467",
   longitude:"-80.9633"}
  ,
  {name:"Buenos Aires, Argentina (2)",
   type:"T",
   latitude:"-34.5667",
   longitude:"-58.3833"}
  ,
  {name:"Georgetown, St. Johns River, Florida (4)",
   type:"T",
   latitude:"29.385",
   longitude:"-81.6367"}
  ,
  {name:"Natal, Brazil",
   type:"T",
   latitude:"-5.7667",
   longitude:"-35.2"}
  ,
  {name:"Carnarvon, Australia",
   type:"T",
   latitude:"-24.8667",
   longitude:"113.65"}
  ,
  {name:"Huehuki, Nagasaki, Japan",
   type:"T",
   latitude:"33.1833",
   longitude:"129.05"}
  ,
  {name:"Koper, Slovenia",
   type:"T",
   latitude:"45.55",
   longitude:"13.7333"}
  ,
  {name:"Upper Port Latour, Nova Scotia",
   type:"T",
   latitude:"43.5167",
   longitude:"-65.4667"}
  ,
  {name:"Churchill, Manitoba (2)",
   type:"T",
   latitude:"58.7833",
   longitude:"-94.2"}
  ,
  {name:"Pushthrough, Newfoundland",
   type:"T",
   latitude:"47.6333",
   longitude:"-56.1667"}
  ,
  {name:"Meadowdale, Washington",
   type:"T",
   latitude:"47.85",
   longitude:"-122.0333"}
  ,
  {name:"Billygoat Bay, British Columbia (2)",
   type:"T",
   latitude:"50.4",
   longitude:"-125.8667"}
  ,
  {name:"Portland, Maine",
   type:"T",
   latitude:"43.6567",
   longitude:"-70.2467"}
  ,
  {name:"Entrance Island, Nunavut",
   type:"T",
   latitude:"69.9",
   longitude:"-85.6"}
  ,
  {name:"Disraeli Fiord, Nunavut",
   type:"T",
   latitude:"82.8833",
   longitude:"-73.05"}
  ,
  {name:"Ozaki Ura, Nagasaki, Japan",
   type:"T",
   latitude:"34.3167",
   longitude:"129.217"}
  ,
  {name:"Nacala, Mozambique",
   type:"T",
   latitude:"-14.4667",
   longitude:"40.6833"}
  ,
  {name:"Hamburg, Germany",
   type:"T",
   latitude:"53.55",
   longitude:"9.9667"}
  ,
  {name:"Tai, Kyoto, Japan",
   type:"T",
   latitude:"35.5833",
   longitude:"135.233"}
  ,
  {name:"Nakwakto Rapids, British Columbia Current",
   type:"C",
   latitude:"51.0967",
   longitude:"-127.5033"}
  ,
  {name:"Seattle, Washington (2)",
   type:"T",
   latitude:"47.6",
   longitude:"-122.0333"}
  ,
  {name:"Phuket, Thailand",
   type:"T",
   latitude:"7.765",
   longitude:"98.425"}
  ,
  {name:"Haderuma, Okinawa, Japan",
   type:"T",
   latitude:"24.0667",
   longitude:"123.767"}
  ,
  {name:"Red Bank, Navesink River, New Jersey",
   type:"T",
   latitude:"40.355",
   longitude:"-74.065"}
  ,
  {name:"Florianópolis, Brazil",
   type:"T",
   latitude:"-27.5833",
   longitude:"-48.55"}
  ,
  {name:"Waratah Bay, Australia",
   type:"T",
   latitude:"-38.8667",
   longitude:"146.0"}
  ,
  {name:"Cape Bald, Prince Edward Island",
   type:"T",
   latitude:"46.2333",
   longitude:"-64.2333"}
  ,
  {name:"Sombrero Key, Hawk Channel, Florida",
   type:"T",
   latitude:"24.6267",
   longitude:"-81.1117"}
  ,
  {name:"Harumi (Tokyo), Tokyo, Japan",
   type:"T",
   latitude:"35.65",
   longitude:"139.767"}
  ,
  {name:"Seitetu-Tobata-Hakuti, Hukuoka, Japan",
   type:"T",
   latitude:"33.9167",
   longitude:"130.85"}
  ,
  {name:"Surinam River, Surinam (2)",
   type:"T",
   latitude:"5.9667",
   longitude:"-55.2167"}
  ,
  {name:"Tongyong (Ch'ungmu), South Korea",
   type:"T",
   latitude:"34.8333",
   longitude:"128.4167"}
  ,
  {name:"Naha Ko, Okinawa, Japan (2)",
   type:"T",
   latitude:"26.2",
   longitude:"127.6667"}
  ,
  {name:"Lagos Bar, Nigeria",
   type:"T",
   latitude:"6.4",
   longitude:"3.4"}
  ,
  {name:"Santa Cruz de Tenerife, Canary Islands",
   type:"T",
   latitude:"28.4833",
   longitude:"-16.2333"}
  ,
  {name:"Wyndham, Australia (2)",
   type:"T",
   latitude:"-15.45",
   longitude:"128.1"}
  ,
  {name:"Sarahama, Okinawa, Japan",
   type:"T",
   latitude:"24.8333",
   longitude:"125.217"}
  ,
  {name:"Izumi Ura, Nagasaki, Japan",
   type:"T",
   latitude:"34.6667",
   longitude:"129.483"}
  ,
  {name:"Fremantle, Australia (2)",
   type:"T",
   latitude:"-32.05",
   longitude:"115.75"}
  ,
  {name:"Matunami, Ishikawa, Japan",
   type:"T",
   latitude:"37.35",
   longitude:"137.25"}
  ,
  {name:"Powell River (Strait of Georgia), British Columbia (2)",
   type:"T",
   latitude:"49.8667",
   longitude:"-124.55"}
  ,
  {name:"Sand Head, Ontario",
   type:"T",
   latitude:"51.4167",
   longitude:"-80.35"}
  ,
  {name:"Dublin, Ireland (2)",
   type:"T",
   latitude:"53.35",
   longitude:"-6.2167"}
  ,
  {name:"Oginohama, Miyagi, Japan",
   type:"T",
   latitude:"38.3667",
   longitude:"141.45"}
  ,
  {name:"Dampier, Australia",
   type:"T",
   latitude:"-20.65",
   longitude:"116.7167"}
  ,
  {name:"White Bear Arm, Labrador",
   type:"T",
   latitude:"52.7333",
   longitude:"-55.8333"}
  ,
  {name:"Malaga, Spain",
   type:"T",
   latitude:"36.7167",
   longitude:"-4.4167"}
  ,
  {name:"Race Passage, British Columbia Current",
   type:"C",
   latitude:"48.3067",
   longitude:"-123.5367"}
  ,
  {name:"Savage Cove, Newfoundland",
   type:"T",
   latitude:"51.3333",
   longitude:"-56.7"}
  ,
  {name:"Addenbroke Island, British Columbia",
   type:"T",
   latitude:"51.6",
   longitude:"-127.5167"}
  ,
  {name:"Chesterfield Inlet, Nunavut",
   type:"T",
   latitude:"63.0333",
   longitude:"-90.7"}
  ,
  {name:"Ocean City, Isle of Wight Bay, Maryland",
   type:"T",
   latitude:"38.3317",
   longitude:"-75.09"}
  ,
  {name:"Hoek van Holland, Netherlands",
   type:"T",
   latitude:"51.9833",
   longitude:"4.1167"}
  ,
  {name:"Oostende, Belgium",
   type:"T",
   latitude:"51.2333",
   longitude:"2.9333"}
  ,
  {name:"Forteau Bay, Strait of Bell Isle, Labrador",
   type:"T",
   latitude:"51.45",
   longitude:"-56.8833"}
  ,
  {name:"Lome, Togo",
   type:"T",
   latitude:"6.1167",
   longitude:"1.2167"}
  ,
  {name:"Cape Acadia, Québec",
   type:"T",
   latitude:"61.5833",
   longitude:"-78.8667"}
  ,
  {name:"Mina Su`ud, Kuwait",
   type:"T",
   latitude:"28.7333",
   longitude:"48.4"}
  ,
  {name:"Siomi Ura, Kurile Islands",
   type:"T",
   latitude:"49.5167",
   longitude:"154.733"}
  ,
  {name:"Irvines Landing, British Columbia (2)",
   type:"T",
   latitude:"49.6333",
   longitude:"-124.05"}
  ,
  {name:"Fremantle, Australia",
   type:"T",
   latitude:"-32.05",
   longitude:"115.7333"}
  ,
  {name:"Borrowman Bay, British Columbia",
   type:"T",
   latitude:"52.7333",
   longitude:"-129.2833"}
  ,
  {name:"Setana, Hokkaido, Japan",
   type:"T",
   latitude:"42.4667",
   longitude:"139.85"}
  ,
  {name:"Beachside, Newfoundland",
   type:"T",
   latitude:"49.6333",
   longitude:"-55.8833"}
  ,
  {name:"Nantucket Harbor Entrance Channel, Massachusetts Current",
   type:"C",
   latitude:"41.3067",
   longitude:"-70.1"}
  ,
  {name:"Bella Bella, British Columbia",
   type:"T",
   latitude:"52.1667",
   longitude:"-128.1333"}
  ,
  {name:"Djibouti, Djibouti",
   type:"T",
   latitude:"11.5833",
   longitude:"43.15"}
  ,
  {name:"Helgoland, Germany",
   type:"T",
   latitude:"55.1833",
   longitude:"7.9"}
  ,
  {name:"Maputo, Mozambique",
   type:"T",
   latitude:"-25.9833",
   longitude:"32.5667"}
  ,
  {name:"Santa Cruz, Philippines",
   type:"T",
   latitude:"15.7667",
   longitude:"119.9"}
  ,
  {name:"La Pointe, Nova Scotia",
   type:"T",
   latitude:"46.6",
   longitude:"-61.05"}
  ,
  {name:"Lewis Bay, Nunavut",
   type:"T",
   latitude:"63.6",
   longitude:"-68.0667"}
  ,
  {name:"Fundy (Offshore 3), Nova Scotia",
   type:"T",
   latitude:"41.7333",
   longitude:"-65.8"}
  ,
  {name:"Finlayson Arm, British Columbia",
   type:"T",
   latitude:"48.5",
   longitude:"-123.55"}
  ,
  {name:"Wakayama, Wakayama, Japan",
   type:"T",
   latitude:"34.2167",
   longitude:"135.15"}
  ,
  {name:"Hunagosi Wan, Miyagi, Japan",
   type:"T",
   latitude:"38.5333",
   longitude:"141.517"}
  ,
  {name:"Tod Inlet, British Columbia",
   type:"T",
   latitude:"48.5667",
   longitude:"-123.4667"}
  ,
  {name:"Griffin Passage, British Columbia (2)",
   type:"T",
   latitude:"52.75",
   longitude:"-128.3667"}
  ,
  {name:"Georgetown, Guyana",
   type:"T",
   latitude:"6.8333",
   longitude:"-58.1667"}
  ,
  {name:"Liscomb Harbour, Nova Scotia",
   type:"T",
   latitude:"45.0167",
   longitude:"-62.0"}
  ,
  {name:"Sand Heads, British Columbia (2)",
   type:"T",
   latitude:"49.1",
   longitude:"-123.3"}
  ,
  {name:"Esperanza Station, Antarctica",
   type:"T",
   latitude:"-63.3",
   longitude:"-56.9167"}
  ,
  {name:"Sungai Muturi, New Guinea, Indonesia",
   type:"T",
   latitude:"-2.2333",
   longitude:"133.65"}
  ,
  {name:"Diligent River, Nova Scotia",
   type:"T",
   latitude:"45.4",
   longitude:"-64.4167"}
  ,
  {name:"Fulton, St. Johns River, Florida",
   type:"T",
   latitude:"30.39",
   longitude:"-81.5067"}
  ,
  {name:"Saint George's Harbour, Grenada",
   type:"T",
   latitude:"12.05",
   longitude:"-61.75"}
  ,
  {name:"Crescent Beach, British Columbia (2)",
   type:"T",
   latitude:"49.0333",
   longitude:"-122.8833"}
  ,
  {name:"Holyhead, Wales",
   type:"T",
   latitude:"53.3167",
   longitude:"-4.6167"}
  ,
  {name:"Rosyth, Scotland",
   type:"T",
   latitude:"56.0167",
   longitude:"-3.45"}
  ,
  {name:"Reveley Island, Australia",
   type:"T",
   latitude:"-14.35",
   longitude:"127.8"}
  ,
  {name:"Thursday Island, Torres Strait (2)",
   type:"T",
   latitude:"-10.5833",
   longitude:"142.2167"}
  ,
  {name:"Les Sables-d'Olonne, France",
   type:"T",
   latitude:"46.5",
   longitude:"-1.8"}
  ,
  {name:"Eucla, Australia",
   type:"T",
   latitude:"-31.7167",
   longitude:"128.8833"}
  ,
  {name:"Winchelsea Island, British Columbia",
   type:"T",
   latitude:"49.3",
   longitude:"-124.0833"}
  ,
  {name:"Kazura, Oita, Japan",
   type:"T",
   latitude:"32.9833",
   longitude:"131.9"}
  ,
  {name:"The Narrows (North End), Puget Sound, Washington Current",
   type:"C",
   latitude:"47.3",
   longitude:"-122.55"}
  ,
  {name:"Penrith Island, Australia",
   type:"T",
   latitude:"-21.0",
   longitude:"149.9"}
  ,
  {name:"Pelham Bay, Belcher Channel, Nunavut",
   type:"T",
   latitude:"76.75",
   longitude:"-96.9"}
  ,
  {name:"Gordon Islands, British Columbia",
   type:"T",
   latitude:"52.1",
   longitude:"-131.2167"}
  ,
  {name:"Greville, South Island, New Zealand",
   type:"T",
   latitude:"-40.8667",
   longitude:"173.8"}
  ,
  {name:"Hunabasi, Tiba, Japan",
   type:"T",
   latitude:"35.6833",
   longitude:"139.983"}
  ,
  {name:"Takada, Oita, Japan",
   type:"T",
   latitude:"33.5833",
   longitude:"131.433"}
  ,
  {name:"Tom Bay, British Columbia",
   type:"T",
   latitude:"52.4",
   longitude:"-128.2667"}
  ,
  {name:"Twin Island, Torres Strait",
   type:"T",
   latitude:"-10.4667",
   longitude:"142.4333"}
  ,
  {name:"St. Johns River at Long Branch, USCOE dredge depot, Florida",
   type:"T",
   latitude:"30.3575",
   longitude:"-81.6129"}
  ,
  {name:"Ostrov Kharimkotan, Kurile Islands",
   type:"T",
   latitude:"49.1667",
   longitude:"154.483"}
  ,
  {name:"Kasaoka, Okayama, Japan",
   type:"T",
   latitude:"34.5",
   longitude:"133.5"}
  ,
  {name:"Malpeque, Prince Edward Island",
   type:"T",
   latitude:"46.5333",
   longitude:"-63.7"}
  ,
  {name:"Lobito, Angola",
   type:"T",
   latitude:"-12.3333",
   longitude:"13.5667"}
  ,
  {name:"Omae Saki, Sizuoka, Japan",
   type:"T",
   latitude:"34.6",
   longitude:"138.233"}
  ,
  {name:"Echo Shoal, Australia",
   type:"T",
   latitude:"-10.15",
   longitude:"126.8167"}
  ,
  {name:"Portage Island, off Prince Edward Island",
   type:"T",
   latitude:"47.2",
   longitude:"-65.1333"}
  ,
  {name:"Iwanai, Hokkaido, Japan",
   type:"T",
   latitude:"42.9833",
   longitude:"140.5"}
  ,
  {name:"Onehunga, New Zealand",
   type:"T",
   latitude:"-36.9333",
   longitude:"174.7833"}
  ,
  {name:"Mermaid Bay, British Columbia",
   type:"T",
   latitude:"50.4",
   longitude:"-125.1833"}
  ,
  {name:"Yokosuka, Kanagawa, Japan",
   type:"T",
   latitude:"35.2833",
   longitude:"139.65"}
  ,
  {name:"Matumae, Hokkaido, Japan",
   type:"T",
   latitude:"41.4167",
   longitude:"140.083"}
  ,
  {name:"Caribou, Nova Scotia",
   type:"T",
   latitude:"45.7333",
   longitude:"-62.6833"}
  ,
  {name:"Fox Island, Miramich, New Brunswick",
   type:"T",
   latitude:"47.1167",
   longitude:"-65.05"}
  ,
  {name:"Cape Egmont, Prince Edward Island",
   type:"T",
   latitude:"46.4",
   longitude:"-64.1333"}
  ,
  {name:"Coffs Harbour, Australia (2)",
   type:"T",
   latitude:"-30.3",
   longitude:"153.15"}
  ,
  {name:"Izasiki, Kagosima, Japan",
   type:"T",
   latitude:"31.1",
   longitude:"130.7"}
  ,
  {name:"Cape Parry, Nunavut/NWT",
   type:"T",
   latitude:"70.15",
   longitude:"-124.0667"}
  ,
  {name:"Caissie Point, New Brunswick",
   type:"T",
   latitude:"46.0333",
   longitude:"-64.5167"}
  ,
  {name:"Malecon, Venezuela",
   type:"T",
   latitude:"11.0",
   longitude:"-71.5833"}
  ,
  {name:"Port Elgin, New Brunswick",
   type:"T",
   latitude:"46.05",
   longitude:"-64.0667"}
  ,
  {name:"Lesueur Island, Australia",
   type:"T",
   latitude:"-13.8333",
   longitude:"127.2833"}
  ,
  {name:"Port Alberni, British Columbia",
   type:"T",
   latitude:"49.2333",
   longitude:"-124.8167"}
  ,
  {name:"Hilo, Hilo Bay, Hawaii",
   type:"T",
   latitude:"19.7333",
   longitude:"-155.0583"}
  ,
  {name:"Timaru Harbour, New Zealand",
   type:"T",
   latitude:"-44.4",
   longitude:"171.25"}
  ,
  {name:"Cormoran, New Brunswick",
   type:"T",
   latitude:"47.1167",
   longitude:"-65.15"}
  ,
  {name:"Puerto Armuelles, Panama",
   type:"T",
   latitude:"8.2667",
   longitude:"-82.85"}
  ,
  {name:"Green Cove Springs, St. Johns River, Florida (2)",
   type:"T",
   latitude:"29.99",
   longitude:"-81.6633"}
  ,
  {name:"Niihama, Ehime, Japan",
   type:"T",
   latitude:"33.9667",
   longitude:"133.267"}
  ,
  {name:"Venezia, Italy",
   type:"T",
   latitude:"45.4333",
   longitude:"12.3333"}
  ,
  {name:"Oyster Point, California Current",
   type:"C",
   latitude:"37.665",
   longitude:"-122.3233"}
  ,
  {name:"St. Johns River at Dames Point (N. end, SR 9A bridge), Florida (5)",
   type:"T",
   latitude:"30.3869",
   longitude:"-81.5581"}
  ,
  {name:"Halls Boathouse, Washington",
   type:"T",
   latitude:"48.05",
   longitude:"-123.55"}
  ,
  {name:"Port Muhammad Bin Qasin, Pakistan",
   type:"T",
   latitude:"24.7833",
   longitude:"67.35"}
  ,
  {name:"St. Michael, Alaska",
   type:"T",
   latitude:"63.475",
   longitude:"-162.0267"}
  ,
  {name:"Moa Island, Torres Strait",
   type:"T",
   latitude:"-10.2333",
   longitude:"142.2167"}
  ,
  {name:"Lizard Island, Australia",
   type:"T",
   latitude:"-14.6667",
   longitude:"145.45"}
  ,
  {name:"Mosselbaai, South Africa",
   type:"T",
   latitude:"-34.1833",
   longitude:"22.15"}
  ,
  {name:"Ryotu, Niigata, Japan",
   type:"T",
   latitude:"38.0833",
   longitude:"138.433"}
  ,
  {name:"Belfast, Northern Ireland",
   type:"T",
   latitude:"54.6",
   longitude:"-5.9167"}
  ,
  {name:"Sabine Pass, Texas",
   type:"T",
   latitude:"29.7067",
   longitude:"-93.8533"}
  ,
  {name:"Onagawa, Miyagi, Japan",
   type:"T",
   latitude:"38.4333",
   longitude:"141.467"}
  ,
  {name:"Meyers Narrows, British Columbia",
   type:"T",
   latitude:"52.6",
   longitude:"-128.6167"}
  ,
  {name:"Bathurst, New Brunswick",
   type:"T",
   latitude:"47.6167",
   longitude:"-65.65"}
  ,
  {name:"Charlottetown, Prince Edward Island (2)",
   type:"T",
   latitude:"46.2167",
   longitude:"-63.1167"}
  ,
  {name:"Tampa Bay Entrance (Egmont Channel), Florida Current",
   type:"C",
   latitude:"27.605",
   longitude:"-82.76"}
  ,
  {name:"Green Cove Springs, St. Johns River, Florida (3)",
   type:"T",
   latitude:"29.99",
   longitude:"-81.6633"}
  ,
  {name:"Neguac, New Brunswick",
   type:"T",
   latitude:"47.25",
   longitude:"-65.0833"}
  ,
  {name:"Simotu, Wakayama, Japan",
   type:"T",
   latitude:"34.1167",
   longitude:"135.133"}
  ,
  {name:"Bear Islands, Nunavut",
   type:"T",
   latitude:"55.1",
   longitude:"-78.35"}
  ,
  {name:"Cowichan Bay, British Columbia (2)",
   type:"T",
   latitude:"48.7333",
   longitude:"-123.6167"}
  ,
  {name:"Locks Cove, Newfoundland",
   type:"T",
   latitude:"51.3333",
   longitude:"-55.95"}
  ,
  {name:"Sonoyama, Kagosima, Japan",
   type:"T",
   latitude:"31.6167",
   longitude:"130.7"}
  ,
  {name:"Buffalo Bluff, St. Johns River, Florida (2)",
   type:"T",
   latitude:"29.595",
   longitude:"-81.6817"}
  ,
  {name:"Kainan, Wakayama, Japan",
   type:"T",
   latitude:"34.15",
   longitude:"135.2"}
  ,
  {name:"Milner Bay, Australia",
   type:"T",
   latitude:"-13.8333",
   longitude:"136.5"}
  ,
  {name:"St. Johns River at Bar Pilot Dock, Florida",
   type:"T",
   latitude:"30.3969",
   longitude:"-81.4294"}
  ,
  {name:"Eleuthera Island (west coast), Bahamas",
   type:"T",
   latitude:"25.25",
   longitude:"-76.3167"}
  ,
  {name:"Belcher Point, Nunavut",
   type:"T",
   latitude:"75.7667",
   longitude:"-81.0833"}
  ,
  {name:"Green Cove Springs, St. Johns River, Florida (4)",
   type:"T",
   latitude:"29.99",
   longitude:"-81.6633"}
  ,
  {name:"Rose Harbour, British Columbia (2)",
   type:"T",
   latitude:"52.15",
   longitude:"-131.0833"}
  ,
  {name:"Brest, France",
   type:"T",
   latitude:"48.3333",
   longitude:"-4.4833"}
  ,
  {name:"Stamp Narrows, British Columbia",
   type:"T",
   latitude:"49.1833",
   longitude:"-124.8167"}
  ,
  {name:"Cervantes, Australia",
   type:"T",
   latitude:"-30.5",
   longitude:"115.0667"}
  ,
  {name:"Kihei, Maui (Hawaii)",
   type:"T",
   latitude:"20.7833",
   longitude:"-156.4667"}
  ,
  {name:"Porto Grande, Cape Verde Islands",
   type:"T",
   latitude:"16.8667",
   longitude:"-24.9833"}
  ,
  {name:"Anacortes, Guemes Channel, Washington",
   type:"T",
   latitude:"48.5167",
   longitude:"-122.6167"}
  ,
  {name:"Bangor, Washington",
   type:"T",
   latitude:"47.7483",
   longitude:"-122.7267"}
  ,
  {name:"Bernard Harbour, Nunavut/NWT",
   type:"T",
   latitude:"68.7833",
   longitude:"-114.7833"}
  ,
  {name:"Ayukawa, Miyagi, Japan",
   type:"T",
   latitude:"38.3",
   longitude:"141.517"}
  ,
  {name:"Alotau, Papua New Guinea (2)",
   type:"T",
   latitude:"-10.3167",
   longitude:"150.45"}
  ,
  {name:"Paramaribo, Suriname",
   type:"T",
   latitude:"5.8333",
   longitude:"-55.15"}
  ,
  {name:"Datum Bay, Acklins Island, Bahamas",
   type:"T",
   latitude:"22.1667",
   longitude:"-74.3"}
  ,
  {name:"Grosse-Île, Québec",
   type:"T",
   latitude:"47.0333",
   longitude:"-70.6667"}
  ,
  {name:"Dixie Bay, Salt River, Crystal Bay, Florida",
   type:"T",
   latitude:"28.8817",
   longitude:"-82.635"}
  ,
  {name:"Green Cove Springs, St. Johns River, Florida (5)",
   type:"T",
   latitude:"29.99",
   longitude:"-81.6633"}
  ,
  {name:"Oakland, California",
   type:"T",
   latitude:"37.8167",
   longitude:"-122.3667"}
  ,
  {name:"Les Escoumins, Québec",
   type:"T",
   latitude:"48.35",
   longitude:"-69.3833"}
  ,
  {name:"Daufuskie Landing, Daufuskie Island, New River, South Carolina",
   type:"T",
   latitude:"32.1",
   longitude:"-80.9"}
  ,
  {name:"Osika Wan, Nagasaki, Japan",
   type:"T",
   latitude:"34.5167",
   longitude:"129.45"}
  ,
  {name:"Bukhta Babushkina, Kurile Islands",
   type:"T",
   latitude:"50.65",
   longitude:"156.4"}
  ,
  {name:"President Channel, Orcas Island, Washington",
   type:"T",
   latitude:"48.655",
   longitude:"-123.0083"}
  ,
  {name:"Rockport, Aransas Bay, Texas (2)",
   type:"T",
   latitude:"28.0217",
   longitude:"-97.0467"}
  ,
  {name:"Sukui-No-Ura, Nagasaki, Japan",
   type:"T",
   latitude:"33.0833",
   longitude:"129.717"}
  ,
  {name:"No Name Key (northeast of), Florida Current",
   type:"C",
   latitude:"24.705",
   longitude:"-81.3133"}
  ,
  {name:"Anaga Ura, Hyogo, Japan",
   type:"T",
   latitude:"34.2667",
   longitude:"134.667"}
  ,
  {name:"Morehead City, North Carolina",
   type:"T",
   latitude:"34.72",
   longitude:"-76.7267"}
  ,
  {name:"Henley Harbour, Labrador",
   type:"T",
   latitude:"51.9833",
   longitude:"-55.85"}
  ,
  {name:"Pleasant Bay, Quonset Pont, Massachusetts",
   type:"T",
   latitude:"41.7367",
   longitude:"-69.9817"}
  ,
  {name:"St. Mary Harbour, St. Mary Bay, Newfoundland",
   type:"T",
   latitude:"46.9333",
   longitude:"-53.5833"}
  ,
  {name:"Rensselaer Bugt, Greenland",
   type:"T",
   latitude:"78.6167",
   longitude:"-71.0"}
  ,
  {name:"Sibaura, Tokyo, Japan (2)",
   type:"T",
   latitude:"35.6333",
   longitude:"139.75"}
  ,
  {name:"Tanquary Camp, Nunavut",
   type:"T",
   latitude:"81.4",
   longitude:"-76.9167"}
  ,
  {name:"Khowr-e Musa, Iran",
   type:"T",
   latitude:"30.0",
   longitude:"49.0"}
  ,
  {name:"Hikawa (Yonakuni Sima), Okinawa, Japan",
   type:"T",
   latitude:"24.4167",
   longitude:"123.0"}
  ,
  {name:"Hudson, Florida",
   type:"T",
   latitude:"28.3667",
   longitude:"-82.7"}
  ,
  {name:"Camden Haven, Australia",
   type:"T",
   latitude:"-31.6333",
   longitude:"152.8167"}
  ,
  {name:"Oak Landing, ICWW, Florida (2)",
   type:"T",
   latitude:"30.2533",
   longitude:"-81.43"}
  ,
  {name:"Channel Key, west side, Florida",
   type:"T",
   latitude:"24.6033",
   longitude:"-81.725"}
  ,
  {name:"McKenney Islands, British Columbia (2)",
   type:"T",
   latitude:"52.65",
   longitude:"-129.4833"}
  ,
  {name:"Bassin De La Rivière St-Charles, Québec",
   type:"T",
   latitude:"46.8167",
   longitude:"-71.2"}
  ,
  {name:"Kudamatu, Yamaguti, Japan",
   type:"T",
   latitude:"34.0",
   longitude:"131.833"}
  ,
  {name:"Chicoutimi, Québec",
   type:"T",
   latitude:"48.4333",
   longitude:"-71.0833"}
  ,
  {name:"Vitória, Brazil",
   type:"T",
   latitude:"-20.3167",
   longitude:"-40.3167"}
  ,
  {name:"Grays Harbor Entrance, Washington Current",
   type:"C",
   latitude:"46.9167",
   longitude:"-124.125"}
  ,
  {name:"Yarmouth, Nova Scotia (2)",
   type:"T",
   latitude:"43.8333",
   longitude:"-66.1167"}
  ,
  {name:"Bonne Island, Nunavut",
   type:"T",
   latitude:"69.8",
   longitude:"-82.75"}
  ,
  {name:"Kozu Sima, Tokyo, Japan",
   type:"T",
   latitude:"34.2",
   longitude:"139.133"}
  ,
  {name:"Bella Coola, British Columbia (2)",
   type:"T",
   latitude:"52.3833",
   longitude:"-126.8"}
  ,
  {name:"Port O'Connor, Matagorda Bay, Texas",
   type:"T",
   latitude:"28.4517",
   longitude:"-96.3883"}
  ,
  {name:"Sanagi, Kagawa, Japan",
   type:"T",
   latitude:"34.3333",
   longitude:"133.633"}
  ,
  {name:"Meyers Narrows, British Columbia (2)",
   type:"T",
   latitude:"52.6",
   longitude:"-128.6167"}
  ,
  {name:"Ocean City (fishing pier), Maryland",
   type:"T",
   latitude:"38.3267",
   longitude:"-75.0833"}
  ,
  {name:"Montague Harbour, British Columbia",
   type:"T",
   latitude:"48.8833",
   longitude:"-123.3833"}
  ,
  {name:"Howick Island, Australia",
   type:"T",
   latitude:"-14.5167",
   longitude:"144.9833"}
  ,
  {name:"Lisbon, Portugal (2)",
   type:"T",
   latitude:"38.7",
   longitude:"-9.1333"}
  ,
  {name:"Kitimat, British Columbia",
   type:"T",
   latitude:"53.9833",
   longitude:"-128.7167"}
  ,
  {name:"Tumbo Channel, British Columbia",
   type:"T",
   latitude:"48.7833",
   longitude:"-123.1"}
  ,
  {name:"Ra's al Khafji, Saudi Arabia",
   type:"T",
   latitude:"28.4167",
   longitude:"48.5167"}
  ,
  {name:"St. Johns River at Dames Point (N. end, SR 9A bridge), Florida (2)",
   type:"T",
   latitude:"30.3869",
   longitude:"-81.5581"}
  ,
  {name:"Newport, Rhode Island",
   type:"T",
   latitude:"41.505",
   longitude:"-71.3267"}
  ,
  {name:"Ada, Okinawa, Japan",
   type:"T",
   latitude:"26.7333",
   longitude:"128.317"}
  ,
  {name:"Daliang, China",
   type:"T",
   latitude:"38.9167",
   longitude:"121.6333"}
  ,
  {name:"Asibe, Nagasaki, Japan",
   type:"T",
   latitude:"33.8167",
   longitude:"129.767"}
  ,
  {name:"Big River Cove, Tasmania",
   type:"T",
   latitude:"-40.2667",
   longitude:"148.1"}
  ,
  {name:"Minicoy Island, Lakshadweep",
   type:"T",
   latitude:"8.2833",
   longitude:"73.05"}
  ,
  {name:"Takahama, Nagasaki, Japan",
   type:"T",
   latitude:"34.25",
   longitude:"129.317"}
  ,
  {name:"Seward, Resurrection Bay, Alaska",
   type:"T",
   latitude:"60.12",
   longitude:"-149.4267"}
  ,
  {name:"Toke Point, Willapa Bay, Washington",
   type:"T",
   latitude:"46.7083",
   longitude:"-123.965"}
  ,
  {name:"Ie Sima (Harima Nada), Hyogo, Japan",
   type:"T",
   latitude:"34.6833",
   longitude:"134.533"}
  ,
  {name:"Chezzetcook Inlet, Nova Scotia",
   type:"T",
   latitude:"44.7833",
   longitude:"-63.2333"}
  ,
  {name:"Isla Neny, Antarctica",
   type:"T",
   latitude:"-68.2",
   longitude:"-67.0"}
  ,
  {name:"Portland, Australia",
   type:"T",
   latitude:"-38.35",
   longitude:"141.6167"}
  ,
  {name:"Queen Charlotte, British Columbia (2)",
   type:"T",
   latitude:"53.25",
   longitude:"-132.0667"}
  ,
  {name:"Siglufjörður, Iceland",
   type:"T",
   latitude:"66.15",
   longitude:"-18.9"}
  ,
  {name:"Sitka, Alaska",
   type:"T",
   latitude:"57.0517",
   longitude:"-135.3417"}
  ,
  {name:"Ranger Inlet, British Columbia (2)",
   type:"T",
   latitude:"54.8333",
   longitude:"-130.1667"}
  ,
  {name:"St. Johns River at Dames Point (N. end, SR 9A bridge), Florida (3)",
   type:"T",
   latitude:"30.3869",
   longitude:"-81.5581"}
  ,
  {name:"Harrington Harbour, Québec",
   type:"T",
   latitude:"50.5",
   longitude:"-59.4833"}
  ,
  {name:"Clover Point, British Columbia",
   type:"T",
   latitude:"48.4",
   longitude:"-123.35"}
  ,
  {name:"Dionisio Point, British Columbia",
   type:"T",
   latitude:"49.0167",
   longitude:"-123.5667"}
  ,
  {name:"Bamfield, British Columbia",
   type:"T",
   latitude:"48.8333",
   longitude:"-125.1333"}
  ,
  {name:"La Libertad, Ecuador",
   type:"T",
   latitude:"-2.2167",
   longitude:"-80.9167"}
  ,
  {name:"St-Jean-D'orleans, Québec",
   type:"T",
   latitude:"46.9167",
   longitude:"-70.9"}
  ,
  {name:"Kandla, India",
   type:"T",
   latitude:"23.0",
   longitude:"70.2333"}
  ,
  {name:"Skagaströnd, Iceland",
   type:"T",
   latitude:"65.8166",
   longitude:"-20.3333"}
  ,
  {name:"Whaletown Bay, British Columbia",
   type:"T",
   latitude:"50.1",
   longitude:"-125.05"}
  ,
  {name:"Waveland, Mississipi Sound, Mississippi",
   type:"T",
   latitude:"30.325",
   longitude:"-89.325"}
  ,
  {name:"Bahía San Julian (Punta Pena), Argentina",
   type:"T",
   latitude:"-49.25",
   longitude:"-67.6667"}
  ,
  {name:"Beaufort, Beaufort River, South Carolina",
   type:"T",
   latitude:"32.4333",
   longitude:"-80.6667"}
  ,
  {name:"Radstock Bay, Nunavut",
   type:"T",
   latitude:"74.7167",
   longitude:"-91.0833"}
  ,
  {name:"Galveston (Pleasure Pier), Texas",
   type:"T",
   latitude:"29.2867",
   longitude:"-94.79"}
  ,
  {name:"St. Johns River at Dames Point (N. end, SR 9A bridge), Florida (4)",
   type:"T",
   latitude:"30.3869",
   longitude:"-81.5581"}
  ,
  {name:"Possession Island, Endeavour Strait",
   type:"T",
   latitude:"-10.7333",
   longitude:"142.4"}
  ,
  {name:"Anma Do, South Korea",
   type:"T",
   latitude:"35.35",
   longitude:"126.0167"}
  ,
  {name:"Gloucester Point, York River, Virginia",
   type:"T",
   latitude:"37.2467",
   longitude:"-76.5"}
  ,
  {name:"Daiiti Kaiho, Tiba, Japan",
   type:"T",
   latitude:"35.3167",
   longitude:"139.767"}
  ,
  {name:"Lower Hell Gate (Knubble Bay, Maine) Current",
   type:"C",
   latitude:"43.8767",
   longitude:"-69.73"}
  ,
  {name:"Bowen, Australia (2)",
   type:"T",
   latitude:"-20.0167",
   longitude:"148.25"}
  ,
  {name:"Deep Cove, British Columbia",
   type:"T",
   latitude:"49.3333",
   longitude:"-122.95"}
  ,
  {name:"Long Beach, Newfoundland",
   type:"T",
   latitude:"47.9833",
   longitude:"-53.8"}
  ,
  {name:"Port Angeles, Washington",
   type:"T",
   latitude:"48.1167",
   longitude:"-123.4333"}
  ,
  {name:"Gingerville Creek, Maryland",
   type:"T",
   latitude:"38.9583",
   longitude:"-76.555"}
  ,
  {name:"False Creek, British Columbia (2)",
   type:"T",
   latitude:"49.2667",
   longitude:"-123.1333"}
  ,
  {name:"Granby Bay, British Columbia",
   type:"T",
   latitude:"55.4167",
   longitude:"-129.8333"}
  ,
  {name:"Melbourne, Australia",
   type:"T",
   latitude:"-37.8667",
   longitude:"144.8667"}
  ,
  {name:"Victoria, Prince Edward Island",
   type:"T",
   latitude:"46.2167",
   longitude:"-63.05"}
  ,
  {name:"East Margaree Bridge, Nova Scotia",
   type:"T",
   latitude:"46.4",
   longitude:"-61.0833"}
  ,
  {name:"Maizuru (Higasi-Ko), Kyoto, Japan (2)",
   type:"T",
   latitude:"35.4833",
   longitude:"135.4"}
  ,
  {name:"Venezia, Italy (2)",
   type:"T",
   latitude:"45.4333",
   longitude:"12.3333"}
  ,
  {name:"Port Lincoln, Australia",
   type:"T",
   latitude:"-34.7167",
   longitude:"135.8667"}
  ,
  {name:"Sungai Kutei, Borneo, Indonesia",
   type:"T",
   latitude:"-0.7",
   longitude:"117.5"}
  ,
  {name:"Bushehr, Iran",
   type:"T",
   latitude:"28.9",
   longitude:"50.75"}
  ,
  {name:"Springdale, Newfoundland",
   type:"T",
   latitude:"49.4833",
   longitude:"-56.05"}
  ,
  {name:"Marion Reef, Coral Sea",
   type:"T",
   latitude:"-19.1",
   longitude:"152.4"}
  ,
  {name:"Faro-Olhão, Portugal",
   type:"T",
   latitude:"36.9667",
   longitude:"-7.8667"}
  ,
  {name:"Johnston Atoll, Pacific Ocean",
   type:"T",
   latitude:"16.7383",
   longitude:"-169.53"}
  ,
  {name:"Sweeper Cove, Adak Island, Alaska",
   type:"T",
   latitude:"51.8633",
   longitude:"-176.6317"}
  ,
  {name:"Botany Bay, Australia",
   type:"T",
   latitude:"-33.9833",
   longitude:"151.2167"}
  ,
  {name:"Fort-de-France, Martinique",
   type:"T",
   latitude:"14.5833",
   longitude:"-61.05"}
  ,
  {name:"Northumberland Sound, Nunavut",
   type:"T",
   latitude:"76.8667",
   longitude:"-96.7"}
  ,
  {name:"Nawiliwili, Hawaii",
   type:"T",
   latitude:"21.9567",
   longitude:"-159.36"}
  ,
  {name:"Yokohama Sin-Yamasita, Kanagawa, Japan",
   type:"T",
   latitude:"35.4333",
   longitude:"139.667"}
  ,
  {name:"Kacho To, South Korea",
   type:"T",
   latitude:"34.3",
   longitude:"126.05"}
  ,
  {name:"Ono Seto, Hirosima, Japan",
   type:"T",
   latitude:"34.2667",
   longitude:"132.267"}
  ,
  {name:"Charcot, Antarctica",
   type:"T",
   latitude:"-65.0667",
   longitude:"-64.0333"}
  ,
  {name:"Uzi-Yamada, Mie, Japan",
   type:"T",
   latitude:"34.5167",
   longitude:"136.75"}
  ,
  {name:"Tumbo Channel, British Columbia (2)",
   type:"T",
   latitude:"48.7833",
   longitude:"-123.1"}
  ,
  {name:"Active Pass, British Columbia Current",
   type:"C",
   latitude:"48.8667",
   longitude:"-123.3"}
  ,
  {name:"Naha Ko, Okinawa, Japan",
   type:"T",
   latitude:"26.2",
   longitude:"127.6667"}
  ,
  {name:"Clarks Point, Alaska",
   type:"T",
   latitude:"58.85",
   longitude:"-158.5333"}
  ,
  {name:"Bunker Island Wharf, Nova Scotia",
   type:"T",
   latitude:"43.8167",
   longitude:"-66.1333"}
  ,
  {name:"Cape Blomidon, Nova Scotia",
   type:"T",
   latitude:"45.2667",
   longitude:"-64.35"}
  ,
  {name:"Lacrosse Island, Australia",
   type:"T",
   latitude:"-14.75",
   longitude:"128.3333"}
  ,
  {name:"Charleston Harbor, off Fort Sumter, South Carolina Current (expired 1996-12-31)",
   type:"C",
   latitude:"32.7583",
   longitude:"-79.8683"}
  ,
  {name:"Davis River, British Columbia",
   type:"T",
   latitude:"55.7667",
   longitude:"-130.1667"}
  ,
  {name:"Wakeham Bay, Québec",
   type:"T",
   latitude:"61.6",
   longitude:"-72.25"}
  ,
  {name:"Mokuoloe, Kaneohe Bay, Oahu Island, Hawaii",
   type:"T",
   latitude:"21.4367",
   longitude:"-157.7933"}
  ,
  {name:"Ra's Gharib, Egypt",
   type:"T",
   latitude:"28.35",
   longitude:"33.1"}
  ,
  {name:"Cape Dalhousie, Nunavut/NWT",
   type:"T",
   latitude:"70.2667",
   longitude:"-129.65"}
  ,
  {name:"Milne Island, British Columbia",
   type:"T",
   latitude:"52.6167",
   longitude:"-128.7667"}
  ,
  {name:"Moyoro Wan, Hokkaido, Japan",
   type:"T",
   latitude:"45.4333",
   longitude:"148.85"}
  ,
  {name:"Magueyes Island, Caribbean Sea, Puerto Rico",
   type:"T",
   latitude:"17.9717",
   longitude:"-67.0467"}
  ,
  {name:"Shell Island (north end), Crystal Bay, Florida",
   type:"T",
   latitude:"28.9233",
   longitude:"-82.6917"}
  ,
  {name:"Kvichak Bay (off Naknek River entrance), Alaska Current",
   type:"C",
   latitude:"58.7033",
   longitude:"-157.25"}
  ,
  {name:"Otiisi, Hokkaido, Japan",
   type:"T",
   latitude:"43.1833",
   longitude:"145.517"}
  ,
  {name:"Pender Harbour, British Columbia (2)",
   type:"T",
   latitude:"49.6333",
   longitude:"-124.0333"}
  ,
  {name:"Nezugaseki, Yamagata, Japan",
   type:"T",
   latitude:"38.5667",
   longitude:"139.55"}
  ,
  {name:"Whaler Bay, British Columbia (2)",
   type:"T",
   latitude:"48.8833",
   longitude:"-123.0333"}
  ,
  {name:"Port Harvey, British Columbia",
   type:"T",
   latitude:"50.5667",
   longitude:"-126.2667"}
  ,
  {name:"Nicolet, Québec",
   type:"T",
   latitude:"46.2333",
   longitude:"-72.6167"}
  ,
  {name:"Tamajarush (Ifni), Morocco",
   type:"T",
   latitude:"29.55",
   longitude:"-10.0667"}
  ,
  {name:"Barrow Island, Australia",
   type:"T",
   latitude:"-20.7167",
   longitude:"115.4667"}
  ,
  {name:"Duchateau Island, Papua New Guinea",
   type:"T",
   latitude:"-11.2833",
   longitude:"152.3667"}
  ,
  {name:"Beachport, Australia",
   type:"T",
   latitude:"-37.5",
   longitude:"140.1833"}
  ,
  {name:"Simizu, Sizuoka, Japan",
   type:"T",
   latitude:"35.0167",
   longitude:"138.5"}
  ,
  {name:"Seldovia, Alaska",
   type:"T",
   latitude:"59.44",
   longitude:"-151.72"}
  ,
  {name:"Kusimoto, Wakayama, Japan (2)",
   type:"T",
   latitude:"33.4667",
   longitude:"135.7833"}
  ,
  {name:"Barrow in Furness, England",
   type:"T",
   latitude:"54.1",
   longitude:"-3.2"}
  ,
  {name:"Esasi (Hiyama), Hokkaido, Japan",
   type:"T",
   latitude:"41.8667",
   longitude:"140.1"}
  ,
  {name:"Scawfell Island, Australia",
   type:"T",
   latitude:"-20.8667",
   longitude:"149.6167"}
  ,
  {name:"E-No-Sima, Kanagawa, Japan",
   type:"T",
   latitude:"35.3",
   longitude:"139.483"}
  ,
  {name:"Satomura (Naka-No-Sima), Kagosima, Japan",
   type:"T",
   latitude:"29.8333",
   longitude:"129.85"}
  ,
  {name:"Clarenville, Newfoundland",
   type:"T",
   latitude:"48.1667",
   longitude:"-53.9667"}
  ,
  {name:"Takehara, Hirosima, Japan",
   type:"T",
   latitude:"34.3333",
   longitude:"132.967"}
  ,
  {name:"Woody Island, Newfoundland",
   type:"T",
   latitude:"47.7833",
   longitude:"-54.1667"}
  ,
  {name:"Mys Savushkina, Kurile Islands",
   type:"T",
   latitude:"50.75",
   longitude:"156.133"}
  ,
  {name:"Siriya, Aomori, Japan",
   type:"T",
   latitude:"41.4",
   longitude:"141.45"}
  ,
  {name:"Ardrossan, Australia",
   type:"T",
   latitude:"-34.4333",
   longitude:"137.9167"}
  ,
  {name:"Kingsley Creek, RR. bridge, Florida",
   type:"T",
   latitude:"30.6317",
   longitude:"-81.4767"}
  ,
  {name:"Kan-Onzi, Kagawa, Japan",
   type:"T",
   latitude:"34.1333",
   longitude:"133.633"}
  ,
  {name:"Julianehåb, Greenland",
   type:"T",
   latitude:"60.7167",
   longitude:"-46.0333"}
  ,
  {name:"Cherbourg, France",
   type:"T",
   latitude:"49.65",
   longitude:"-1.6167"}
  ,
  {name:"Tokchok To, South Korea",
   type:"T",
   latitude:"37.25",
   longitude:"126.15"}
  ,
  {name:"Julington Creek, Florida (2)",
   type:"T",
   latitude:"30.135",
   longitude:"-81.63"}
  ,
  {name:"Long Key Viaduct, Florida Current",
   type:"C",
   latitude:"24.8017",
   longitude:"-80.865"}
  ,
  {name:"Quicks Hole (middle), Massachusetts Current",
   type:"C",
   latitude:"41.4433",
   longitude:"-70.8483"}
  ,
  {name:"Reservation Bay, Washington",
   type:"T",
   latitude:"48.4167",
   longitude:"-122.6667"}
  ,
  {name:"Dildo Run, Tea Kettle Island, Newfoundland",
   type:"T",
   latitude:"49.4833",
   longitude:"-54.7333"}
  ,
  {name:"Waita, Hukuoka, Japan",
   type:"T",
   latitude:"33.9333",
   longitude:"130.733"}
  ,
  {name:"Baffin, Nunavut",
   type:"T",
   latitude:"69.9833",
   longitude:"-84.0333"}
  ,
  {name:"Parrsboro, Nova Scotia (over keel blocks)",
   type:"T",
   latitude:"45.3667",
   longitude:"-64.1167"}
  ,
  {name:"Ballina, Australia",
   type:"T",
   latitude:"-28.8667",
   longitude:"153.5833"}
  ,
  {name:"Tignish, Prince Edward Island",
   type:"T",
   latitude:"46.95",
   longitude:"-64.0"}
  ,
  {name:"Heard Island, Antarctica",
   type:"T",
   latitude:"-53.0167",
   longitude:"73.3833"}
  ,
  {name:"Santander, Spain",
   type:"T",
   latitude:"43.4667",
   longitude:"-3.7833"}
  ,
  {name:"Deer Island, Nunavut",
   type:"T",
   latitude:"63.6167",
   longitude:"-91.4833"}
  ,
  {name:"Westport, St. Mary Bay, Nova Scotia",
   type:"T",
   latitude:"44.2667",
   longitude:"-66.35"}
  ,
  {name:"Kobe, Hyogo, Japan (2)",
   type:"T",
   latitude:"34.6833",
   longitude:"135.2"}
  ,
  {name:"Herschel Island, Nunavut/NWT",
   type:"T",
   latitude:"69.5667",
   longitude:"-138.9167"}
  ,
  {name:"Seal Cove, Newfoundland",
   type:"T",
   latitude:"49.9333",
   longitude:"-56.3667"}
  ,
  {name:"Tuna Wan, Nagasaki, Japan",
   type:"T",
   latitude:"34.4167",
   longitude:"129.267"}
  ,
  {name:"Redwood Creek, C.M. No.8, San Francisco Bay, California",
   type:"T",
   latitude:"37.5333",
   longitude:"-122.1933"}
  ,
  {name:"Sinzyuku Wan (Zusi), Kanagawa, Japan",
   type:"T",
   latitude:"35.2833",
   longitude:"139.567"}
  ,
  {name:"Fort Conger, Discovery Harbour, Ellesmere Island, Nunavut",
   type:"T",
   latitude:"81.7333",
   longitude:"-64.7333"}
  ,
  {name:"Zanzibar, Tanzania",
   type:"T",
   latitude:"-6.1667",
   longitude:"39.1833"}
  ,
  {name:"Port Hacking, Australia",
   type:"T",
   latitude:"-34.0833",
   longitude:"151.15"}
  ,
  {name:"Margaree Breakwater, Nova Scotia",
   type:"T",
   latitude:"46.45",
   longitude:"-61.1167"}
  ,
  {name:"Ilot Cone, Cambodia",
   type:"T",
   latitude:"11.4167",
   longitude:"103.0"}
  ,
  {name:"Mys Etolina, Kurile Islands",
   type:"T",
   latitude:"45.8167",
   longitude:"149.95"}
  ,
  {name:"Heron Island, Australia",
   type:"T",
   latitude:"-23.45",
   longitude:"151.9167"}
  ,
  {name:"Port of Spain, Trinidad (2)",
   type:"T",
   latitude:"10.65",
   longitude:"-61.5167"}
  ,
  {name:"Île Haute, Nova Scotia",
   type:"T",
   latitude:"45.25",
   longitude:"-64.9667"}
  ,
  {name:"Puerto Montt, Chile",
   type:"T",
   latitude:"-41.4833",
   longitude:"-72.9667"}
  ,
  {name:"Miami Harbor Entrance, Florida Current (2)",
   type:"C",
   latitude:"25.765",
   longitude:"-80.1367"}
  ,
  {name:"Port Harmon, Newfoundland",
   type:"T",
   latitude:"48.5167",
   longitude:"-58.5333"}
  ,
  {name:"Larry's River, Nova Scotia",
   type:"T",
   latitude:"45.2167",
   longitude:"-61.3833"}
  ,
  {name:"Iwakuni, Yamaguti, Japan",
   type:"T",
   latitude:"34.1667",
   longitude:"132.25"}
  ,
  {name:"Mokp'o, South Korea",
   type:"T",
   latitude:"34.7833",
   longitude:"126.3833"}
  ,
  {name:"Cove Point, Maryland",
   type:"T",
   latitude:"38.385",
   longitude:"-76.3817"}
  ,
  {name:"Dadens, British Columbia",
   type:"T",
   latitude:"54.1833",
   longitude:"-132.9833"}
  ,
  {name:"La Paz, Baja California Sur, Mexico (3)",
   type:"T",
   latitude:"24.1617",
   longitude:"-110.345"}
  ,
  {name:"La Habana, Cuba",
   type:"T",
   latitude:"23.15",
   longitude:"-82.3333"}
  ,
  {name:"Pointe-au-Pere, Québec",
   type:"T",
   latitude:"48.5167",
   longitude:"-68.4667"}
  ,
  {name:"Julington Creek, Florida (4)",
   type:"T",
   latitude:"30.135",
   longitude:"-81.63"}
  ,
  {name:"Valparaiso, Chile",
   type:"T",
   latitude:"-33.0333",
   longitude:"-71.6333"}
  ,
  {name:"Ferndale, Strait of Georgia, Washington",
   type:"T",
   latitude:"48.8333",
   longitude:"-122.7167"}
  ,
  {name:"Kaneda Wan, Kanagawa, Japan",
   type:"T",
   latitude:"35.2",
   longitude:"139.683"}
  ,
  {name:"Port Blackney, British Columbia (2)",
   type:"T",
   latitude:"52.3167",
   longitude:"-128.35"}
  ,
  {name:"Chesapeake Bay Bridge-Tunnel, Virginia",
   type:"T",
   latitude:"36.9667",
   longitude:"-76.1133"}
  ,
  {name:"Sandakan, Malaysia",
   type:"T",
   latitude:"5.8333",
   longitude:"118.1167"}
  ,
  {name:"Anewa Bay, Solomon Islands",
   type:"T",
   latitude:"-6.1833",
   longitude:"155.55"}
  ,
  {name:"Nugent Sound, British Columbia",
   type:"T",
   latitude:"52.0833",
   longitude:"-127.25"}
  ,
  {name:"Off Chilmark Pond, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.3333",
   longitude:"-70.7167"}
  ,
  {name:"Brighton, Australia",
   type:"T",
   latitude:"-35.0333",
   longitude:"138.5167"}
  ,
  {name:"Sidney, British Columbia",
   type:"T",
   latitude:"48.65",
   longitude:"-123.4"}
  ,
  {name:"Sheerness, England",
   type:"T",
   latitude:"51.45",
   longitude:"0.75"}
  ,
  {name:"Tutu, Nagasaki, Japan",
   type:"T",
   latitude:"34.1167",
   longitude:"129.183"}
  ,
  {name:"Crab Island, Endeavour Strait",
   type:"T",
   latitude:"-10.9667",
   longitude:"142.1167"}
  ,
  {name:"La Paz, Baja California Sur, Mexico (2)",
   type:"T",
   latitude:"24.1617",
   longitude:"-110.345"}
  ,
  {name:"Kitkatla Islands, British Columbia (2)",
   type:"T",
   latitude:"53.8",
   longitude:"-130.35"}
  ,
  {name:"Okusiri, Hokkaido, Japan",
   type:"T",
   latitude:"42.1667",
   longitude:"139.517"}
  ,
  {name:"Shinminato, Japan",
   type:"T",
   latitude:"34.1833",
   longitude:"132.2333"}
  ,
  {name:"Ocean Beach, California",
   type:"T",
   latitude:"37.7667",
   longitude:"-122.5167"}
  ,
  {name:"Julington Creek, Florida (3)",
   type:"T",
   latitude:"30.135",
   longitude:"-81.63"}
  ,
  {name:"Berbera, Somalia",
   type:"T",
   latitude:"10.4333",
   longitude:"45.0167"}
  ,
  {name:"Nohezi, Aomori, Japan",
   type:"T",
   latitude:"40.8667",
   longitude:"141.117"}
  ,
  {name:"Coal Harbour, British Columbia",
   type:"T",
   latitude:"50.6",
   longitude:"-127.5833"}
  ,
  {name:"Cap Aux Oies, Québec",
   type:"T",
   latitude:"47.4833",
   longitude:"-70.2333"}
  ,
  {name:"Pusan, South Korea",
   type:"T",
   latitude:"35.1",
   longitude:"129.0333"}
  ,
  {name:"Belfast, Northern Ireland (2)",
   type:"T",
   latitude:"54.6",
   longitude:"-5.9167"}
  ,
  {name:"Igloolik, Nunavut",
   type:"T",
   latitude:"69.3667",
   longitude:"-81.7667"}
  ,
  {name:"Gazya Sima, Kagosima, Japan",
   type:"T",
   latitude:"29.9",
   longitude:"129.55"}
  ,
  {name:"Booby Island, Torres Strait",
   type:"T",
   latitude:"-10.6",
   longitude:"141.9167"}
  ,
  {name:"Bissau, Guinea-Bissau",
   type:"T",
   latitude:"11.8667",
   longitude:"-15.5833"}
  ,
  {name:"Godhavn, Disko Island, Greenland",
   type:"T",
   latitude:"69.25",
   longitude:"-53.55"}
  ,
  {name:"O Sima (Saeki Wan), Oita, Japan",
   type:"T",
   latitude:"32.9667",
   longitude:"132.067"}
  ,
  {name:"Vila do Porto, Santa Maria, Azores",
   type:"T",
   latitude:"36.95",
   longitude:"-25.15"}
  ,
  {name:"Cairncross Island, Australia",
   type:"T",
   latitude:"-11.25",
   longitude:"142.9167"}
  ,
  {name:"Ondo Seto, Hirosima, Japan",
   type:"T",
   latitude:"34.2",
   longitude:"132.533"}
  ,
  {name:"Creech Reef, Australia",
   type:"T",
   latitude:"-13.6333",
   longitude:"144.0833"}
  ,
  {name:"Shoal Bay, British Columbia (2)",
   type:"T",
   latitude:"50.4667",
   longitude:"-125.3667"}
  ,
  {name:"Sin-Mikuriya, Nagasaki, Japan",
   type:"T",
   latitude:"33.3667",
   longitude:"129.667"}
  ,
  {name:"Yobuko, Saga, Japan",
   type:"T",
   latitude:"33.55",
   longitude:"129.883"}
  ,
  {name:"Zhanjiang, China",
   type:"T",
   latitude:"21.1667",
   longitude:"110.4167"}
  ,
  {name:"St. Johns River Entrance, Florida Current",
   type:"C",
   latitude:"30.4",
   longitude:"-81.3833"}
  ,
  {name:"Foulke Fiord, Nunavut",
   type:"T",
   latitude:"78.3",
   longitude:"-72.6333"}
  ,
  {name:"Anderson Island Hudson, Québec",
   type:"T",
   latitude:"56.0333",
   longitude:"-76.0667"}
  ,
  {name:"Ezaki, Hyogo, Japan",
   type:"T",
   latitude:"34.6",
   longitude:"134.983"}
  ,
  {name:"Lower East Pubnico, Nova Scotia",
   type:"T",
   latitude:"43.6333",
   longitude:"-65.7667"}
  ,
  {name:"Miami Harbor Entrance, Florida Current (3)",
   type:"C",
   latitude:"25.765",
   longitude:"-80.1367"}
  ,
  {name:"Port Keats, Australia",
   type:"T",
   latitude:"-14.05",
   longitude:"129.5667"}
  ,
  {name:"Gosling Island, British Columbia",
   type:"T",
   latitude:"51.9",
   longitude:"-128.4333"}
  ,
  {name:"Bell Cay, Australia",
   type:"T",
   latitude:"-21.8167",
   longitude:"151.25"}
  ,
  {name:"Akabane, Aichi, Japan",
   type:"T",
   latitude:"34.6",
   longitude:"137.2"}
  ,
  {name:"Cape Alava, Washington (2)",
   type:"T",
   latitude:"48.1667",
   longitude:"-124.7333"}
  ,
  {name:"Natkusiak Peninsula, Nunavut",
   type:"T",
   latitude:"73.0167",
   longitude:"-110.4667"}
  ,
  {name:"Prim Point, Prince Edward Island",
   type:"T",
   latitude:"46.05",
   longitude:"-63.0333"}
  ,
  {name:"Dumbarton Bridge, San Francisco Bay, California",
   type:"T",
   latitude:"37.5067",
   longitude:"-122.115"}
  ,
  {name:"Chandbali, India",
   type:"T",
   latitude:"20.7833",
   longitude:"86.9667"}
  ,
  {name:"Apollo Bay, Australia",
   type:"T",
   latitude:"-38.75",
   longitude:"143.6667"}
  ,
  {name:"Blackett Strait, Solomon Islands",
   type:"T",
   latitude:"-8.1333",
   longitude:"157.1333"}
  ,
  {name:"Humpback Bay, British Columbia (2)",
   type:"T",
   latitude:"54.0833",
   longitude:"-130.4"}
  ,
  {name:"Herring Cove, New Brunswick",
   type:"T",
   latitude:"45.5667",
   longitude:"-64.9667"}
  ,
  {name:"Bamfield, British Columbia (2)",
   type:"T",
   latitude:"48.8333",
   longitude:"-125.1333"}
  ,
  {name:"Trail Bay, British Columbia",
   type:"T",
   latitude:"54.5833",
   longitude:"-130.35"}
  ,
  {name:"Port Maitland, Nova Scotia",
   type:"T",
   latitude:"43.9833",
   longitude:"-66.15"}
  ,
  {name:"Barrow Island, Australia (2)",
   type:"T",
   latitude:"-20.7167",
   longitude:"115.4667"}
  ,
  {name:"Brevoort Harbour, Nunavut",
   type:"T",
   latitude:"63.3167",
   longitude:"-64.15"}
  ,
  {name:"Koiseboi, Hokkaido, Japan",
   type:"T",
   latitude:"44.05",
   longitude:"144.95"}
  ,
  {name:"Sibayama, Hyogo, Japan",
   type:"T",
   latitude:"35.65",
   longitude:"134.667"}
  ,
  {name:"Spring Bay, Tasmania",
   type:"T",
   latitude:"-42.55",
   longitude:"147.9333"}
  ,
  {name:"Learmonth, Australia (2)",
   type:"T",
   latitude:"-22.1833",
   longitude:"114.0833"}
  ,
  {name:"George Washington Bridge, Hudson River, New York",
   type:"T",
   latitude:"40.85",
   longitude:"-73.95"}
  ,
  {name:"St. Patrick Bay, Nunavut",
   type:"T",
   latitude:"81.8",
   longitude:"-64.0167"}
  ,
  {name:"Liverpool, Nova Scotia",
   type:"T",
   latitude:"44.05",
   longitude:"-64.7167"}
  ,
  {name:"Chatham (outer coast), Cape Cod, Massachusetts",
   type:"T",
   latitude:"41.6667",
   longitude:"-69.9333"}
  ,
  {name:"Bodomari, Kagosima, Japan",
   type:"T",
   latitude:"31.2833",
   longitude:"130.217"}
  ,
  {name:"Mooloolaba, Australia",
   type:"T",
   latitude:"-26.6833",
   longitude:"153.1167"}
  ,
  {name:"Porlier Pass, British Columbia Current",
   type:"C",
   latitude:"49.015",
   longitude:"-123.585"}
  ,
  {name:"Puerto de Bahía Caraquez, Ecuador",
   type:"T",
   latitude:"-0.5833",
   longitude:"-80.4333"}
  ,
  {name:"Great Glennie Island, Australia",
   type:"T",
   latitude:"-39.0833",
   longitude:"146.2333"}
  ,
  {name:"Anesaki, Tiba, Japan",
   type:"T",
   latitude:"35.4833",
   longitude:"140.033"}
  ,
  {name:"Sandfly Passage, Solomon Islands",
   type:"T",
   latitude:"-9.0",
   longitude:"160.1167"}
  ,
  {name:"Eddystone Point, Tasmania",
   type:"T",
   latitude:"-41.0",
   longitude:"148.35"}
  ,
  {name:"Peel Point, Nunavut",
   type:"T",
   latitude:"73.2667",
   longitude:"-115.1833"}
  ,
  {name:"Revillon Wharf, Ontario",
   type:"T",
   latitude:"51.2833",
   longitude:"-80.6167"}
  ,
  {name:"Stewart, British Columbia",
   type:"T",
   latitude:"55.9167",
   longitude:"-130.0"}
  ,
  {name:"Tosadomari, Tokusima, Japan",
   type:"T",
   latitude:"34.1833",
   longitude:"134.633"}
  ,
  {name:"Hilo, Hilo Bay, Hawaii (2)",
   type:"T",
   latitude:"19.7333",
   longitude:"-155.0667"}
  ,
  {name:"Hampton Roads, Virginia (2) (expired 1989-12-31)",
   type:"T",
   latitude:"36.9467",
   longitude:"-76.33"}
  ,
  {name:"San Mateo Bridge, South San Francisco Bay, California Current",
   type:"C",
   latitude:"37.5867",
   longitude:"-122.2533"}
  ,
  {name:"North Rustico, Prince Edward Island",
   type:"T",
   latitude:"46.4667",
   longitude:"-63.2833"}
  ,
  {name:"Gove Harbour, Australia",
   type:"T",
   latitude:"-12.2167",
   longitude:"136.6667"}
  ,
  {name:"New Castle, Chesapeake and Delaware Canal, Delaware",
   type:"T",
   latitude:"39.6567",
   longitude:"-75.5617"}
  ,
  {name:"Treadwell Bay, British Columbia (2)",
   type:"T",
   latitude:"51.1",
   longitude:"-127.5333"}
  ,
  {name:"Kusikino, Kagosima, Japan",
   type:"T",
   latitude:"31.7167",
   longitude:"130.267"}
  ,
  {name:"Port Townsend, Washington (2) (expired 1991-12-31)",
   type:"T",
   latitude:"48.1117",
   longitude:"-122.7583"}
  ,
  {name:"Strutton Island, Nunavut",
   type:"T",
   latitude:"52.0333",
   longitude:"-78.8667"}
  ,
  {name:"Montevideo, Uruguay",
   type:"T",
   latitude:"-34.9167",
   longitude:"-56.2167"}
  ,
  {name:"Port Martin, Antarctica (2)",
   type:"T",
   latitude:"-66.8333",
   longitude:"141.4167"}
  ,
  {name:"St. Bees Island, Australia",
   type:"T",
   latitude:"-20.9",
   longitude:"149.45"}
  ,
  {name:"Pennefather River, Australia",
   type:"T",
   latitude:"-12.2167",
   longitude:"141.7833"}
  ,
  {name:"Split, Croatia",
   type:"T",
   latitude:"43.5",
   longitude:"16.4333"}
  ,
  {name:"Astoria (Tongue Point), Oregon (2) (expired 1985-12-31)",
   type:"T",
   latitude:"46.2083",
   longitude:"-123.7667"}
  ,
  {name:"Kobe, Hyogo, Japan",
   type:"T",
   latitude:"34.6833",
   longitude:"135.2"}
  ,
  {name:"Normanby River, Australia",
   type:"T",
   latitude:"-14.4167",
   longitude:"144.15"}
  ,
  {name:"Teradomari, Niigata, Japan",
   type:"T",
   latitude:"37.6333",
   longitude:"138.767"}
  ,
  {name:"Hakata Hukuoka, Hukuoka, Japan",
   type:"T",
   latitude:"33.6",
   longitude:"130.383"}
  ,
  {name:"Karwar, India",
   type:"T",
   latitude:"14.8",
   longitude:"74.1"}
  ,
  {name:"Cobequid Bay (Ray .4), Nova Scotia",
   type:"T",
   latitude:"45.3667",
   longitude:"-63.7333"}
  ,
  {name:"The Folly, Hilton Head Island, South Carolina",
   type:"T",
   latitude:"32.1833",
   longitude:"-80.7"}
  ,
  {name:"Tokasiki, Okinawa, Japan",
   type:"T",
   latitude:"26.2",
   longitude:"127.367"}
  ,
  {name:"Milne Island, British Columbia (2)",
   type:"T",
   latitude:"52.6167",
   longitude:"-128.7667"}
  ,
  {name:"Higasi-Harima, Hutami-Hyogo, Japan",
   type:"T",
   latitude:"34.7",
   longitude:"134.9"}
  ,
  {name:"Point Murat, Australia (2)",
   type:"T",
   latitude:"-21.8167",
   longitude:"114.1833"}
  ,
  {name:"Georgina Point, British Columbia",
   type:"T",
   latitude:"48.8667",
   longitude:"-123.2833"}
  ,
  {name:"Haulover Pier, North Miami Beach, Florida",
   type:"T",
   latitude:"25.9033",
   longitude:"-80.12"}
  ,
  {name:"Kelley's Cove, Nova Scotia",
   type:"T",
   latitude:"43.7833",
   longitude:"-66.1333"}
  ,
  {name:"St-Francois, Québec",
   type:"T",
   latitude:"47.0",
   longitude:"-70.8167"}
  ,
  {name:"Garden Key, Dry Tortugas, Florida",
   type:"T",
   latitude:"24.6267",
   longitude:"-82.8717"}
  ,
  {name:"Squibnocket Point, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.3117",
   longitude:"-70.7683"}
  ,
  {name:"Long Island, New Brunswick",
   type:"T",
   latitude:"45.15",
   longitude:"-66.9667"}
  ,
  {name:"Restoration Island, Australia",
   type:"T",
   latitude:"-12.6167",
   longitude:"143.4667"}
  ,
  {name:"Lady Elliot Island, Australia",
   type:"T",
   latitude:"-24.1167",
   longitude:"152.7167"}
  ,
  {name:"Tanokubi, Yamaguti, Japan",
   type:"T",
   latitude:"33.9167",
   longitude:"130.917"}
  ,
  {name:"Cowaramup, Australia",
   type:"T",
   latitude:"-33.8667",
   longitude:"114.9833"}
  ,
  {name:"Sansum Narrows, British Columbia Current",
   type:"C",
   latitude:"48.7833",
   longitude:"-123.55"}
  ,
  {name:"Solide Passage, British Columbia",
   type:"T",
   latitude:"54.1833",
   longitude:"-132.9833"}
  ,
  {name:"Cape Enrage, Nova Scotia",
   type:"T",
   latitude:"45.6",
   longitude:"-64.7833"}
  ,
  {name:"Utiumi, Miyazaki, Japan",
   type:"T",
   latitude:"31.75",
   longitude:"131.467"}
  ,
  {name:"Toguti, Okinawa, Japan",
   type:"T",
   latitude:"26.65",
   longitude:"127.9"}
  ,
  {name:"Esquimalt, British Columbia",
   type:"T",
   latitude:"48.4333",
   longitude:"-123.4167"}
  ,
  {name:"Matane, Québec",
   type:"T",
   latitude:"48.85",
   longitude:"-67.5333"}
  ,
  {name:"Belawan, Sumatra, Indonesia",
   type:"T",
   latitude:"3.8333",
   longitude:"98.7167"}
  ,
  {name:"Ortega River Entrance, Florida",
   type:"T",
   latitude:"30.2783",
   longitude:"-81.705"}
  ,
  {name:"Fredericton, New Brunswick",
   type:"T",
   latitude:"45.9667",
   longitude:"-66.65"}
  ,
  {name:"Rio de Janeiro, Brazil (2)",
   type:"T",
   latitude:"-22.8833",
   longitude:"-43.1667"}
  ,
  {name:"Forster, Australia",
   type:"T",
   latitude:"-32.1833",
   longitude:"152.5"}
  ,
  {name:"Hunamawari Wan, Nagasaki, Japan",
   type:"T",
   latitude:"32.8667",
   longitude:"128.933"}
  ,
  {name:"Guluwuru Island, Australia",
   type:"T",
   latitude:"-11.5167",
   longitude:"136.3833"}
  ,
  {name:"Konominato, Hukuoka, Japan",
   type:"T",
   latitude:"33.85",
   longitude:"130.483"}
  ,
  {name:"Low Islets, Australia",
   type:"T",
   latitude:"-16.3833",
   longitude:"145.5667"}
  ,
  {name:"Susaki (Aiti), Aichi, Japan",
   type:"T",
   latitude:"34.7833",
   longitude:"137.167"}
  ,
  {name:"Hamilton Bank, Labrador",
   type:"T",
   latitude:"55.35",
   longitude:"-53.7667"}
  ,
  {name:"St-Jean-Port-Joli, Québec",
   type:"T",
   latitude:"47.2167",
   longitude:"-70.2667"}
  ,
  {name:"Sora, Ishikawa, Japan",
   type:"T",
   latitude:"37.1833",
   longitude:"137.017"}
  ,
  {name:"Berkeley Yacht Harbor, California Current",
   type:"C",
   latitude:"37.8522",
   longitude:"-122.3112"}
  ,
  {name:"Eastport, Maine (3)",
   type:"T",
   latitude:"44.9",
   longitude:"-66.9833"}
  ,
  {name:"Maple Bay, British Columbia",
   type:"T",
   latitude:"48.8167",
   longitude:"-123.6167"}
  ,
  {name:"Butedale, British Columbia",
   type:"T",
   latitude:"53.1667",
   longitude:"-128.7"}
  ,
  {name:"Mont-Louis, Québec",
   type:"T",
   latitude:"49.2333",
   longitude:"-65.7333"}
  ,
  {name:"St. Johns River Entrance, Florida Current (3)",
   type:"C",
   latitude:"30.7967",
   longitude:"-81.515"}
  ,
  {name:"Cape Lupton, Greenland",
   type:"T",
   latitude:"81.0667",
   longitude:"-61.0833"}
  ,
  {name:"Shadwan, Egypt",
   type:"T",
   latitude:"27.45",
   longitude:"34.0333"}
  ,
  {name:"Sop's Island, White Bay, Newfoundland",
   type:"T",
   latitude:"49.8333",
   longitude:"-56.7667"}
  ,
  {name:"Myrtle Beach (Springmaid Pier), South Carolina",
   type:"T",
   latitude:"33.655",
   longitude:"-78.9183"}
  ,
  {name:"Kuzi (Iwate), Iwate, Japan",
   type:"T",
   latitude:"40.1833",
   longitude:"141.817"}
  ,
  {name:"Shediac Bay, New Brunswick (2)",
   type:"T",
   latitude:"46.25",
   longitude:"-64.5333"}
  ,
  {name:"Resor Island, Nunavut",
   type:"T",
   latitude:"63.2167",
   longitude:"-68.05"}
  ,
  {name:"St. Bride's, Newfoundland",
   type:"T",
   latitude:"46.9167",
   longitude:"-54.1833"}
  ,
  {name:"Wilson's Beach, Campobello Island, New Brunswick",
   type:"T",
   latitude:"44.9333",
   longitude:"-66.9333"}
  ,
  {name:"Hatfield Point, New Brunswick",
   type:"T",
   latitude:"45.65",
   longitude:"-65.8667"}
  ,
  {name:"Santa Rosalia, Baja California Sur, Mexico",
   type:"T",
   latitude:"27.3167",
   longitude:"-112.25"}
  ,
  {name:"Île Verte, Québec",
   type:"T",
   latitude:"48.05",
   longitude:"-69.4167"}
  ,
  {name:"Inaba-Aziro, Tottori, Japan",
   type:"T",
   latitude:"35.5833",
   longitude:"134.3"}
  ,
  {name:"Stag Island, Nunavut",
   type:"T",
   latitude:"51.6333",
   longitude:"-79.0333"}
  ,
  {name:"Oyster Point Marina, San Francisco Bay, California (2)",
   type:"T",
   latitude:"37.6667",
   longitude:"-122.3833"}
  ,
  {name:"East Cape, Papua New Guinea",
   type:"T",
   latitude:"-10.2333",
   longitude:"150.8833"}
  ,
  {name:"Naga Ura, Kanagawa, Japan",
   type:"T",
   latitude:"35.3167",
   longitude:"139.65"}
  ,
  {name:"Wick, Scotland",
   type:"T",
   latitude:"58.4333",
   longitude:"-3.0833"}
  ,
  {name:"Saint Pierre et Miquelon",
   type:"T",
   latitude:"46.8167",
   longitude:"-56.1833"}
  ,
  {name:"Little Inagua Island, Bahamas",
   type:"T",
   latitude:"21.45",
   longitude:"-73.0167"}
  ,
  {name:"Richmond, Chevron Oil Pier, California",
   type:"T",
   latitude:"37.9283",
   longitude:"-122.4"}
  ,
  {name:"Samarai Island, Papua New Guinea",
   type:"T",
   latitude:"-10.6167",
   longitude:"150.6667"}
  ,
  {name:"Avonmouth (Port of Bristol), England (2)",
   type:"T",
   latitude:"51.5",
   longitude:"-2.7167"}
  ,
  {name:"Cabo San Pablo, Argentina",
   type:"T",
   latitude:"-54.2833",
   longitude:"-66.7"}
  ,
  {name:"Muscat, Oman",
   type:"T",
   latitude:"23.6167",
   longitude:"58.6"}
  ,
  {name:"Port Said, Egypt",
   type:"T",
   latitude:"31.2667",
   longitude:"32.3167"}
  ,
  {name:"Adelaide Outer Harbour, Australia",
   type:"T",
   latitude:"-34.7833",
   longitude:"138.4833"}
  ,
  {name:"Off Jobs Neck Pond, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.35",
   longitude:"-70.5833"}
  ,
  {name:"Tryon Islet, Australia",
   type:"T",
   latitude:"-23.25",
   longitude:"151.7833"}
  ,
  {name:"Hunauki, Okinawa, Japan",
   type:"T",
   latitude:"24.3333",
   longitude:"123.733"}
  ,
  {name:"La Unión, El Salvador (2)",
   type:"T",
   latitude:"13.3333",
   longitude:"-87.8167"}
  ,
  {name:"Shell Point, Florida (2) (expired 1989-08-09)",
   type:"T",
   latitude:"30.06",
   longitude:"-84.29"}
  ,
  {name:"Eastern Point Harbor, Frenchman Bay, Maine",
   type:"T",
   latitude:"44.4667",
   longitude:"-68.1667"}
  ,
  {name:"Chemanius, British Columbia",
   type:"T",
   latitude:"48.9167",
   longitude:"-123.7"}
  ,
  {name:"Puerto Madryn, Argentina",
   type:"T",
   latitude:"-42.7667",
   longitude:"-65.0333"}
  ,
  {name:"Digby, Annapolis Basin, Nova Scotia",
   type:"T",
   latitude:"44.6333",
   longitude:"-65.75"}
  ,
  {name:"Mason Creek, Homosassa Bay, Florida",
   type:"T",
   latitude:"28.7617",
   longitude:"-82.6383"}
  ,
  {name:"The Narrows, Midchannel, New York Harbor, New York Current (2)",
   type:"C",
   latitude:"40.61",
   longitude:"-74.0467"}
  ,
  {name:"Banyuls, France",
   type:"T",
   latitude:"42.4833",
   longitude:"3.1"}
  ,
  {name:"Sirasima, Hukuoka, Japan",
   type:"T",
   latitude:"34.0167",
   longitude:"130.733"}
  ,
  {name:"Indian River Inlet (USCG Station), Delaware",
   type:"T",
   latitude:"38.61",
   longitude:"-75.07"}
  ,
  {name:"McPherson Point, British Columbia",
   type:"T",
   latitude:"54.2333",
   longitude:"-132.9667"}
  ,
  {name:"Swartz Bay, British Columbia",
   type:"T",
   latitude:"48.6833",
   longitude:"-123.4"}
  ,
  {name:"Aberdeen, Washington",
   type:"T",
   latitude:"46.9667",
   longitude:"-123.8533"}
  ,
  {name:"Little Bay Arm, Newfoundland",
   type:"T",
   latitude:"49.6",
   longitude:"-55.9167"}
  ,
  {name:"Awa Sima (Niigata), Niigata, Japan",
   type:"T",
   latitude:"38.4667",
   longitude:"139.25"}
  ,
  {name:"Porpoise Bay, British Columbia",
   type:"T",
   latitude:"49.4833",
   longitude:"-123.75"}
  ,
  {name:"Vlissingen, Netherlands",
   type:"T",
   latitude:"51.45",
   longitude:"3.6"}
  ,
  {name:"Bedford Island, Australia",
   type:"T",
   latitude:"-16.15",
   longitude:"123.3167"}
  ,
  {name:"Millerand, Nova Scotia",
   type:"T",
   latitude:"47.2134",
   longitude:"-61.987"}
  ,
  {name:"St-Romuald, Québec",
   type:"T",
   latitude:"46.7667",
   longitude:"-71.2333"}
  ,
  {name:"Annapolis, Maryland",
   type:"T",
   latitude:"38.985",
   longitude:"-76.4867"}
  ,
  {name:"Norton Island, Nunavut",
   type:"T",
   latitude:"64.0",
   longitude:"-94.2167"}
  ,
  {name:"West Newdy Quoddy, Nova Scotia",
   type:"T",
   latitude:"44.9",
   longitude:"-62.3167"}
  ,
  {name:"The Bight, Cat Island, Bahamas",
   type:"T",
   latitude:"24.3167",
   longitude:"-75.4333"}
  ,
  {name:"Moffatt Islands, British Columbia (2)",
   type:"T",
   latitude:"54.45",
   longitude:"-130.7333"}
  ,
  {name:"Cribbons Point, Nova Scotia",
   type:"T",
   latitude:"45.75",
   longitude:"-61.9"}
  ,
  {name:"Tampa Bay Entrance, Florida Current",
   type:"C",
   latitude:"27.6083",
   longitude:"-82.7683"}
  ,
  {name:"Carlisle Island, Australia",
   type:"T",
   latitude:"-20.7833",
   longitude:"149.3"}
  ,
  {name:"Tauranga, New Zealand",
   type:"T",
   latitude:"-37.65",
   longitude:"176.1833"}
  ,
  {name:"Night Island, Australia",
   type:"T",
   latitude:"-13.1833",
   longitude:"143.5667"}
  ,
  {name:"Sable Island, Nova Scotia",
   type:"T",
   latitude:"43.9667",
   longitude:"-59.8"}
  ,
  {name:"Iozima (Kagosima), Kagosima, Japan",
   type:"T",
   latitude:"30.7833",
   longitude:"130.283"}
  ,
  {name:"Newport Bay Entrance, Corona del Mar, California",
   type:"T",
   latitude:"33.6033",
   longitude:"-117.8833"}
  ,
  {name:"Padre Island (South), Texas",
   type:"T",
   latitude:"26.0683",
   longitude:"-97.1567"}
  ,
  {name:"Davis, Antarctica",
   type:"T",
   latitude:"-68.0",
   longitude:"78.5"}
  ,
  {name:"East Diamond It., Coral Sea",
   type:"T",
   latitude:"-17.4333",
   longitude:"151.0667"}
  ,
  {name:"Kanbe, Nagasaki, Japan",
   type:"T",
   latitude:"32.8667",
   longitude:"129.033"}
  ,
  {name:"Sevilla, Spain",
   type:"T",
   latitude:"37.3833",
   longitude:"-6.0"}
  ,
  {name:"Pictou, Nova Scotia (2)",
   type:"T",
   latitude:"45.6833",
   longitude:"-62.7"}
  ,
  {name:"Marugame, Kagawa, Japan",
   type:"T",
   latitude:"34.3",
   longitude:"133.8"}
  ,
  {name:"Woodlark Island, Papua New Guinea",
   type:"T",
   latitude:"-9.25",
   longitude:"152.9667"}
  ,
  {name:"St-Simeon, Québec",
   type:"T",
   latitude:"47.8333",
   longitude:"-69.8833"}
  ,
  {name:"South Beach, Yaquina Bay, Oregon",
   type:"T",
   latitude:"44.625",
   longitude:"-124.0433"}
  ,
  {name:"Cádiz, Spain",
   type:"T",
   latitude:"36.5333",
   longitude:"-6.2833"}
  ,
  {name:"Kuroko Sima, Nagasaki, Japan",
   type:"T",
   latitude:"33.3833",
   longitude:"129.567"}
  ,
  {name:"Point Atkinson, British Columbia (2)",
   type:"T",
   latitude:"49.0333",
   longitude:"-123.25"}
  ,
  {name:"Humpback Bay, British Columbia",
   type:"T",
   latitude:"54.0833",
   longitude:"-130.4"}
  ,
  {name:"Kutugata, Hokkaido, Japan",
   type:"T",
   latitude:"45.1833",
   longitude:"141.133"}
  ,
  {name:"Alice Arm, British Columbia (2)",
   type:"T",
   latitude:"55.4667",
   longitude:"-129.5"}
  ,
  {name:"Sunwi Do, North Korea",
   type:"T",
   latitude:"37.75",
   longitude:"125.3333"}
  ,
  {name:"Lower Wedgeport, Nova Scotia",
   type:"T",
   latitude:"43.7167",
   longitude:"-65.9833"}
  ,
  {name:"Pondalowie Bay, Australia",
   type:"T",
   latitude:"-35.25",
   longitude:"136.8167"}
  ,
  {name:"Port Kembla, Australia (2)",
   type:"T",
   latitude:"-34.4833",
   longitude:"150.9167"}
  ,
  {name:"Shell Point, Florida",
   type:"T",
   latitude:"30.06",
   longitude:"-84.29"}
  ,
  {name:"Whaletown Bay, British Columbia (2)",
   type:"T",
   latitude:"50.1",
   longitude:"-125.05"}
  ,
  {name:"Cartagena, Colombia",
   type:"T",
   latitude:"10.3833",
   longitude:"-75.5333"}
  ,
  {name:"Halls River Bridge, Halls River, Florida",
   type:"T",
   latitude:"28.8",
   longitude:"-82.6033"}
  ,
  {name:"Aoki, Kagawa, Japan",
   type:"T",
   latitude:"34.3667",
   longitude:"133.683"}
  ,
  {name:"Pirates Bay, Tasmania",
   type:"T",
   latitude:"-43.0333",
   longitude:"147.9667"}
  ,
  {name:"Whyalla, Australia (2)",
   type:"T",
   latitude:"-33.0167",
   longitude:"137.5667"}
  ,
  {name:"New Bedford, Buzzards Bay, Massachusetts",
   type:"T",
   latitude:"41.5967",
   longitude:"-70.9"}
  ,
  {name:"Old Harry, Nova Scotia",
   type:"T",
   latitude:"47.5667",
   longitude:"-61.4667"}
  ,
  {name:"Cheju, Cheju Do, South Korea",
   type:"T",
   latitude:"33.5167",
   longitude:"126.5333"}
  ,
  {name:"Egmont, British Columbia (2)",
   type:"T",
   latitude:"49.75",
   longitude:"-123.9333"}
  ,
  {name:"San Román, Argentina",
   type:"T",
   latitude:"-42.25",
   longitude:"-64.2333"}
  ,
  {name:"Greenly Island, Australia",
   type:"T",
   latitude:"-34.65",
   longitude:"134.7833"}
  ,
  {name:"Marmagao, India",
   type:"T",
   latitude:"15.4167",
   longitude:"73.8"}
  ,
  {name:"Tai-No-Ura, Nagasaki, Japan",
   type:"T",
   latitude:"32.95",
   longitude:"129.1"}
  ,
  {name:"Kasiwabara, Hukuoka, Japan",
   type:"T",
   latitude:"33.9",
   longitude:"130.667"}
  ,
  {name:"Strait of Juan de Fuca Entrance, Washington Current",
   type:"C",
   latitude:"48.45",
   longitude:"-124.5833"}
  ,
  {name:"Port Chicago, Suisun Bay, California",
   type:"T",
   latitude:"38.0567",
   longitude:"-122.0383"}
  ,
  {name:"Stony Point, Australia",
   type:"T",
   latitude:"-38.3667",
   longitude:"145.2167"}
  ,
  {name:"Hantsport, Nova Scotia",
   type:"T",
   latitude:"45.0667",
   longitude:"-64.1667"}
  ,
  {name:"Kanoya, Kagosima, Japan",
   type:"T",
   latitude:"31.4",
   longitude:"130.767"}
  ,
  {name:"Gros Cacouna, Québec",
   type:"T",
   latitude:"47.9333",
   longitude:"-69.5167"}
  ,
  {name:"Wrangel Bay, Nunavut",
   type:"T",
   latitude:"82.0",
   longitude:"-62.05"}
  ,
  {name:"Pointe-à-Pitre, Guadeloupe (2)",
   type:"T",
   latitude:"16.2333",
   longitude:"-61.5333"}
  ,
  {name:"Key West, Florida Current",
   type:"C",
   latitude:"24.5483",
   longitude:"-81.8167"}
  ,
  {name:"Lighthouse Cove, Nova Scotia",
   type:"T",
   latitude:"44.25",
   longitude:"-66.4"}
  ,
  {name:"Wadomari, Kagosima, Japan",
   type:"T",
   latitude:"27.4",
   longitude:"128.667"}
  ,
  {name:"Kailua Kona, Big Island, Hawaii",
   type:"T",
   latitude:"19.6433",
   longitude:"-156.0"}
  ,
  {name:"Beira, Mozambique",
   type:"T",
   latitude:"-19.8167",
   longitude:"34.8333"}
  ,
  {name:"Ogi, Niigata, Japan",
   type:"T",
   latitude:"37.8167",
   longitude:"138.283"}
  ,
  {name:"Kamogawa, Tiba, Japan",
   type:"T",
   latitude:"35.0833",
   longitude:"140.1"}
  ,
  {name:"Kingscliff, Australia",
   type:"T",
   latitude:"-28.2667",
   longitude:"153.5833"}
  ,
  {name:"Concarneau, France",
   type:"T",
   latitude:"47.8667",
   longitude:"-3.9167"}
  ,
  {name:"No0, Niigata, Japan",
   type:"T",
   latitude:"37.1",
   longitude:"138.0"}
  ,
  {name:"Big Bras D'or, Nova Scotia",
   type:"T",
   latitude:"46.2833",
   longitude:"-60.4333"}
  ,
  {name:"Nickerie Rivièr, Suriname",
   type:"T",
   latitude:"5.9667",
   longitude:"-57.0167"}
  ,
  {name:"Brownell Point, Labrador",
   type:"T",
   latitude:"59.4167",
   longitude:"-63.85"}
  ,
  {name:"Byam Channel (Z3), Nunavut",
   type:"T",
   latitude:"75.1333",
   longitude:"-105.0833"}
  ,
  {name:"Port Romilly, Papua New Guinea (2)",
   type:"T",
   latitude:"-7.6667",
   longitude:"144.8333"}
  ,
  {name:"Bribie Island, Bongaree, Australia",
   type:"T",
   latitude:"-27.0833",
   longitude:"153.15"}
  ,
  {name:"Melaka, Malaysia",
   type:"T",
   latitude:"2.1833",
   longitude:"102.25"}
  ,
  {name:"Koti, Koti, Japan (2)",
   type:"T",
   latitude:"33.5",
   longitude:"133.5667"}
  ,
  {name:"Windy Harbour, Australia",
   type:"T",
   latitude:"-34.8333",
   longitude:"116.0333"}
  ,
  {name:"Molasses Key Channel, Molasses Keys, Florida",
   type:"T",
   latitude:"24.6833",
   longitude:"-81.1917"}
  ,
  {name:"Suna Wan, Kurile Islands",
   type:"T",
   latitude:"46.5333",
   longitude:"150.9"}
  ,
  {name:"Cape Don, Australia",
   type:"T",
   latitude:"-11.3167",
   longitude:"131.7667"}
  ,
  {name:"Longstaff Bluff #1, Nunavut",
   type:"T",
   latitude:"68.8833",
   longitude:"-75.1167"}
  ,
  {name:"Yosu, South Korea",
   type:"T",
   latitude:"34.7333",
   longitude:"127.7667"}
  ,
  {name:"Nemuro, Hokkaido, Japan",
   type:"T",
   latitude:"43.3333",
   longitude:"145.583"}
  ,
  {name:"Syoya, Hokkaido, Japan",
   type:"T",
   latitude:"42.0167",
   longitude:"143.283"}
  ,
  {name:"Musgrave Harbour, Newfoundland",
   type:"T",
   latitude:"49.45",
   longitude:"-53.9667"}
  ,
  {name:"Mys Astronomicheski, Russia",
   type:"T",
   latitude:"62.3833",
   longitude:"164.5"}
  ,
  {name:"Cuxhaven, Germany",
   type:"T",
   latitude:"53.8667",
   longitude:"8.7167"}
  ,
  {name:"Rabbit Island, Australia",
   type:"T",
   latitude:"-38.9167",
   longitude:"146.5167"}
  ,
  {name:"Rothesay, New Brunswick",
   type:"T",
   latitude:"45.4",
   longitude:"-66.0"}
  ,
  {name:"San Mateo Bridge (West), California",
   type:"T",
   latitude:"37.58",
   longitude:"-122.2533"}
  ,
  {name:"Leaf Basin, Québec",
   type:"T",
   latitude:"58.7333",
   longitude:"-69.0833"}
  ,
  {name:"Primrose Island, Nunavut",
   type:"T",
   latitude:"63.9167",
   longitude:"-93.0"}
  ,
  {name:"Barnegat Inlet, Barnegat Bay, New Jersey Current",
   type:"C",
   latitude:"39.7667",
   longitude:"-74.1167"}
  ,
  {name:"Hooper Island, Nunavut/NWT",
   type:"T",
   latitude:"69.6833",
   longitude:"-134.0833"}
  ,
  {name:"Hunt Islets, British Columbia",
   type:"T",
   latitude:"50.4667",
   longitude:"-128.0333"}
  ,
  {name:"Cape Cockburn, Nunavut",
   type:"T",
   latitude:"74.8667",
   longitude:"-79.3667"}
  ,
  {name:"Franklin Bay, Nunavut/NWT",
   type:"T",
   latitude:"69.95",
   longitude:"-126.9167"}
  ,
  {name:"Empire, Oregon",
   type:"T",
   latitude:"43.3833",
   longitude:"-124.2167"}
  ,
  {name:"Yaene (Hatizyo Sima), Tokyo, Japan",
   type:"T",
   latitude:"33.1",
   longitude:"139.767"}
  ,
  {name:"Swan Island, Tasmania",
   type:"T",
   latitude:"-40.7333",
   longitude:"148.1167"}
  ,
  {name:"Ettalong, Australia",
   type:"T",
   latitude:"-33.5167",
   longitude:"151.3333"}
  ,
  {name:"Provincetown, Massachusetts",
   type:"T",
   latitude:"42.0533",
   longitude:"-70.1883"}
  ,
  {name:"Inenew Passage, Québec",
   type:"T",
   latitude:"51.7333",
   longitude:"-79.0333"}
  ,
  {name:"Yo Sima, Kagawa, Japan",
   type:"T",
   latitude:"34.3833",
   longitude:"133.817"}
  ,
  {name:"Valdez, Alaska",
   type:"T",
   latitude:"61.125",
   longitude:"-146.3617"}
  ,
  {name:"Tristan da Cunha Island",
   type:"T",
   latitude:"-37.0333",
   longitude:"-12.3"}
  ,
  {name:"Nagoya, Aichi, Japan",
   type:"T",
   latitude:"35.0833",
   longitude:"136.883"}
  ,
  {name:"Pigeon Key, north side, Florida Bay, Florida",
   type:"T",
   latitude:"24.705",
   longitude:"-81.1567"}
  ,
  {name:"Sinmozi, Hukuoka, Japan",
   type:"T",
   latitude:"33.8667",
   longitude:"130.983"}
  ,
  {name:"New York, New York",
   type:"T",
   latitude:"40.7",
   longitude:"-74.015"}
  ,
  {name:"Winter Harbour, Melville Island, Nunavut/NWT",
   type:"T",
   latitude:"74.7833",
   longitude:"-110.8"}
  ,
  {name:"Makkovik Bank North, Labrador",
   type:"T",
   latitude:"55.7167",
   longitude:"-58.2"}
  ,
  {name:"Matukawaura, Fukusima, Japan",
   type:"T",
   latitude:"37.8167",
   longitude:"140.983"}
  ,
  {name:"Providence, Rhode Island",
   type:"T",
   latitude:"41.8067",
   longitude:"-71.4017"}
  ,
  {name:"Shoal Cove, Newfoundland",
   type:"T",
   latitude:"51.0167",
   longitude:"-57.0167"}
  ,
  {name:"Okha, India",
   type:"T",
   latitude:"22.4667",
   longitude:"69.0833"}
  ,
  {name:"Port Dreger, Papua New Guinea",
   type:"T",
   latitude:"-6.65",
   longitude:"147.8833"}
  ,
  {name:"Port Moresby, Papua New Guinea",
   type:"T",
   latitude:"-9.4833",
   longitude:"147.1333"}
  ,
  {name:"Antigonish Harbour, Nova Scotia",
   type:"T",
   latitude:"45.0667",
   longitude:"-61.9167"}
  ,
  {name:"Pictou, Nova Scotia",
   type:"T",
   latitude:"45.6833",
   longitude:"-62.7"}
  ,
  {name:"Higgins Island, British Columbia (2)",
   type:"T",
   latitude:"52.4833",
   longitude:"-128.75"}
  ,
  {name:"Kuching, Malaysia",
   type:"T",
   latitude:"1.5667",
   longitude:"110.35"}
  ,
  {name:"Pei-Hai, China",
   type:"T",
   latitude:"21.4833",
   longitude:"109.1"}
  ,
  {name:"Cochin, India",
   type:"T",
   latitude:"9.9667",
   longitude:"76.25"}
  ,
  {name:"Hubbards, Nova Scotia",
   type:"T",
   latitude:"44.6333",
   longitude:"-64.05"}
  ,
  {name:"Sirahama (Izu), Sizuoka, Japan",
   type:"T",
   latitude:"34.7167",
   longitude:"138.983"}
  ,
  {name:"Hopes Advance Bay, Ungava Bay, Québec",
   type:"T",
   latitude:"59.35",
   longitude:"-69.6333"}
  ,
  {name:"Akulivik, Hudson Bay, Québec",
   type:"T",
   latitude:"60.8",
   longitude:"-78.2167"}
  ,
  {name:"Kimbe, Papua New Guinea",
   type:"T",
   latitude:"-5.5",
   longitude:"150.1"}
  ,
  {name:"Gima, Okinawa, Japan",
   type:"T",
   latitude:"26.3333",
   longitude:"126.767"}
  ,
  {name:"Brickyard, Québec",
   type:"T",
   latitude:"46.55",
   longitude:"-72.15"}
  ,
  {name:"Tokati, Hokkaido, Japan",
   type:"T",
   latitude:"42.2833",
   longitude:"143.333"}
  ,
  {name:"Saint John's Harbour, Newfoundland",
   type:"T",
   latitude:"47.55",
   longitude:"-52.7"}
  ,
  {name:"Sooke, British Columbia (2)",
   type:"T",
   latitude:"48.3667",
   longitude:"-123.7333"}
  ,
  {name:"Stenhouse Bay, Australia",
   type:"T",
   latitude:"-35.2833",
   longitude:"136.9333"}
  ,
  {name:"Yokohama, Japan",
   type:"T",
   latitude:"35.4",
   longitude:"139.6333"}
  ,
  {name:"Aitutaki, Aitutaki Atoll",
   type:"T",
   latitude:"-18.85",
   longitude:"-159.7833"}
  ,
  {name:"Croiselles, South Island, New Zealand",
   type:"T",
   latitude:"-41.0833",
   longitude:"173.7"}
  ,
  {name:"False Bay, British Columbia (2)",
   type:"T",
   latitude:"49.05",
   longitude:"-124.35"}
  ,
  {name:"Hukue (Aiti), Aichi, Japan",
   type:"T",
   latitude:"34.6333",
   longitude:"137.117"}
  ,
  {name:"Bunbury, Australia (2)",
   type:"T",
   latitude:"-33.3167",
   longitude:"115.65"}
  ,
  {name:"Urakawa, Hokkaido, Japan",
   type:"T",
   latitude:"42.1667",
   longitude:"142.767"}
  ,
  {name:"Port-Navalo, France",
   type:"T",
   latitude:"47.55",
   longitude:"-2.9167"}
  ,
  {name:"Port Hood, Nova Scotia",
   type:"T",
   latitude:"46.0167",
   longitude:"-61.5333"}
  ,
  {name:"Port Langdon, Australia",
   type:"T",
   latitude:"-13.8667",
   longitude:"136.8333"}
  ,
  {name:"Sogwip'o, Cheju Do, South Korea",
   type:"T",
   latitude:"33.2333",
   longitude:"126.55"}
  ,
  {name:"Hati Lawi Harbour, Papua New Guinea (2)",
   type:"T",
   latitude:"-11.2667",
   longitude:"153.1667"}
  ,
  {name:"Casey Cove, British Columbia",
   type:"T",
   latitude:"54.2833",
   longitude:"-130.3667"}
  ,
  {name:"Ross Island, Antarctica (2)",
   type:"T",
   latitude:"-77.8667",
   longitude:"166.8"}
  ,
  {name:"Out Skerries, Shetland Islands, Scotland",
   type:"T",
   latitude:"60.4167",
   longitude:"-0.75"}
  ,
  {name:"East Chop, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.4667",
   longitude:"-70.5667"}
  ,
  {name:"Redwood City, Wharf 5, California (2)",
   type:"T",
   latitude:"37.5067",
   longitude:"-122.21"}
  ,
  {name:"Bootless Inlet, Papua New Guinea",
   type:"T",
   latitude:"-9.5",
   longitude:"147.25"}
  ,
  {name:"Meteghan, Nova Scotia",
   type:"T",
   latitude:"44.2",
   longitude:"-66.1667"}
  ,
  {name:"Port Neill, Australia",
   type:"T",
   latitude:"-34.1167",
   longitude:"136.35"}
  ,
  {name:"Tiverton (Boar's Head), St. Mary Bay, Nova Scotia (2)",
   type:"T",
   latitude:"44.3833",
   longitude:"-66.2167"}
  ,
  {name:"Uno, Okayama, Japan",
   type:"T",
   latitude:"34.5",
   longitude:"133.95"}
  ,
  {name:"Noto (Hiburi Sima), Ehime, Japan",
   type:"T",
   latitude:"33.1667",
   longitude:"132.267"}
  ,
  {name:"Cardwell, Australia (2)",
   type:"T",
   latitude:"-18.2667",
   longitude:"146.0167"}
  ,
  {name:"Ulsan, South Korea",
   type:"T",
   latitude:"35.5167",
   longitude:"129.3833"}
  ,
  {name:"Rubesibetu, Hokkaido, Japan",
   type:"T",
   latitude:"42.2",
   longitude:"143.333"}
  ,
  {name:"St. Marks River Entrance, Florida (2) (expired 1995-12-31)",
   type:"T",
   latitude:"30.0783",
   longitude:"-84.1783"}
  ,
  {name:"Osirabetu, Hokkaido, Japan",
   type:"T",
   latitude:"42.2167",
   longitude:"143.317"}
  ,
  {name:"Yingkou, China",
   type:"T",
   latitude:"40.6833",
   longitude:"122.2667"}
  ,
  {name:"Viru, Solomon Islands",
   type:"T",
   latitude:"-8.5",
   longitude:"157.75"}
  ,
  {name:"Ambon, Indonesia",
   type:"T",
   latitude:"-3.6833",
   longitude:"128.1833"}
  ,
  {name:"Bahía San Sebastian, Argentina",
   type:"T",
   latitude:"-53.1667",
   longitude:"-68.5"}
  ,
  {name:"Imbituba, Brazil",
   type:"T",
   latitude:"-28.2167",
   longitude:"-48.65"}
  ,
  {name:"Roses Bluff, Bells River, St. Marys River, Florida",
   type:"T",
   latitude:"30.7033",
   longitude:"-81.5767"}
  ,
  {name:"Hamamasu, Hokkaido, Japan",
   type:"T",
   latitude:"43.6",
   longitude:"141.383"}
  ,
  {name:"Trimouille Island, Australia",
   type:"T",
   latitude:"-20.3833",
   longitude:"115.55"}
  ,
  {name:"Little River, British Columbia",
   type:"T",
   latitude:"49.7333",
   longitude:"-124.9167"}
  ,
  {name:"Okada (O Sima), Tokyo, Japan",
   type:"T",
   latitude:"34.7833",
   longitude:"139.4"}
  ,
  {name:"Karachi, Pakistan",
   type:"T",
   latitude:"24.8",
   longitude:"66.9667"}
  ,
  {name:"Tyosi-Gyoko, Tiba, Japan",
   type:"T",
   latitude:"35.7333",
   longitude:"140.867"}
  ,
  {name:"Gibraltar (U.K.)",
   type:"T",
   latitude:"36.1333",
   longitude:"-5.35"}
  ,
  {name:"Paranaguá, Brazil",
   type:"T",
   latitude:"-25.5",
   longitude:"-48.5167"}
  ,
  {name:"Boothbay Harbor, Maine",
   type:"T",
   latitude:"43.85",
   longitude:"-69.6283"}
  ,
  {name:"Morse Basin, British Columbia",
   type:"T",
   latitude:"54.25",
   longitude:"-130.2333"}
  ,
  {name:"Caldera, Chile",
   type:"T",
   latitude:"-27.0667",
   longitude:"-70.8333"}
  ,
  {name:"Pinamar, Argentina",
   type:"T",
   latitude:"-37.1333",
   longitude:"-56.8833"}
  ,
  {name:"Friday Harbor, San Juan Island, Washington",
   type:"T",
   latitude:"48.5467",
   longitude:"-123.01"}
  ,
  {name:"Isigaki, Okinawa, Japan",
   type:"T",
   latitude:"24.3333",
   longitude:"124.167"}
  ,
  {name:"Cape Voltaire, Australia",
   type:"T",
   latitude:"-14.25",
   longitude:"125.6"}
  ,
  {name:"Tateyama, Tiba, Japan",
   type:"T",
   latitude:"34.9833",
   longitude:"139.85"}
  ,
  {name:"Etomo, Simane, Japan",
   type:"T",
   latitude:"35.5167",
   longitude:"132.983"}
  ,
  {name:"Morozaki, Aichi, Japan",
   type:"T",
   latitude:"34.7",
   longitude:"136.983"}
  ,
  {name:"Georgetown, St. Johns River, Florida",
   type:"T",
   latitude:"29.385",
   longitude:"-81.6367"}
  ,
  {name:"Hongay, Vietnam",
   type:"T",
   latitude:"20.95",
   longitude:"107.0667"}
  ,
  {name:"Hunters Point, San Francisco Bay, California",
   type:"T",
   latitude:"37.73",
   longitude:"-122.3567"}
  ,
  {name:"Raymond, Washington",
   type:"T",
   latitude:"46.6833",
   longitude:"-123.75"}
  ,
  {name:"Pearson Island, Australia",
   type:"T",
   latitude:"-33.9333",
   longitude:"134.2667"}
  ,
  {name:"Sea Girt, New Jersey",
   type:"T",
   latitude:"40.1333",
   longitude:"-74.0333"}
  ,
  {name:"Port Orford, Oregon",
   type:"T",
   latitude:"42.74",
   longitude:"-124.4967"}
  ,
  {name:"Bugatti Reef, Australia",
   type:"T",
   latitude:"-20.1",
   longitude:"150.2833"}
  ,
  {name:"Thevenard, Australia",
   type:"T",
   latitude:"-32.15",
   longitude:"133.65"}
  ,
  {name:"Makurazaki, Kagosima, Japan",
   type:"T",
   latitude:"31.2667",
   longitude:"130.3"}
  ,
  {name:"Tofino, British Columbia",
   type:"T",
   latitude:"49.15",
   longitude:"-125.9167"}
  ,
  {name:"Negisi, Kanagawa, Japan",
   type:"T",
   latitude:"35.4",
   longitude:"139.633"}
  ,
  {name:"Do Son, Vietnam",
   type:"T",
   latitude:"20.6667",
   longitude:"106.8"}
  ,
  {name:"Akasi, Hyogo, Japan",
   type:"T",
   latitude:"34.65",
   longitude:"135.0"}
  ,
  {name:"Zige, Ishikawa, Japan",
   type:"T",
   latitude:"37.5",
   longitude:"137.35"}
  ,
  {name:"Takesiki, Nagasaki, Japan",
   type:"T",
   latitude:"34.3",
   longitude:"129.3"}
  ,
  {name:"Corpus Christi, Texas",
   type:"T",
   latitude:"27.58",
   longitude:"-97.2167"}
  ,
  {name:"Rockland, Penobscot River, Maine",
   type:"T",
   latitude:"44.105",
   longitude:"-69.1017"}
  ,
  {name:"Heikish Narrows, British Columbia Current",
   type:"C",
   latitude:"52.8667",
   longitude:"-128.5"}
  ,
  {name:"Malakal, Palau",
   type:"T",
   latitude:"7.3333",
   longitude:"134.4667"}
  ,
  {name:"Kikori, Papua New Guinea",
   type:"T",
   latitude:"-7.4167",
   longitude:"144.25"}
  ,
  {name:"Tatuma Saki, Aichi, Japan",
   type:"T",
   latitude:"34.6667",
   longitude:"137.083"}
  ,
  {name:"Walton, Nova Scotia (over keel blocks)",
   type:"T",
   latitude:"45.2167",
   longitude:"-64.0"}
  ,
  {name:"Koe, Nagasaki, Japan",
   type:"T",
   latitude:"32.75",
   longitude:"129.817"}
  ,
  {name:"Windsor, Nova Scotia (over keel blocks)",
   type:"T",
   latitude:"45.0",
   longitude:"-64.1333"}
  ,
  {name:"Trident Pier, Port Canaveral, Florida",
   type:"T",
   latitude:"28.415",
   longitude:"-80.5933"}
  ,
  {name:"Québec (Lauzon), Québec",
   type:"T",
   latitude:"46.8333",
   longitude:"-71.1667"}
  ,
  {name:"Nain Bank Station 847, Labrador",
   type:"T",
   latitude:"57.0",
   longitude:"-58.0667"}
  ,
  {name:"Broome, Australia (2)",
   type:"T",
   latitude:"-18.0",
   longitude:"122.2167"}
  ,
  {name:"Daly River, Australia",
   type:"T",
   latitude:"-13.3667",
   longitude:"130.3167"}
  ,
  {name:"Hanasaki, Hokkaido, Japan",
   type:"T",
   latitude:"43.2833",
   longitude:"145.583"}
  ,
  {name:"Yura (Yamagata), Yamagata, Japan",
   type:"T",
   latitude:"38.7167",
   longitude:"139.683"}
  ,
  {name:"Savannah River Entrance, Georgia Current",
   type:"C",
   latitude:"32.0367",
   longitude:"-80.8583"}
  ,
  {name:"Mali Losinj, Croatia",
   type:"T",
   latitude:"44.5333",
   longitude:"14.4667"}
  ,
  {name:"Amelia City, South Amelia River, Florida (2)",
   type:"T",
   latitude:"30.5867",
   longitude:"-81.4633"}
  ,
  {name:"Bayley Island, Australia",
   type:"T",
   latitude:"-16.9",
   longitude:"139.0667"}
  ,
  {name:"Farewell, Newfoundland",
   type:"T",
   latitude:"49.55",
   longitude:"-54.4667"}
  ,
  {name:"St. Augustin, Québec",
   type:"T",
   latitude:"51.2167",
   longitude:"-58.65"}
  ,
  {name:"Outer Wood Island, New Brunswick",
   type:"T",
   latitude:"44.6",
   longitude:"-66.8"}
  ,
  {name:"Itajaí, Brazil",
   type:"T",
   latitude:"-26.9",
   longitude:"-48.65"}
  ,
  {name:"Siizaki, Kyoto, Japan",
   type:"T",
   latitude:"35.55",
   longitude:"135.2"}
  ,
  {name:"Matarani, Peru",
   type:"T",
   latitude:"-17.0",
   longitude:"-72.1167"}
  ,
  {name:"Ohunato, Iwate, Japan",
   type:"T",
   latitude:"39.05",
   longitude:"141.733"}
  ,
  {name:"Yura (Awazi Sima), Hyogo, Japan",
   type:"T",
   latitude:"34.2667",
   longitude:"134.95"}
  ,
  {name:"Koti, Koti, Japan",
   type:"T",
   latitude:"33.5",
   longitude:"133.567"}
  ,
  {name:"West Head, Nova Scotia",
   type:"T",
   latitude:"43.4667",
   longitude:"-65.65"}
  ,
  {name:"Ikuzi, Toyama, Japan",
   type:"T",
   latitude:"36.8833",
   longitude:"137.417"}
  ,
  {name:"Basrah, Iraq",
   type:"T",
   latitude:"30.5167",
   longitude:"47.85"}
  ,
  {name:"Ellerslie, Prince Edward Island",
   type:"T",
   latitude:"46.65",
   longitude:"-63.9167"}
  ,
  {name:"Nuku`alofa, Tonga",
   type:"T",
   latitude:"-21.1333",
   longitude:"-175.2167"}
  ,
  {name:"Puerto Soberania, South Shetland Islands",
   type:"T",
   latitude:"-62.4833",
   longitude:"-59.6333"}
  ,
  {name:"Wiah Point, British Columbia (2)",
   type:"T",
   latitude:"54.1167",
   longitude:"-132.3167"}
  ,
  {name:"Northwest River, Labrador",
   type:"T",
   latitude:"53.5167",
   longitude:"-60.15"}
  ,
  {name:"Moosonee, James Bay, Ontario",
   type:"T",
   latitude:"51.2833",
   longitude:"-80.6333"}
  ,
  {name:"Veracruz, Veracruz, Mexico (2)",
   type:"T",
   latitude:"19.1833",
   longitude:"-96.1167"}
  ,
  {name:"Beaver Harbour, New Brunswick",
   type:"T",
   latitude:"45.0667",
   longitude:"-66.7333"}
  ,
  {name:"Îles Wallis",
   type:"T",
   latitude:"-13.3667",
   longitude:"-176.1833"}
  ,
  {name:"Arakawa, Nagasaki, Japan",
   type:"T",
   latitude:"32.9167",
   longitude:"129.05"}
  ,
  {name:"Eastport, Maine (2) (expired 1988-12-31)",
   type:"T",
   latitude:"44.9033",
   longitude:"-66.985"}
  ,
  {name:"Rennel Island, Coral Sea",
   type:"T",
   latitude:"-9.7667",
   longitude:"143.2667"}
  ,
  {name:"Pender Harbour, British Columbia",
   type:"T",
   latitude:"49.6333",
   longitude:"-124.0333"}
  ,
  {name:"Saint-Nicolas, Québec",
   type:"T",
   latitude:"46.7167",
   longitude:"-71.3833"}
  ,
  {name:"Vardø, Norway",
   type:"T",
   latitude:"70.3333",
   longitude:"31.1"}
  ,
  {name:"Caio, Guinea-Bissau",
   type:"T",
   latitude:"11.8333",
   longitude:"-16.3167"}
  ,
  {name:"Nisi (Io-Sima), Tokyo, Japan",
   type:"T",
   latitude:"24.8",
   longitude:"141.3"}
  ,
  {name:"Nagasu, Kumamoto, Japan",
   type:"T",
   latitude:"32.9167",
   longitude:"130.45"}
  ,
  {name:"Utaro, Hokkaido, Japan",
   type:"T",
   latitude:"41.9667",
   longitude:"143.2"}
  ,
  {name:"Yamagawa, Kagosima, Japan",
   type:"T",
   latitude:"31.2",
   longitude:"130.633"}
  ,
  {name:"Port Martin, Antarctica",
   type:"T",
   latitude:"-66.8167",
   longitude:"141.3833"}
  ,
  {name:"Ogusi Wan, Nagasaki, Japan",
   type:"T",
   latitude:"33.0667",
   longitude:"129.817"}
  ,
  {name:"Port Isabel, Texas",
   type:"T",
   latitude:"26.06",
   longitude:"-97.215"}
  ,
  {name:"Sidney Bay, British Columbia (2)",
   type:"T",
   latitude:"50.5167",
   longitude:"-125.5833"}
  ,
  {name:"Bahía Honda Harbor (Bridge) Florida Current",
   type:"C",
   latitude:"24.6567",
   longitude:"-81.2883"}
  ,
  {name:"St. Augustine Beach, Florida",
   type:"T",
   latitude:"29.8567",
   longitude:"-81.2617"}
  ,
  {name:"Lisbon, Portugal",
   type:"T",
   latitude:"38.7",
   longitude:"-9.1333"}
  ,
  {name:"Jurien Bay, Australia",
   type:"T",
   latitude:"-30.3",
   longitude:"115.0333"}
  ,
  {name:"Goods Island, Torres Strait",
   type:"T",
   latitude:"-10.5667",
   longitude:"142.1667"}
  ,
  {name:"Eskimo Lakes Station 1c, Nunavut/NWT",
   type:"T",
   latitude:"69.5667",
   longitude:"-131.2833"}
  ,
  {name:"Trout River, Sherwood Forest, Florida (3)",
   type:"T",
   latitude:"30.42",
   longitude:"-81.7283"}
  ,
  {name:"St. Johns River at Buckman Bridge, Florida",
   type:"T",
   latitude:"30.1911",
   longitude:"-81.6922"}
  ,
  {name:"Virginia Key, Bear Cut, Florida",
   type:"T",
   latitude:"25.7317",
   longitude:"-80.1617"}
  ,
  {name:"Hornafjörður, Iceland",
   type:"T",
   latitude:"64.25",
   longitude:"-15.2"}
  ,
  {name:"Simabara-Sinkoo, Nagasaki, Japan",
   type:"T",
   latitude:"32.8167",
   longitude:"130.367"}
  ,
  {name:"Saint John, New Brunswick (2)",
   type:"T",
   latitude:"45.2667",
   longitude:"-66.0667"}
  ,
  {name:"Proudfoot Shoal, Torres Strait",
   type:"T",
   latitude:"-10.5167",
   longitude:"141.4833"}
  ,
  {name:"Sheet Harbour, Nova Scotia",
   type:"T",
   latitude:"44.9167",
   longitude:"-62.5333"}
  ,
  {name:"Thank God Harbour, Polaris Bugt, Greenland",
   type:"T",
   latitude:"81.6",
   longitude:"-61.6333"}
  ,
  {name:"Charlottetown, Prince Edward Island",
   type:"T",
   latitude:"46.2167",
   longitude:"-63.1333"}
  ,
  {name:"Immingham Dock, Humberside, England",
   type:"T",
   latitude:"51.7167",
   longitude:"-2.4667"}
  ,
  {name:"Sasuna, Nagasaki, Japan",
   type:"T",
   latitude:"34.6333",
   longitude:"129.4"}
  ,
  {name:"Alert Bay, British Columbia (2)",
   type:"T",
   latitude:"50.5833",
   longitude:"-126.9333"}
  ,
  {name:"Milne Inlet (Head), Nunavut",
   type:"T",
   latitude:"71.9",
   longitude:"-80.85"}
  ,
  {name:"Sinti (Tyosi), Tiba, Japan",
   type:"T",
   latitude:"35.7333",
   longitude:"140.85"}
  ,
  {name:"Aziro (Naruto), Tokusima, Japan",
   type:"T",
   latitude:"34.2333",
   longitude:"134.633"}
  ,
  {name:"Severn Harbour Area, Nunavut",
   type:"T",
   latitude:"63.6",
   longitude:"-91.0167"}
  ,
  {name:"Victor Harbor, Australia",
   type:"T",
   latitude:"-35.5667",
   longitude:"138.6333"}
  ,
  {name:"Montague, Prince Edward Island",
   type:"T",
   latitude:"46.0167",
   longitude:"-62.65"}
  ,
  {name:"Kakinada, India",
   type:"T",
   latitude:"16.9333",
   longitude:"82.25"}
  ,
  {name:"Diego-Suarez, Madagascar",
   type:"T",
   latitude:"-12.2667",
   longitude:"49.2833"}
  ,
  {name:"Klemtu, British Columbia (2)",
   type:"T",
   latitude:"52.6",
   longitude:"-128.5167"}
  ,
  {name:"Murray Harbour, Prince Edward Island",
   type:"T",
   latitude:"46.0167",
   longitude:"-62.4833"}
  ,
  {name:"Cape Liverpool, Nunavut",
   type:"T",
   latitude:"73.6333",
   longitude:"-78.1"}
  ,
  {name:"Koniya, Kagosima, Japan",
   type:"T",
   latitude:"28.15",
   longitude:"129.317"}
  ,
  {name:"Trout River, Sherwood Forest, Florida (2)",
   type:"T",
   latitude:"30.42",
   longitude:"-81.7283"}
  ,
  {name:"Stamford, Connecticut",
   type:"T",
   latitude:"41.0383",
   longitude:"-73.5467"}
  ,
  {name:"Rivière Au Tonnerre, Québec",
   type:"T",
   latitude:"50.2833",
   longitude:"-64.7833"}
  ,
  {name:"Kiire, Kagosima, Japan",
   type:"T",
   latitude:"31.3833",
   longitude:"130.55"}
  ,
  {name:"Diamond Harbour, India",
   type:"T",
   latitude:"22.1833",
   longitude:"88.1833"}
  ,
  {name:"Pipon Island, Australia",
   type:"T",
   latitude:"-14.1333",
   longitude:"144.5167"}
  ,
  {name:"Trounce Inlet, British Columbia (2)",
   type:"T",
   latitude:"53.15",
   longitude:"-132.3167"}
  ,
  {name:"Inch'on, South Korea",
   type:"T",
   latitude:"37.4667",
   longitude:"126.5833"}
  ,
  {name:"Îles du Salut, French Guiana",
   type:"T",
   latitude:"5.2833",
   longitude:"-52.5833"}
  ,
  {name:"Denton, Choptank River, Maryland",
   type:"T",
   latitude:"38.8833",
   longitude:"-75.8333"}
  ,
  {name:"Gull Island, Newfoundland",
   type:"T",
   latitude:"47.2667",
   longitude:"-52.7833"}
  ,
  {name:"Pocahontas Point, British Columbia",
   type:"T",
   latitude:"48.9833",
   longitude:"-124.9167"}
  ,
  {name:"San Clemente, Punta Norte del Cabo San Antonio, Argentina",
   type:"T",
   latitude:"-36.3",
   longitude:"-56.7833"}
  ,
  {name:"San Felipe, Baja California Norte, Mexico",
   type:"T",
   latitude:"31.0333",
   longitude:"-114.7667"}
  ,
  {name:"Sausalito, California",
   type:"T",
   latitude:"37.85",
   longitude:"-122.4833"}
  ,
  {name:"Egedesminde, Greenland",
   type:"T",
   latitude:"68.7167",
   longitude:"-52.8833"}
  ,
  {name:"Taziri, Tottori, Japan",
   type:"T",
   latitude:"35.5833",
   longitude:"134.317"}
  ,
  {name:"Sørvágur, Faroe Islands",
   type:"T",
   latitude:"62.071",
   longitude:"-7.3333"}
  ,
  {name:"Berthier, Québec",
   type:"T",
   latitude:"46.9333",
   longitude:"-70.7333"}
  ,
  {name:"Christmas Island",
   type:"T",
   latitude:"-10.4",
   longitude:"105.7167"}
  ,
  {name:"Kelsey Bay, British Columbia",
   type:"T",
   latitude:"50.4",
   longitude:"-125.9667"}
  ,
  {name:"Davis River, British Columbia (2)",
   type:"T",
   latitude:"55.7667",
   longitude:"-130.1667"}
  ,
  {name:"Freeport Harbour, Grand Bahama Island, Bahamas",
   type:"T",
   latitude:"26.5167",
   longitude:"-78.7833"}
  ,
  {name:"Muroran, Hokkaido, Japan (2)",
   type:"T",
   latitude:"42.35",
   longitude:"140.9667"}
  ,
  {name:"Plymouth (Devonport), England",
   type:"T",
   latitude:"50.3667",
   longitude:"-4.1833"}
  ,
  {name:"Port Hardy, British Columbia (2)",
   type:"T",
   latitude:"50.7167",
   longitude:"-127.4833"}
  ,
  {name:"Palm Valley, ICWW, Florida",
   type:"T",
   latitude:"30.1333",
   longitude:"-81.3867"}
  ,
  {name:"Casey Cove, British Columbia (2)",
   type:"T",
   latitude:"54.2833",
   longitude:"-130.3667"}
  ,
  {name:"Arena Cove, California",
   type:"T",
   latitude:"38.9133",
   longitude:"-123.7083"}
  ,
  {name:"Block Island (Old Harbor), Rhode Island",
   type:"T",
   latitude:"41.1733",
   longitude:"-71.5567"}
  ,
  {name:"Sukku, Okinawa, Japan",
   type:"T",
   latitude:"26.55",
   longitude:"128.033"}
  ,
  {name:"Tantabiddi, Australia",
   type:"T",
   latitude:"-21.9167",
   longitude:"113.9833"}
  ,
  {name:"Turtle Point, Australia",
   type:"T",
   latitude:"-14.8333",
   longitude:"129.2333"}
  ,
  {name:"Frederick Sound, British Columbia",
   type:"T",
   latitude:"51.05",
   longitude:"-126.7333"}
  ,
  {name:"Sandy Cove, Nova Scotia",
   type:"T",
   latitude:"44.5",
   longitude:"-66.1"}
  ,
  {name:"Himezi-Sikama, Hyogo, Japan (2)",
   type:"T",
   latitude:"34.7833",
   longitude:"134.6667"}
  ,
  {name:"St-Laurent-D'orleans, Québec",
   type:"T",
   latitude:"46.8667",
   longitude:"-71.0"}
  ,
  {name:"Hermitage, Newfoundland",
   type:"T",
   latitude:"47.5667",
   longitude:"-55.9333"}
  ,
  {name:"Dunk Island, Australia",
   type:"T",
   latitude:"-17.9333",
   longitude:"146.15"}
  ,
  {name:"Freeport Harbor, Texas",
   type:"T",
   latitude:"28.9467",
   longitude:"-95.3083"}
  ,
  {name:"Port Chalmers, New Zealand",
   type:"T",
   latitude:"-45.8167",
   longitude:"170.65"}
  ,
  {name:"Trout River, Sherwood Forest, Florida (4)",
   type:"T",
   latitude:"30.42",
   longitude:"-81.7283"}
  ,
  {name:"Sitirui, Simane, Japan",
   type:"T",
   latitude:"35.5667",
   longitude:"133.233"}
  ,
  {name:"Florida Bay (East), Florida",
   type:"T",
   latitude:"24.8367",
   longitude:"-80.7667"}
  ,
  {name:"Moroiso, Kanagawa, Japan",
   type:"T",
   latitude:"35.15",
   longitude:"139.617"}
  ,
  {name:"Kusiro, Hokkaido, Japan (2)",
   type:"T",
   latitude:"42.9667",
   longitude:"144.3833"}
  ,
  {name:"Port Broughton, Australia",
   type:"T",
   latitude:"-33.6",
   longitude:"137.9333"}
  ,
  {name:"Zizo Saki, Kagawa, Japan",
   type:"T",
   latitude:"34.4333",
   longitude:"134.233"}
  ,
  {name:"Gizo Anchorage, Solomon Islands",
   type:"T",
   latitude:"-8.1",
   longitude:"156.85"}
  ,
  {name:"Kamae, Oita, Japan",
   type:"T",
   latitude:"32.7833",
   longitude:"131.917"}
  ,
  {name:"Princess Louisa Inlet, British Columbia Current",
   type:"C",
   latitude:"50.1667",
   longitude:"-123.85"}
  ,
  {name:"Esaki, Yamaguti, Japan",
   type:"T",
   latitude:"34.6333",
   longitude:"131.65"}
  ,
  {name:"Barbour Bay, Nunavut",
   type:"T",
   latitude:"63.7",
   longitude:"-91.9167"}
  ,
  {name:"San Mateo Bridge (east end), San Francisco Bay, California",
   type:"T",
   latitude:"37.6",
   longitude:"-122.1833"}
  ,
  {name:"Cascais, Portugal",
   type:"T",
   latitude:"38.6833",
   longitude:"-9.4167"}
  ,
  {name:"Gibbs Island, Pleasant River, Maine",
   type:"T",
   latitude:"44.55",
   longitude:"-67.7667"}
  ,
  {name:"Albany, Australia (2)",
   type:"T",
   latitude:"-35.0333",
   longitude:"117.8833"}
  ,
  {name:"Dungeness Reef, Coral Sea",
   type:"T",
   latitude:"-9.9833",
   longitude:"142.9833"}
  ,
  {name:"Centreville, Nova Scotia",
   type:"T",
   latitude:"44.55",
   longitude:"-66.0333"}
  ,
  {name:"Queen Charlotte, British Columbia",
   type:"T",
   latitude:"53.25",
   longitude:"-132.0667"}
  ,
  {name:"Port Saunders, Newfoundland",
   type:"T",
   latitude:"50.65",
   longitude:"-57.3"}
  ,
  {name:"Usuziri, Hokkaido, Japan",
   type:"T",
   latitude:"41.9333",
   longitude:"140.95"}
  ,
  {name:"Pittwater, Australia",
   type:"T",
   latitude:"-33.6",
   longitude:"151.3"}
  ,
  {name:"Shelburne, Nova Scotia",
   type:"T",
   latitude:"43.75",
   longitude:"-65.3"}
  ,
  {name:"Longyearbyen, Spitsbergen",
   type:"T",
   latitude:"78.2167",
   longitude:"15.6333"}
  ,
  {name:"Port Welshpool, Australia",
   type:"T",
   latitude:"-38.7",
   longitude:"146.45"}
  ,
  {name:"Toyohasi, Aichi, Japan",
   type:"T",
   latitude:"34.7167",
   longitude:"137.333"}
  ,
  {name:"Fare Ute Point, Papeete Harbor, Tahiti",
   type:"T",
   latitude:"-17.535",
   longitude:"-149.5717"}
  ,
  {name:"Sembawang, Singapore",
   type:"T",
   latitude:"1.4667",
   longitude:"103.8167"}
  ,
  {name:"Argentia, Newfoundland (2)",
   type:"T",
   latitude:"47.3",
   longitude:"-53.9833"}
  ,
  {name:"Bar Harbor, Frenchman Bay, Maine (2) (expired 1999-07-27)",
   type:"T",
   latitude:"44.3917",
   longitude:"-68.205"}
  ,
  {name:"Karrakatta Bay, Australia",
   type:"T",
   latitude:"-16.3667",
   longitude:"123.0333"}
  ,
  {name:"Tukizi, Tokyo, Japan",
   type:"T",
   latitude:"35.6667",
   longitude:"139.767"}
  ,
  {name:"San Diego Bay Entrance, California Current",
   type:"C",
   latitude:"32.6817",
   longitude:"-117.1733"}
  ,
  {name:"Sooke, British Columbia",
   type:"T",
   latitude:"48.3667",
   longitude:"-123.7333"}
  ,
  {name:"Magome, Nagasaki, Japan",
   type:"T",
   latitude:"33.0333",
   longitude:"129.617"}
  ,
  {name:"Honiara, Solomon Islands",
   type:"T",
   latitude:"-9.4167",
   longitude:"159.9667"}
  ,
  {name:"Ladysmith, British Columbia",
   type:"T",
   latitude:"48.9833",
   longitude:"-123.7833"}
  ,
  {name:"Carmanville, Newfoundland",
   type:"T",
   latitude:"49.4",
   longitude:"-54.2833"}
  ,
  {name:"Yokeko Point, British Columbia",
   type:"T",
   latitude:"48.4167",
   longitude:"-122.6167"}
  ,
  {name:"Arnold's Cove, Newfoundland",
   type:"T",
   latitude:"47.75",
   longitude:"-54.0"}
  ,
  {name:"Simotui, Okayama, Japan",
   type:"T",
   latitude:"34.4333",
   longitude:"133.8"}
  ,
  {name:"Yobokori, Ehime, Japan",
   type:"T",
   latitude:"33.3833",
   longitude:"132.083"}
  ,
  {name:"Arikawa, Nagasaki, Japan",
   type:"T",
   latitude:"32.9833",
   longitude:"129.117"}
  ,
  {name:"Dundas Harbour, Nunavut",
   type:"T",
   latitude:"74.5167",
   longitude:"-82.4167"}
  ,
  {name:"Wazima, Ishikawa, Japan",
   type:"T",
   latitude:"37.4",
   longitude:"136.9"}
  ,
  {name:"Rotterdam, Netherlands",
   type:"T",
   latitude:"51.9167",
   longitude:"4.5"}
  ,
  {name:"Gisborne, New Zealand",
   type:"T",
   latitude:"-38.6667",
   longitude:"178.0167"}
  ,
  {name:"Tangalooma Point, Australia",
   type:"T",
   latitude:"-27.1833",
   longitude:"153.3667"}
  ,
  {name:"Wedge Island, Australia",
   type:"T",
   latitude:"-35.1667",
   longitude:"136.5667"}
  ,
  {name:"Batiscan, Québec",
   type:"T",
   latitude:"46.5",
   longitude:"-72.25"}
  ,
  {name:"Iino Seto, Nagasaki, Japan",
   type:"T",
   latitude:"32.95",
   longitude:"129.0"}
  ,
  {name:"Bloedel, British Columbia (2)",
   type:"T",
   latitude:"50.1167",
   longitude:"-125.3833"}
  ,
  {name:"Monbetu, Hokkaido, Japan",
   type:"T",
   latitude:"44.35",
   longitude:"143.367"}
  ,
  {name:"St-Bernard-de-l'ile-, Québec",
   type:"T",
   latitude:"47.45",
   longitude:"-70.3667"}
  ,
  {name:"Porpoise Bay, British Columbia (2)",
   type:"T",
   latitude:"49.4833",
   longitude:"-123.75"}
  ,
  {name:"East Repulse Island, Australia",
   type:"T",
   latitude:"-20.5833",
   longitude:"148.8833"}
  ,
  {name:"Fernandina Beach, Amelia River, Florida",
   type:"T",
   latitude:"30.6717",
   longitude:"-81.4667"}
  ,
  {name:"Tagonoura, Sizuoka, Japan",
   type:"T",
   latitude:"35.1333",
   longitude:"138.7"}
  ,
  {name:"Port Taranaki, New Zealand",
   type:"T",
   latitude:"-39.0667",
   longitude:"174.0333"}
  ,
  {name:"Santo Antonio, Principe",
   type:"T",
   latitude:"1.6333",
   longitude:"7.4167"}
  ,
  {name:"Eleuthera Island (east coast), Bahamas",
   type:"T",
   latitude:"24.9333",
   longitude:"-76.15"}
  ,
  {name:"Umuda Island, Papua New Guinea",
   type:"T",
   latitude:"-8.5",
   longitude:"143.7833"}
  ,
  {name:"Île D'entree, Nova Scotia",
   type:"T",
   latitude:"47.2833",
   longitude:"-61.7167"}
  ,
  {name:"Renouf Island, Nunavut",
   type:"T",
   latitude:"56.5667",
   longitude:"-79.0167"}
  ,
  {name:"Air Musi, Sumatra, Indonesia",
   type:"T",
   latitude:"-2.2",
   longitude:"104.95"}
  ,
  {name:"Mcmaster Island, New Brunswick",
   type:"T",
   latitude:"45.05",
   longitude:"-66.9333"}
  ,
  {name:"Campeche City, Campeche, Mexico",
   type:"T",
   latitude:"18.6667",
   longitude:"-90.5333"}
  ,
  {name:"Île-Aux-Lievres, Québec",
   type:"T",
   latitude:"47.9",
   longitude:"-69.6833"}
  ,
  {name:"Usimado, Okayama, Japan",
   type:"T",
   latitude:"34.6167",
   longitude:"134.167"}
  ,
  {name:"Uke Sima, Kagosima, Japan",
   type:"T",
   latitude:"28.0333",
   longitude:"129.233"}
  ,
  {name:"Okuti Wan, Ehime, Japan",
   type:"T",
   latitude:"33.3333",
   longitude:"132.383"}
  ,
  {name:"Boat Passage, British Columbia Current",
   type:"C",
   latitude:"48.8167",
   longitude:"-123.1833"}
  ,
  {name:"Cap-A-La-Roche, Québec",
   type:"T",
   latitude:"46.5667",
   longitude:"-72.1"}
  ,
  {name:"Smithers Island, British Columbia",
   type:"T",
   latitude:"52.75",
   longitude:"-129.0667"}
  ,
  {name:"Twin Islands, British Columbia",
   type:"T",
   latitude:"50.0333",
   longitude:"-124.9333"}
  ,
  {name:"Kilindini Harbour, Kenya",
   type:"T",
   latitude:"-4.0833",
   longitude:"39.65"}
  ,
  {name:"Oyama Ura, Nagasaki, Japan",
   type:"T",
   latitude:"34.3333",
   longitude:"129.35"}
  ,
  {name:"Fundy (Offshore 22a), Nova Scotia",
   type:"T",
   latitude:"42.1167",
   longitude:"-65.05"}
  ,
  {name:"Bonanza, Spain",
   type:"T",
   latitude:"36.8",
   longitude:"-6.3333"}
  ,
  {name:"Sakito, Nagasaki, Japan",
   type:"T",
   latitude:"33.0167",
   longitude:"129.567"}
  ,
  {name:"Navlakhi, India",
   type:"T",
   latitude:"22.9667",
   longitude:"70.45"}
  ,
  {name:"Douglas Harbour, Québec",
   type:"T",
   latitude:"61.9167",
   longitude:"-72.6167"}
  ,
  {name:"St. Croix, Lime Tree Bay, Virgin Islands",
   type:"T",
   latitude:"17.6967",
   longitude:"-64.7533"}
  ,
  {name:"Omati, Papua New Guinea",
   type:"T",
   latitude:"-7.4333",
   longitude:"143.9667"}
  ,
  {name:"Marsden Point, New Zealand",
   type:"T",
   latitude:"-35.8333",
   longitude:"174.5"}
  ,
  {name:"Unosima, Hukuoka, Japan",
   type:"T",
   latitude:"33.6333",
   longitude:"131.133"}
  ,
  {name:"Dover, England (3)",
   type:"T",
   latitude:"51.1167",
   longitude:"1.3167"}
  ,
  {name:"Hillsborough, Carriacou, The Grenadines",
   type:"T",
   latitude:"12.4833",
   longitude:"-61.45"}
  ,
  {name:"Airstrip Point, Nunavut",
   type:"T",
   latitude:"76.0833",
   longitude:"-97.7333"}
  ,
  {name:"Oak Bay, British Columbia",
   type:"T",
   latitude:"48.4333",
   longitude:"-123.3"}
  ,
  {name:"Duck Island, Québec",
   type:"T",
   latitude:"55.75",
   longitude:"-77.2"}
  ,
  {name:"Finnsbu, Greenland",
   type:"T",
   latitude:"63.4",
   longitude:"-41.2833"}
  ,
  {name:"Sita Ura, Oita, Japan",
   type:"T",
   latitude:"33.2333",
   longitude:"131.883"}
  ,
  {name:"West Chop, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.4833",
   longitude:"-70.6017"}
  ,
  {name:"Higgins Island, British Columbia",
   type:"T",
   latitude:"52.4833",
   longitude:"-128.75"}
  ,
  {name:"Nicholson Creek, Ontario",
   type:"T",
   latitude:"51.3",
   longitude:"-80.5667"}
  ,
  {name:"Kabasima Suido, Nagasaki, Japan",
   type:"T",
   latitude:"32.55",
   longitude:"129.783"}
  ,
  {name:"Nerang River (Bundall), Australia",
   type:"T",
   latitude:"-28.0",
   longitude:"153.4167"}
  ,
  {name:"Learmonth, Australia",
   type:"T",
   latitude:"-22.1833",
   longitude:"114.0833"}
  ,
  {name:"Port Royal, Jamaica",
   type:"T",
   latitude:"17.95",
   longitude:"-76.8333"}
  ,
  {name:"Exmouth, Australia",
   type:"T",
   latitude:"-21.9333",
   longitude:"114.15"}
  ,
  {name:"Knox Bay, British Columbia (2)",
   type:"T",
   latitude:"50.4",
   longitude:"-125.6"}
  ,
  {name:"Maceió, Brazil",
   type:"T",
   latitude:"-9.6833",
   longitude:"-35.7167"}
  ,
  {name:"Amuay, Venezuela",
   type:"T",
   latitude:"11.75",
   longitude:"-70.2167"}
  ,
  {name:"Dover, England (2)",
   type:"T",
   latitude:"51.1167",
   longitude:"1.3167"}
  ,
  {name:"Luderitz Bay, Namibia",
   type:"T",
   latitude:"-26.65",
   longitude:"15.15"}
  ,
  {name:"Aquia Creek, Virginia",
   type:"T",
   latitude:"38.4183",
   longitude:"-77.3533"}
  ,
  {name:"Liverpool, England (2)",
   type:"T",
   latitude:"53.4167",
   longitude:"-3.0"}
  ,
  {name:"Solomons Island, Patuxent River, Maryland",
   type:"T",
   latitude:"38.3167",
   longitude:"-76.4517"}
  ,
  {name:"Port Macdonnell, Australia",
   type:"T",
   latitude:"-38.05",
   longitude:"140.7"}
  ,
  {name:"Trois-Rivières, Québec (2)",
   type:"T",
   latitude:"46.3333",
   longitude:"-72.5333"}
  ,
  {name:"Londonderry, Northern Ireland (2)",
   type:"T",
   latitude:"55.0",
   longitude:"-7.3167"}
  ,
  {name:"Montauk, Fort Pond Bay, Long Island Sound, New York (2)",
   type:"T",
   latitude:"41.0483",
   longitude:"-71.96"}
  ,
  {name:"Doi, Yamaguti, Japan",
   type:"T",
   latitude:"33.9167",
   longitude:"132.3"}
  ,
  {name:"Shanghai, China",
   type:"T",
   latitude:"31.4",
   longitude:"121.5"}
  ,
  {name:"Karang Jamuang, Java, Indonesia",
   type:"T",
   latitude:"-6.9333",
   longitude:"112.7333"}
  ,
  {name:"Vieques Passage, Puerto Rico Current (2)",
   type:"C",
   latitude:"18.1883",
   longitude:"-65.6183"}
  ,
  {name:"Les Hattes, Rio Maroni entrance, French Guiana",
   type:"T",
   latitude:"5.75",
   longitude:"-53.9667"}
  ,
  {name:"Kamaisi, Iwate, Japan",
   type:"T",
   latitude:"39.2667",
   longitude:"141.9"}
  ,
  {name:"Seabreeze Point, British Columbia (2)",
   type:"T",
   latitude:"53.9833",
   longitude:"-130.1833"}
  ,
  {name:"Corner Brook, Newfoundland",
   type:"T",
   latitude:"48.95",
   longitude:"-57.95"}
  ,
  {name:"Buffalo Bluff, St. Johns River, Florida",
   type:"T",
   latitude:"29.595",
   longitude:"-81.6817"}
  ,
  {name:"Esbjerg, Denmark",
   type:"T",
   latitude:"55.4833",
   longitude:"8.4667"}
  ,
  {name:"Wrightsville Beach, North Carolina",
   type:"T",
   latitude:"34.21",
   longitude:"-77.795"}
  ,
  {name:"Godthåb, Greenland (2)",
   type:"T",
   latitude:"64.1833",
   longitude:"-51.75"}
  ,
  {name:"Chesapeake Beach, Maryland",
   type:"T",
   latitude:"38.6833",
   longitude:"-76.5333"}
  ,
  {name:"Sandy Hook, New Jersey (2) (expired 1994-12-31)",
   type:"T",
   latitude:"40.4683",
   longitude:"-74.0117"}
  ,
  {name:"Troup Passage, British Columbia (2)",
   type:"T",
   latitude:"52.25",
   longitude:"-128.0333"}
  ,
  {name:"Mio, Wakayama, Japan",
   type:"T",
   latitude:"33.8833",
   longitude:"135.083"}
  ,
  {name:"Hantsport, Nova Scotia (2)",
   type:"T",
   latitude:"45.0667",
   longitude:"-64.1667"}
  ,
  {name:"Billygoat Bay, British Columbia",
   type:"T",
   latitude:"50.4",
   longitude:"-125.8667"}
  ,
  {name:"Cape Jones Island, Nunavut",
   type:"T",
   latitude:"54.6",
   longitude:"-79.7833"}
  ,
  {name:"Dieppe, France",
   type:"T",
   latitude:"49.9333",
   longitude:"1.0833"}
  ,
  {name:"Port Alberni, British Columbia (2)",
   type:"T",
   latitude:"49.2333",
   longitude:"-124.8167"}
  ,
  {name:"La Have Bank, Nova Scotia",
   type:"T",
   latitude:"42.9",
   longitude:"-64.2333"}
  ,
  {name:"Suminoe, Saga, Japan",
   type:"T",
   latitude:"33.2",
   longitude:"130.2"}
  ,
  {name:"Bath, Kennebec River, Maine",
   type:"T",
   latitude:"43.9183",
   longitude:"-69.8133"}
  ,
  {name:"Redcliff, Australia",
   type:"T",
   latitude:"-32.7333",
   longitude:"137.8167"}
  ,
  {name:"Grande-Rivière, Québec",
   type:"T",
   latitude:"48.4",
   longitude:"-64.5"}
  ,
  {name:"Katakami, Okayama, Japan",
   type:"T",
   latitude:"34.7333",
   longitude:"134.217"}
  ,
  {name:"Tomari, Aomori, Japan",
   type:"T",
   latitude:"41.1",
   longitude:"141.383"}
  ,
  {name:"Innetalling Island, Nunavut",
   type:"T",
   latitude:"55.9",
   longitude:"-79.0667"}
  ,
  {name:"Lucinda, Australia",
   type:"T",
   latitude:"-18.5167",
   longitude:"146.3333"}
  ,
  {name:"Hell Gate (East River), New York Current",
   type:"C",
   latitude:"40.7833",
   longitude:"-73.9333"}
  ,
  {name:"Santa Cruz, Flores, Azores",
   type:"T",
   latitude:"39.45",
   longitude:"-31.1333"}
  ,
  {name:"Pender Point, Australia",
   type:"T",
   latitude:"-15.2833",
   longitude:"128.0833"}
  ,
  {name:"Murotu (Kaminoseki), Yamaguti, Japan",
   type:"T",
   latitude:"33.8333",
   longitude:"132.117"}
  ,
  {name:"Þingeyri, Iceland",
   type:"T",
   latitude:"65.8666",
   longitude:"-23.4833"}
  ,
  {name:"Cape Hooper, Baffin Island, Nunavut",
   type:"T",
   latitude:"68.3833",
   longitude:"-66.75"}
  ,
  {name:"Juskatla, British Columbia (2)",
   type:"T",
   latitude:"53.6167",
   longitude:"-132.3"}
  ,
  {name:"Makwaziniht Island, British Columbia (2)",
   type:"T",
   latitude:"50.55",
   longitude:"-127.55"}
  ,
  {name:"Oak Bluffs, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.4583",
   longitude:"-70.555"}
  ,
  {name:"Section Cove, British Columbia (2)",
   type:"T",
   latitude:"52.4333",
   longitude:"-131.3833"}
  ,
  {name:"Hell-Ville, Madagascar",
   type:"T",
   latitude:"-13.4",
   longitude:"48.2833"}
  ,
  {name:"Lagoon Cove, British Columbia (2)",
   type:"T",
   latitude:"50.6",
   longitude:"-126.3167"}
  ,
  {name:"Cooktown, Australia (2)",
   type:"T",
   latitude:"-15.4667",
   longitude:"145.25"}
  ,
  {name:"Portsmouth Harbor Entrance, New Hampshire Current",
   type:"C",
   latitude:"43.0667",
   longitude:"-70.7"}
  ,
  {name:"Hukahori, Nagasaki, Japan",
   type:"T",
   latitude:"32.6833",
   longitude:"129.817"}
  ,
  {name:"Kodiak, Women's Bay, Alaska",
   type:"T",
   latitude:"57.7317",
   longitude:"-152.5117"}
  ,
  {name:"Mourilyan Harbour, Australia",
   type:"T",
   latitude:"-17.6",
   longitude:"146.1167"}
  ,
  {name:"Matthew Town, Great Inagua Island, Bahamas",
   type:"T",
   latitude:"20.95",
   longitude:"-73.6833"}
  ,
  {name:"Hawks Nest Anchorage, Turks Islands",
   type:"T",
   latitude:"21.4333",
   longitude:"-71.1167"}
  ,
  {name:"Marín, Spain",
   type:"T",
   latitude:"42.4",
   longitude:"-8.7"}
  ,
  {name:"Montauk, Fort Pond Bay, Long Island Sound, New York",
   type:"T",
   latitude:"41.0483",
   longitude:"-71.96"}
  ,
  {name:"Lowe Point (northeast of), Sasanoa River, Maine Current",
   type:"C",
   latitude:"43.8517",
   longitude:"-69.7217"}
  ,
  {name:"Cape Flattery, Australia",
   type:"T",
   latitude:"-14.95",
   longitude:"145.3333"}
  ,
  {name:"Griffith Harbour, British Columbia (2)",
   type:"T",
   latitude:"53.6",
   longitude:"-130.55"}
  ,
  {name:"Ana Chaves, Ghana",
   type:"T",
   latitude:"0.35",
   longitude:"6.75"}
  ,
  {name:"Matusima (Nagasaki), Nagasaki, Japan",
   type:"T",
   latitude:"32.9333",
   longitude:"129.617"}
  ,
  {name:"Tromsø, Norway",
   type:"T",
   latitude:"69.65",
   longitude:"18.9667"}
  ,
  {name:"Waddington Harbour, British Columbia (2)",
   type:"T",
   latitude:"50.9333",
   longitude:"-124.85"}
  ,
  {name:"Hime Sima, Oita, Japan",
   type:"T",
   latitude:"33.7333",
   longitude:"131.65"}
  ,
  {name:"Djogue, Senegal",
   type:"T",
   latitude:"12.5667",
   longitude:"-16.7333"}
  ,
  {name:"Goods Island, Torres Strait (2)",
   type:"T",
   latitude:"-10.5667",
   longitude:"142.1667"}
  ,
  {name:"Flinders Reef, Coral Sea",
   type:"T",
   latitude:"-17.8667",
   longitude:"148.5667"}
  ,
  {name:"Mururoa Atoll, Tuamotu Archipelago",
   type:"T",
   latitude:"-21.8333",
   longitude:"-138.7833"}
  ,
  {name:"Saganoseki, Oita, Japan",
   type:"T",
   latitude:"33.25",
   longitude:"131.883"}
  ,
  {name:"Veracruz, Veracruz, Mexico",
   type:"T",
   latitude:"19.2017",
   longitude:"-96.1367"}
  ,
  {name:"Coppermine, Nunavut/NWT",
   type:"T",
   latitude:"67.8167",
   longitude:"-115.0833"}
  ,
  {name:"Fundy (Offshore 1), Nova Scotia",
   type:"T",
   latitude:"42.8167",
   longitude:"-63.2167"}
  ,
  {name:"Tasu Sound, British Columbia",
   type:"T",
   latitude:"52.75",
   longitude:"-132.0333"}
  ,
  {name:"Neah Bay, Washington (3)",
   type:"T",
   latitude:"48.3667",
   longitude:"-124.6167"}
  ,
  {name:"Little Cornwallis Island, Nunavut",
   type:"T",
   latitude:"75.35",
   longitude:"-96.8"}
  ,
  {name:"Apalachicola, Apalachicola Bay, Florida (2)",
   type:"T",
   latitude:"29.7233",
   longitude:"-84.98"}
  ,
  {name:"Legaspi, Philippines",
   type:"T",
   latitude:"13.15",
   longitude:"123.75"}
  ,
  {name:"Mattapoisett, Mattapoisett Harbor, Buzzards Bay, Massachusetts",
   type:"T",
   latitude:"41.6567",
   longitude:"-70.8133"}
  ,
  {name:"Wadhams, British Columbia (2)",
   type:"T",
   latitude:"51.5167",
   longitude:"-127.5167"}
  ,
  {name:"Ako (Harima Nada), Hyogo, Japan",
   type:"T",
   latitude:"34.75",
   longitude:"134.367"}
  ,
  {name:"Iwasaki, Aomori, Japan",
   type:"T",
   latitude:"40.5833",
   longitude:"139.9"}
  ,
  {name:"Karatu, Saga, Japan",
   type:"T",
   latitude:"33.4667",
   longitude:"129.967"}
  ,
  {name:"Cape Bowling Green, Australia",
   type:"T",
   latitude:"-19.3167",
   longitude:"147.4167"}
  ,
  {name:"Mina Zayed, U.A.E.",
   type:"T",
   latitude:"24.5167",
   longitude:"54.3833"}
  ,
  {name:"Juneau, Alaska",
   type:"T",
   latitude:"58.2983",
   longitude:"-134.4117"}
  ,
  {name:"Redonda Bay, British Columbia (2)",
   type:"T",
   latitude:"50.2667",
   longitude:"-124.9833"}
  ,
  {name:"Withnell Point, Australia",
   type:"T",
   latitude:"-25.5833",
   longitude:"113.0167"}
  ,
  {name:"Ayamonte, Spain",
   type:"T",
   latitude:"37.2167",
   longitude:"-7.4167"}
  ,
  {name:"Nakura, Nagasaki, Japan",
   type:"T",
   latitude:"33.0667",
   longitude:"129.767"}
  ,
  {name:"Cape Christian, Nunavut",
   type:"T",
   latitude:"70.5167",
   longitude:"-68.2167"}
  ,
  {name:"Mermaid Bay, British Columbia (2)",
   type:"T",
   latitude:"50.4",
   longitude:"-125.1833"}
  ,
  {name:"Garry Island, Nunavut/NWT",
   type:"T",
   latitude:"69.05",
   longitude:"-135.75"}
  ,
  {name:"Niue Island",
   type:"T",
   latitude:"-19.0333",
   longitude:"-169.9167"}
  ,
  {name:"Steventon, Great Exuma Island, Bahamas",
   type:"T",
   latitude:"23.6667",
   longitude:"-75.9667"}
  ,
  {name:"Hopeful Bay, Australia",
   type:"T",
   latitude:"-11.4333",
   longitude:"136.5"}
  ,
  {name:"Preedy Harbour, British Columbia",
   type:"T",
   latitude:"48.9833",
   longitude:"-123.6667"}
  ,
  {name:"Lincoln Bay, Nunavut",
   type:"T",
   latitude:"82.1167",
   longitude:"-62.0667"}
  ,
  {name:"Canoe Pass, British Columbia",
   type:"T",
   latitude:"49.2333",
   longitude:"-123.25"}
  ,
  {name:"Chatham (inside), Cape Cod, Massachusetts",
   type:"T",
   latitude:"41.6883",
   longitude:"-69.95"}
  ,
  {name:"Basilaki, Pitt Bay, Papua New Guinea (2)",
   type:"T",
   latitude:"-10.6167",
   longitude:"151.05"}
  ,
  {name:"Canso Harbour, Nova Scotia",
   type:"T",
   latitude:"45.3333",
   longitude:"-61.0"}
  ,
  {name:"Ube, Yamaguti, Japan",
   type:"T",
   latitude:"33.9333",
   longitude:"131.25"}
  ,
  {name:"Five Islands, Nova Scotia",
   type:"T",
   latitude:"45.3833",
   longitude:"-64.1167"}
  ,
  {name:"Erimo, Hokkaido, Japan",
   type:"T",
   latitude:"42.0167",
   longitude:"143.15"}
  ,
  {name:"Erimomisaki, Hokkaido, Japan",
   type:"T",
   latitude:"41.9333",
   longitude:"143.233"}
  ,
  {name:"Hunt Inlet, British Columbia",
   type:"T",
   latitude:"54.0667",
   longitude:"-130.45"}
  ,
  {name:"Pamban (Passe), India",
   type:"T",
   latitude:"9.2667",
   longitude:"79.2"}
  ,
  {name:"Île-Aux-Grues, Québec",
   type:"T",
   latitude:"47.0579",
   longitude:"-70.5453"}
  ,
  {name:"Casablanca, Morocco (3)",
   type:"T",
   latitude:"33.6",
   longitude:"-7.6"}
  ,
  {name:"Niigata, Niigata, Japan (2)",
   type:"T",
   latitude:"37.9333",
   longitude:"139.0667"}
  ,
  {name:"Etang Du Nord, Nova Scotia",
   type:"T",
   latitude:"47.3667",
   longitude:"-61.9667"}
  ,
  {name:"Liverpool Bay, Nunavut/NWT",
   type:"T",
   latitude:"69.7167",
   longitude:"-130.55"}
  ,
  {name:"Desimatu, Yamaguti, Japan",
   type:"T",
   latitude:"33.9167",
   longitude:"130.933"}
  ,
  {name:"Brown Bay, British Columbia",
   type:"T",
   latitude:"50.1667",
   longitude:"-125.3667"}
  ,
  {name:"Topolobampo, Sinaloa, Mexico",
   type:"T",
   latitude:"25.6",
   longitude:"-109.0333"}
  ,
  {name:"Vung Tau, Vietnam",
   type:"T",
   latitude:"10.3333",
   longitude:"107.0667"}
  ,
  {name:"Weipa, Australia (2)",
   type:"T",
   latitude:"-12.6833",
   longitude:"141.05"}
  ,
  {name:"Bell Island, Newfoundland",
   type:"T",
   latitude:"47.6333",
   longitude:"-52.9333"}
  ,
  {name:"Stewart, British Columbia (2)",
   type:"T",
   latitude:"55.9167",
   longitude:"-130.0"}
  ,
  {name:"Neah Bay, Washington (2)",
   type:"T",
   latitude:"48.3667",
   longitude:"-124.6167"}
  ,
  {name:"Puerto Deseado, Argentina",
   type:"T",
   latitude:"-47.75",
   longitude:"-65.9167"}
  ,
  {name:"Hirara, Okinawa, Japan",
   type:"T",
   latitude:"24.8",
   longitude:"125.283"}
  ,
  {name:"Welshpool, Campobello Island, New Brunswick",
   type:"T",
   latitude:"44.8833",
   longitude:"-66.95"}
  ,
  {name:"Bridgeport, Connecticut",
   type:"T",
   latitude:"41.1733",
   longitude:"-73.1817"}
  ,
  {name:"Moffatt Islands, British Columbia",
   type:"T",
   latitude:"54.45",
   longitude:"-130.7333"}
  ,
  {name:"Avilés, Spain",
   type:"T",
   latitude:"43.5833",
   longitude:"-5.9333"}
  ,
  {name:"Chincoteague Channel (south end), Chincoteague Bay, Virgina",
   type:"T",
   latitude:"37.9067",
   longitude:"-75.405"}
  ,
  {name:"Kominato, Aomori, Japan",
   type:"T",
   latitude:"40.95",
   longitude:"140.983"}
  ,
  {name:"Casablanca, Morocco (2)",
   type:"T",
   latitude:"33.6",
   longitude:"-7.6167"}
  ,
  {name:"Cannes, Nova Scotia",
   type:"T",
   latitude:"45.6333",
   longitude:"-60.9667"}
  ,
  {name:"Ship Cove, Newfoundland",
   type:"T",
   latitude:"51.6333",
   longitude:"-55.6333"}
  ,
  {name:"Kamegawa, Oita, Japan",
   type:"T",
   latitude:"33.3333",
   longitude:"131.5"}
  ,
  {name:"Nagahama (Iyo Nada), Ehime, Japan",
   type:"T",
   latitude:"33.6167",
   longitude:"132.483"}
  ,
  {name:"Krubluyak Point, Nunavut/NWT",
   type:"T",
   latitude:"69.5333",
   longitude:"-131.1"}
  ,
  {name:"Kesennuma, Miyagi, Japan",
   type:"T",
   latitude:"38.8833",
   longitude:"141.617"}
  ,
  {name:"Victoria Bluff, South Carolina",
   type:"T",
   latitude:"32.3",
   longitude:"-80.8"}
  ,
  {name:"Robe (offshore), Australia",
   type:"T",
   latitude:"-37.2",
   longitude:"139.5167"}
  ,
  {name:"Tsawwassen, British Columbia",
   type:"T",
   latitude:"49.0",
   longitude:"-123.1333"}
  ,
  {name:"Zaliv Tukharka, Kurile Islands",
   type:"T",
   latitude:"50.1833",
   longitude:"155.65"}
  ,
  {name:"Isle Aux Morts, Newfoundland",
   type:"T",
   latitude:"47.5667",
   longitude:"-58.9667"}
  ,
  {name:"Watch Hill Point, Rhode Island",
   type:"T",
   latitude:"41.305",
   longitude:"-71.86"}
  ,
  {name:"Griffith Harbour, British Columbia",
   type:"T",
   latitude:"53.6",
   longitude:"-130.55"}
  ,
  {name:"Cayenne, French Guiana",
   type:"T",
   latitude:"4.9167",
   longitude:"-52.3333"}
  ,
  {name:"Isachsen, Nunavut/NWT",
   type:"T",
   latitude:"78.7833",
   longitude:"-103.5333"}
  ,
  {name:"Swatow, China",
   type:"T",
   latitude:"23.3333",
   longitude:"116.75"}
  ,
  {name:"Kamo, Yamagata, Japan",
   type:"T",
   latitude:"38.7667",
   longitude:"139.733"}
  ,
  {name:"Reykjavik, Iceland",
   type:"T",
   latitude:"64.15",
   longitude:"-21.85"}
  ,
  {name:"Toi, Hokkaido, Japan",
   type:"T",
   latitude:"41.7167",
   longitude:"141.0"}
  ,
  {name:"Long Key Channel (West), Florida",
   type:"T",
   latitude:"24.7917",
   longitude:"-80.8833"}
  ,
  {name:"Margaree Trailer, Nova Scotia",
   type:"T",
   latitude:"46.4333",
   longitude:"-61.1167"}
  ,
  {name:"Oki-No-Sima, Wakayama, Japan",
   type:"T",
   latitude:"34.2833",
   longitude:"135.017"}
  ,
  {name:"Whangarei, New Zealand",
   type:"T",
   latitude:"-35.7667",
   longitude:"174.35"}
  ,
  {name:"Boonlye Point, Australia",
   type:"T",
   latitude:"-25.5667",
   longitude:"152.9333"}
  ,
  {name:"Manila, Philippines",
   type:"T",
   latitude:"14.5833",
   longitude:"120.9667"}
  ,
  {name:"Mukho, South Korea",
   type:"T",
   latitude:"37.55",
   longitude:"129.1167"}
  ,
  {name:"Gowlland Harbour, British Columbia",
   type:"T",
   latitude:"50.0667",
   longitude:"-125.2333"}
  ,
  {name:"Eastmain, Québec (2)",
   type:"T",
   latitude:"52.0167",
   longitude:"-78.05"}
  ,
  {name:"Lagos, Portugal",
   type:"T",
   latitude:"37.1",
   longitude:"-8.6667"}
  ,
  {name:"Newcastle, Miramichi River, New Brunswick",
   type:"T",
   latitude:"47.0",
   longitude:"-65.5667"}
  ,
  {name:"Anchorage (Knik Arm), Alaska",
   type:"T",
   latitude:"61.2383",
   longitude:"-149.9167"}
  ,
  {name:"Avon, North Carolina",
   type:"T",
   latitude:"35.3467",
   longitude:"-75.5"}
  ,
  {name:"Yakutat, Yakutat Bay, Alaska",
   type:"T",
   latitude:"59.5483",
   longitude:"-139.735"}
  ,
  {name:"Batemans Bay, Australia",
   type:"T",
   latitude:"-35.7167",
   longitude:"150.2167"}
  ,
  {name:"Tadanoumi, Hirosima, Japan",
   type:"T",
   latitude:"34.3333",
   longitude:"133.0"}
  ,
  {name:"Horta, Azores (2)",
   type:"T",
   latitude:"38.5333",
   longitude:"-28.6167"}
  ,
  {name:"Tomioka (Hukusima), Fukusima, Japan",
   type:"T",
   latitude:"37.3167",
   longitude:"141.033"}
  ,
  {name:"Westport Harbor Entrance, Massachusetts",
   type:"T",
   latitude:"41.5083",
   longitude:"-71.0933"}
  ,
  {name:"Timaru Harbour, New Zealand (2)",
   type:"T",
   latitude:"-44.4",
   longitude:"171.25"}
  ,
  {name:"Great Sound, Ireland Island, Bermuda (2)",
   type:"T",
   latitude:"32.3167",
   longitude:"-64.8333"}
  ,
  {name:"Rio Negro, Argentina",
   type:"T",
   latitude:"-41.0333",
   longitude:"-62.7667"}
  ,
  {name:"North Turtle Islet, Australia",
   type:"T",
   latitude:"-19.9",
   longitude:"118.9"}
  ,
  {name:"Higasi-Agenosyo, Yamaguti, Japan",
   type:"T",
   latitude:"33.9",
   longitude:"132.283"}
  ,
  {name:"Aleksandrovskiy, Russia",
   type:"T",
   latitude:"50.8833",
   longitude:"142.1167"}
  ,
  {name:"Rose Harbour, British Columbia",
   type:"T",
   latitude:"52.15",
   longitude:"-131.0833"}
  ,
  {name:"Kitadomari, Tokusima, Japan",
   type:"T",
   latitude:"34.2333",
   longitude:"134.583"}
  ,
  {name:"Entrance Island, Australia",
   type:"T",
   latitude:"-11.9667",
   longitude:"134.25"}
  ,
  {name:"Yorke Island, British Columbia",
   type:"T",
   latitude:"50.45",
   longitude:"-125.9833"}
  ,
  {name:"Matamoros, Tamaulipas, Mexico",
   type:"T",
   latitude:"25.8833",
   longitude:"-97.5167"}
  ,
  {name:"Sibusi, Kagosima, Japan",
   type:"T",
   latitude:"31.4667",
   longitude:"131.117"}
  ,
  {name:"San Luis Pass, Texas",
   type:"T",
   latitude:"29.095",
   longitude:"-95.1133"}
  ,
  {name:"Pensacola, Florida",
   type:"T",
   latitude:"30.4033",
   longitude:"-87.2133"}
  ,
  {name:"Khyex Point, British Columbia",
   type:"T",
   latitude:"54.2333",
   longitude:"-129.8"}
  ,
  {name:"Shippegan Gully, New Brunswick",
   type:"T",
   latitude:"47.7167",
   longitude:"-64.6667"}
  ,
  {name:"Sweers Island, Australia",
   type:"T",
   latitude:"-17.1167",
   longitude:"139.6333"}
  ,
  {name:"Surabaya, Java, Indonesia",
   type:"T",
   latitude:"-7.2167",
   longitude:"112.7333"}
  ,
  {name:"Port Aransas, Holiday Beach, Texas",
   type:"T",
   latitude:"27.8267",
   longitude:"-97.05"}
  ,
  {name:"Balboa, Panama (2)",
   type:"T",
   latitude:"8.9667",
   longitude:"-79.5667"}
  ,
  {name:"Falmouth, England",
   type:"T",
   latitude:"50.15",
   longitude:"-5.05"}
  ,
  {name:"North Island, Australia",
   type:"T",
   latitude:"-28.3",
   longitude:"113.6"}
  ,
  {name:"Langara Point, British Columbia",
   type:"T",
   latitude:"54.25",
   longitude:"-133.0333"}
  ,
  {name:"Bergh Cove, British Columbia",
   type:"T",
   latitude:"50.5333",
   longitude:"-127.6333"}
  ,
  {name:"Gladstone, Australia (3)",
   type:"T",
   latitude:"-23.8333",
   longitude:"151.25"}
  ,
  {name:"Mongo Passage, Solomon Islands",
   type:"T",
   latitude:"-8.35",
   longitude:"157.8667"}
  ,
  {name:"Da Nang, Vietnam",
   type:"T",
   latitude:"16.1167",
   longitude:"108.2167"}
  ,
  {name:"Katumoto, Nagasaki, Japan",
   type:"T",
   latitude:"33.85",
   longitude:"129.7"}
  ,
  {name:"Cape May, ferry terminal, Delaware Bay, New Jersey (2)",
   type:"T",
   latitude:"38.9683",
   longitude:"-74.96"}
  ,
  {name:"La Unión, El Salvador",
   type:"T",
   latitude:"13.3333",
   longitude:"-87.8167"}
  ,
  {name:"Sattahip, Thailand",
   type:"T",
   latitude:"12.65",
   longitude:"100.8833"}
  ,
  {name:"Ponape Harbor, Caroline Islands",
   type:"T",
   latitude:"6.98",
   longitude:"158.22"}
  ,
  {name:"Gladstone, Australia (2)",
   type:"T",
   latitude:"-23.8333",
   longitude:"151.75"}
  ,
  {name:"Dundee, Scotland",
   type:"T",
   latitude:"56.4667",
   longitude:"-2.95"}
  ,
  {name:"U.S. Naval Academy, Annapolis, Maryland",
   type:"T",
   latitude:"38.9833",
   longitude:"-76.48"}
  ,
  {name:"Madre de Deus, Brazil",
   type:"T",
   latitude:"-9.6833",
   longitude:"-35.7167"}
  ,
  {name:"Refuge Bay, British Columbia",
   type:"T",
   latitude:"54.05",
   longitude:"-130.5333"}
  ,
  {name:"Aulatsivik Point, Nunavut",
   type:"T",
   latitude:"66.0167",
   longitude:"-65.6333"}
  ,
  {name:"Sagara, Sizuoka, Japan",
   type:"T",
   latitude:"34.6833",
   longitude:"138.233"}
  ,
  {name:"Trinity, Newfoundland",
   type:"T",
   latitude:"48.3667",
   longitude:"-53.35"}
  ,
  {name:"Tokoname, Aichi, Japan",
   type:"T",
   latitude:"34.8667",
   longitude:"136.833"}
  ,
  {name:"Rabaul, Papua New Guinea",
   type:"T",
   latitude:"-4.2",
   longitude:"152.1833"}
  ,
  {name:"Sepik River, Papua New Guinea",
   type:"T",
   latitude:"-3.85",
   longitude:"144.5667"}
  ,
  {name:"Onizaki, Aichi, Japan",
   type:"T",
   latitude:"34.9",
   longitude:"136.833"}
  ,
  {name:"Townsville, Australia",
   type:"T",
   latitude:"-19.25",
   longitude:"146.8333"}
  ,
  {name:"Barrow Island - Tkr Mrg, Australia",
   type:"T",
   latitude:"-20.8167",
   longitude:"115.55"}
  ,
  {name:"Camp Point, Australia",
   type:"T",
   latitude:"-11.6",
   longitude:"131.4667"}
  ,
  {name:"Aonae, Hokkaido, Japan",
   type:"T",
   latitude:"42.0667",
   longitude:"139.45"}
  ,
  {name:"Minami Izu-Koine, Sizuoka, Japan",
   type:"T",
   latitude:"34.6167",
   longitude:"138.883"}
  ,
  {name:"Yuya, Yamaguti, Japan",
   type:"T",
   latitude:"34.4",
   longitude:"130.95"}
  ,
  {name:"Kieta Harbour, Solomon Islands",
   type:"T",
   latitude:"-6.2",
   longitude:"155.6333"}
  ,
  {name:"Port Hedland, Australia",
   type:"T",
   latitude:"-20.3",
   longitude:"118.5833"}
  ,
  {name:"Bungana Island, Solomon Islands",
   type:"T",
   latitude:"-9.1833",
   longitude:"160.2167"}
  ,
  {name:"Coatzacoalcos, Veracruz, Mexico",
   type:"T",
   latitude:"18.1483",
   longitude:"-94.4117"}
  ,
  {name:"Nanaimo, British Columbia (2)",
   type:"T",
   latitude:"49.0167",
   longitude:"-123.9333"}
  ,
  {name:"Cambridge Bay, Nunavut/NWT",
   type:"T",
   latitude:"69.1167",
   longitude:"-105.0667"}
  ,
  {name:"Port Renfrew, British Columbia (2)",
   type:"T",
   latitude:"48.55",
   longitude:"-124.4167"}
  ,
  {name:"Langara Island, British Columbia",
   type:"T",
   latitude:"54.25",
   longitude:"-133.05"}
  ,
  {name:"Marquis Island, Australia",
   type:"T",
   latitude:"-22.3333",
   longitude:"150.45"}
  ,
  {name:"Nakaminato, Ibaraki, Japan",
   type:"T",
   latitude:"36.3333",
   longitude:"140.583"}
  ,
  {name:"Quatsino Narrows, British Columbia Current",
   type:"C",
   latitude:"50.555",
   longitude:"-127.555"}
  ,
  {name:"Back Bay, Letite Harbour, New Brunswick",
   type:"T",
   latitude:"45.05",
   longitude:"-66.8667"}
  ,
  {name:"Chatham, New Brunswick",
   type:"T",
   latitude:"47.0333",
   longitude:"-65.4667"}
  ,
  {name:"Qingdao, China",
   type:"T",
   latitude:"36.0833",
   longitude:"120.3"}
  ,
  {name:"Mawari, Nagasaki, Japan",
   type:"T",
   latitude:"34.3667",
   longitude:"129.25"}
  ,
  {name:"Salina Cruz, Oaxaca, Mexico",
   type:"T",
   latitude:"16.16",
   longitude:"-95.2033"}
  ,
  {name:"Blind Channel, British Columbia (2)",
   type:"T",
   latitude:"50.4167",
   longitude:"-125.05"}
  ,
  {name:"Port Lavaca, Matagorda Bay, Texas",
   type:"T",
   latitude:"28.65",
   longitude:"-96.595"}
  ,
  {name:"Paulatuk, Nunavut/NWT",
   type:"T",
   latitude:"69.35",
   longitude:"-124.0667"}
  ,
  {name:"Hamelin Bay, Australia",
   type:"T",
   latitude:"-34.1833",
   longitude:"115.0333"}
  ,
  {name:"Belleville, Passaic River, New Jersey",
   type:"T",
   latitude:"40.7767",
   longitude:"-74.1517"}
  ,
  {name:"Stuart Narrows, British Columbia",
   type:"T",
   latitude:"50.9",
   longitude:"-126.9"}
  ,
  {name:"Yosinohama, Kurile Islands",
   type:"T",
   latitude:"46.2",
   longitude:"150.517"}
  ,
  {name:"Berkeley, California",
   type:"T",
   latitude:"37.8667",
   longitude:"-122.3"}
  ,
  {name:"Richibucto Cape, New Brunswick",
   type:"T",
   latitude:"46.0667",
   longitude:"-64.7"}
  ,
  {name:"San Diego, California",
   type:"T",
   latitude:"32.7133",
   longitude:"-117.1733"}
  ,
  {name:"Basking Island, Québec",
   type:"T",
   latitude:"59.9833",
   longitude:"-70.0833"}
  ,
  {name:"Hannibal Island, Australia",
   type:"T",
   latitude:"-11.6",
   longitude:"142.9333"}
  ,
  {name:"Merauke, Irian Jaya, Indonesia (2)",
   type:"T",
   latitude:"-8.5333",
   longitude:"140.3333"}
  ,
  {name:"Bailey's Landing, Okatee Wharf, South Carolina",
   type:"T",
   latitude:"32.3467",
   longitude:"-80.89"}
  ,
  {name:"Fort George Island, Fort George River, Florida (2)",
   type:"T",
   latitude:"30.44",
   longitude:"-81.4383"}
  ,
  {name:"Pointe Basse, Nova Scotia",
   type:"T",
   latitude:"47.3833",
   longitude:"-61.7833"}
  ,
  {name:"Margretsville, Nova Scotia",
   type:"T",
   latitude:"45.05",
   longitude:"-65.0667"}
  ,
  {name:"Burge Point, Australia",
   type:"T",
   latitude:"-12.5833",
   longitude:"130.5667"}
  ,
  {name:"Gloucester Harbor (Ten Pound Island), Massachusetts",
   type:"T",
   latitude:"42.6033",
   longitude:"-70.665"}
  ,
  {name:"Rio Grande, Brazil",
   type:"T",
   latitude:"-32.1333",
   longitude:"-52.1"}
  ,
  {name:"Heath Point, Québec",
   type:"T",
   latitude:"49.0833",
   longitude:"-61.7"}
  ,
  {name:"Dublin, Ireland",
   type:"T",
   latitude:"53.35",
   longitude:"-6.2167"}
  ,
  {name:"Samarai Island, Papua New Guinea (2)",
   type:"T",
   latitude:"-10.6167",
   longitude:"150.6667"}
  ,
  {name:"Longbranch (USCOE dredge depot), Florida",
   type:"T",
   latitude:"30.36",
   longitude:"-81.62"}
  ,
  {name:"Albany, New York",
   type:"T",
   latitude:"42.65",
   longitude:"-73.7467"}
  ,
  {name:"Fermeuse, Newfoundland",
   type:"T",
   latitude:"46.9667",
   longitude:"-52.9667"}
  ,
  {name:"Tulear, Madagascar",
   type:"T",
   latitude:"-23.3833",
   longitude:"43.6667"}
  ,
  {name:"Seavey Island, disputed waters, New England",
   type:"T",
   latitude:"43.0833",
   longitude:"-70.7317"}
  ,
  {name:"Delaware Bay Entrance, Delaware Current (2)",
   type:"C",
   latitude:"38.7817",
   longitude:"-75.0433"}
  ,
  {name:"Aberdeen, Washington (2) (expired 1993-12-31)",
   type:"T",
   latitude:"46.9667",
   longitude:"-123.8533"}
  ,
  {name:"Sir Chas Hardy Island, Australia",
   type:"T",
   latitude:"-11.9167",
   longitude:"143.4667"}
  ,
  {name:"St-Irénée, Québec",
   type:"T",
   latitude:"47.5167",
   longitude:"-70.0167"}
  ,
  {name:"Hall Point, Australia",
   type:"T",
   latitude:"-15.6667",
   longitude:"124.4"}
  ,
  {name:"Maisaka, Sizuoka, Japan",
   type:"T",
   latitude:"34.6833",
   longitude:"137.617"}
  ,
  {name:"Gorge (Victoria), British Columbia",
   type:"T",
   latitude:"48.45",
   longitude:"-123.4167"}
  ,
  {name:"Tuiyama, Hyogo, Japan",
   type:"T",
   latitude:"35.65",
   longitude:"134.833"}
  ,
  {name:"Wood Island, Prince Edward Island",
   type:"T",
   latitude:"45.95",
   longitude:"-62.7333"}
  ,
  {name:"Ecum Secum, Nova Scotia",
   type:"T",
   latitude:"44.9667",
   longitude:"-62.1333"}
  ,
  {name:"Port Chicago, Suisun Bay, California (2) (expired 1996-12-31)",
   type:"T",
   latitude:"38.0567",
   longitude:"-122.0383"}
  ,
  {name:"Sachs Harbour, Nunavut/NWT",
   type:"T",
   latitude:"71.9667",
   longitude:"-125.25"}
  ,
  {name:"Becher Bay, Washington",
   type:"T",
   latitude:"48.0333",
   longitude:"-123.6333"}
  ,
  {name:"Obatake, Yamaguti, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"132.167"}
  ,
  {name:"Prince Rupert, British Columbia (2)",
   type:"T",
   latitude:"54.3167",
   longitude:"-130.3333"}
  ,
  {name:"Kumeon Bay, British Columbia",
   type:"T",
   latitude:"54.7167",
   longitude:"-130.2333"}
  ,
  {name:"Coyote Point Marina, San Francisco Bay, California (2)",
   type:"T",
   latitude:"37.6",
   longitude:"-122.3167"}
  ,
  {name:"Sunday Harbour, British Columbia (2)",
   type:"T",
   latitude:"50.7167",
   longitude:"-126.7"}
  ,
  {name:"Astoria (Tongue Point), Oregon",
   type:"T",
   latitude:"46.2083",
   longitude:"-123.7667"}
  ,
  {name:"Husiki, Toyama, Japan",
   type:"T",
   latitude:"36.7833",
   longitude:"137.067"}
  ,
  {name:"Ocean Falls, British Columbia",
   type:"T",
   latitude:"52.35",
   longitude:"-127.6833"}
  ,
  {name:"Pim Island, Nunavut",
   type:"T",
   latitude:"78.0667",
   longitude:"-74.0167"}
  ,
  {name:"Lower Neguac, New Brunswick",
   type:"T",
   latitude:"47.2667",
   longitude:"-65.0667"}
  ,
  {name:"Pointe des Galets, Reunion",
   type:"T",
   latitude:"-20.9167",
   longitude:"55.2833"}
  ,
  {name:"Sand Point, Nova Scotia",
   type:"T",
   latitude:"45.5167",
   longitude:"-61.2667"}
  ,
  {name:"Souris, Prince Edward Island",
   type:"T",
   latitude:"46.35",
   longitude:"-62.25"}
  ,
  {name:"Mould Bay, Nunavut/NWT",
   type:"T",
   latitude:"76.2833",
   longitude:"-119.4667"}
  ,
  {name:"Tyohu, Yamaguti, Japan",
   type:"T",
   latitude:"34.0167",
   longitude:"131.0"}
  ,
  {name:"Dubayy, U.A.E.",
   type:"T",
   latitude:"25.2667",
   longitude:"55.2833"}
  ,
  {name:"Cap Boujdour, Western Sahara",
   type:"T",
   latitude:"26.1167",
   longitude:"-14.5"}
  ,
  {name:"Cebu, Philippines",
   type:"T",
   latitude:"10.3",
   longitude:"123.9"}
  ,
  {name:"Hobart, Tasmania (2)",
   type:"T",
   latitude:"-42.8833",
   longitude:"147.3333"}
  ,
  {name:"Point No Point, British Columbia (2)",
   type:"T",
   latitude:"48.4",
   longitude:"-123.9667"}
  ,
  {name:"Modo Ura, Nagasaki, Japan",
   type:"T",
   latitude:"34.3",
   longitude:"129.383"}
  ,
  {name:"Mc Donald Point, New Brunswick",
   type:"T",
   latitude:"45.7167",
   longitude:"-66.05"}
  ,
  {name:"Point No Point, British Columbia",
   type:"T",
   latitude:"48.4",
   longitude:"-123.9667"}
  ,
  {name:"Brisbane Bar, Australia",
   type:"T",
   latitude:"-27.3667",
   longitude:"153.1667"}
  ,
  {name:"Hunagawa, Akita, Japan",
   type:"T",
   latitude:"39.8833",
   longitude:"139.85"}
  ,
  {name:"Launceston, Tasmania",
   type:"T",
   latitude:"-41.4333",
   longitude:"147.1333"}
  ,
  {name:"Kwinitsa Creek, British Columbia",
   type:"T",
   latitude:"54.2167",
   longitude:"-129.5833"}
  ,
  {name:"Reedy Point, Delaware (2) (expired 1994-12-31)",
   type:"T",
   latitude:"39.5617",
   longitude:"-75.5667"}
  ,
  {name:"Stanley Harbor, Falkland Islands",
   type:"T",
   latitude:"-51.7",
   longitude:"-57.85"}
  ,
  {name:"Wallops Island, Virginia",
   type:"T",
   latitude:"37.8417",
   longitude:"-75.4783"}
  ,
  {name:"Cape Whiskey, Australia",
   type:"T",
   latitude:"-14.1667",
   longitude:"127.65"}
  ,
  {name:"Lorneville, New Brunswick",
   type:"T",
   latitude:"45.2",
   longitude:"-66.15"}
  ,
  {name:"Enoura (Mekari Seto), Hirosima, Japan",
   type:"T",
   latitude:"34.35",
   longitude:"133.2"}
  ,
  {name:"Napier Broome Bay, Australia",
   type:"T",
   latitude:"-14.1",
   longitude:"126.7"}
  ,
  {name:"Byam Channel (Lp), Nunavut",
   type:"T",
   latitude:"75.0167",
   longitude:"-106.3667"}
  ,
  {name:"Me Sima, Nagasaki, Japan",
   type:"T",
   latitude:"32.0",
   longitude:"128.35"}
  ,
  {name:"Parkers Cove, Nova Scotia",
   type:"T",
   latitude:"44.8",
   longitude:"-65.5333"}
  ,
  {name:"Maizuru (Nisi Ko), Kyoto, Japan",
   type:"T",
   latitude:"35.45",
   longitude:"135.317"}
  ,
  {name:"Kanezaki, Hukuoka, Japan",
   type:"T",
   latitude:"33.8833",
   longitude:"130.533"}
  ,
  {name:"Hukui, Hukui, Japan",
   type:"T",
   latitude:"36.2",
   longitude:"136.133"}
  ,
  {name:"Obbia, Somalia",
   type:"T",
   latitude:"5.3333",
   longitude:"48.5"}
  ,
  {name:"Kean Point, Nunavut",
   type:"T",
   latitude:"68.95",
   longitude:"-102.3667"}
  ,
  {name:"Boca Grande Pass, Charlotte Harbor, Florida Current",
   type:"C",
   latitude:"26.715",
   longitude:"-82.2567"}
  ,
  {name:"Old Tampa Bay Entrance (Port Tampa), Florida Current",
   type:"C",
   latitude:"27.865",
   longitude:"-82.5533"}
  ,
  {name:"Troup Passage, British Columbia",
   type:"T",
   latitude:"52.2333",
   longitude:"-128.0333"}
  ,
  {name:"Mtwara, Tanzania",
   type:"T",
   latitude:"-10.2667",
   longitude:"40.2"}
  ,
  {name:"Port Adelaide, Australia",
   type:"T",
   latitude:"-34.8",
   longitude:"138.4667"}
  ,
  {name:"Tweed River, Australia",
   type:"T",
   latitude:"-28.1667",
   longitude:"153.55"}
  ,
  {name:"North Head, New Brunswick",
   type:"T",
   latitude:"44.7667",
   longitude:"-66.75"}
  ,
  {name:"Point Ybel (0.4 Mi. NW of), Florida Current",
   type:"C",
   latitude:"26.4567",
   longitude:"-82.0183"}
  ,
  {name:"St. Johns River at Dames Point (N. end, SR 9A bridge), Florida",
   type:"T",
   latitude:"30.3869",
   longitude:"-81.5581"}
  ,
  {name:"Hell Gate, Nunavut",
   type:"T",
   latitude:"76.9",
   longitude:"-89.4167"}
  ,
  {name:"Bahía Magdalena, Baja California Sur, Mexico",
   type:"T",
   latitude:"24.6333",
   longitude:"-112.15"}
  ,
  {name:"Isla Socorro, Revillagigedo Islands, Mexico",
   type:"T",
   latitude:"18.7317",
   longitude:"-111.02"}
  ,
  {name:"Jazireh-ye Khark, Iran",
   type:"T",
   latitude:"29.2667",
   longitude:"50.3333"}
  ,
  {name:"Brooklyn, New York",
   type:"T",
   latitude:"40.6833",
   longitude:"-74.0167"}
  ,
  {name:"Utu, Yamaguti, Japan",
   type:"T",
   latitude:"34.7833",
   longitude:"131.15"}
  ,
  {name:"Yura (Kii Suido), Wakayama, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"135.117"}
  ,
  {name:"Veraval, India",
   type:"T",
   latitude:"20.9",
   longitude:"70.3667"}
  ,
  {name:"Roscoff, France",
   type:"T",
   latitude:"48.7167",
   longitude:"-3.9667"}
  ,
  {name:"Ascension Island",
   type:"T",
   latitude:"-7.9167",
   longitude:"-14.4167"}
  ,
  {name:"Ocracoke, Ocracoke Island, North Carolina",
   type:"T",
   latitude:"35.115",
   longitude:"-75.9883"}
  ,
  {name:"Wedgeport, Nova Scotia",
   type:"T",
   latitude:"43.7333",
   longitude:"-65.9833"}
  ,
  {name:"Refuge Harbour, Nunavut",
   type:"T",
   latitude:"70.8667",
   longitude:"-71.0167"}
  ,
  {name:"Bodø, Norway",
   type:"T",
   latitude:"67.2833",
   longitude:"14.3833"}
  ,
  {name:"Esperance, Australia",
   type:"T",
   latitude:"-33.8667",
   longitude:"121.9"}
  ,
  {name:"Botany Bay, Australia (2)",
   type:"T",
   latitude:"-34.0167",
   longitude:"151.1333"}
  ,
  {name:"Fulford Harbour, British Columbia",
   type:"T",
   latitude:"48.7667",
   longitude:"-123.45"}
  ,
  {name:"St. Johns River at Navy degaussing structure, Florida",
   type:"T",
   latitude:"30.3964",
   longitude:"-81.3953"}
  ,
  {name:"Sekinehama, Aomori, Japan",
   type:"T",
   latitude:"41.3667",
   longitude:"141.233"}
  ,
  {name:"Second Narrows, British Columbia Current",
   type:"C",
   latitude:"49.3",
   longitude:"-123.0167"}
  ,
  {name:"Fort Myers, Florida (2) (expired 1999-03-25)",
   type:"T",
   latitude:"26.6467",
   longitude:"-81.8717"}
  ,
  {name:"Quelimane, Mozambique",
   type:"T",
   latitude:"-17.8833",
   longitude:"36.8833"}
  ,
  {name:"Soroken, Solomon Islands",
   type:"T",
   latitude:"-5.5667",
   longitude:"154.7167"}
  ,
  {name:"Kobui, Hokkaido, Japan",
   type:"T",
   latitude:"41.7667",
   longitude:"141.133"}
  ,
  {name:"Welcome Bay, British Columbia",
   type:"T",
   latitude:"49.7",
   longitude:"-124.55"}
  ,
  {name:"Brentwood Bay, British Columbia (2)",
   type:"T",
   latitude:"48.5833",
   longitude:"-123.4667"}
  ,
  {name:"Uwazima, Ehime, Japan (2)",
   type:"T",
   latitude:"33.2333",
   longitude:"132.55"}
  ,
  {name:"Homer, Alaska",
   type:"T",
   latitude:"59.6",
   longitude:"-151.4167"}
  ,
  {name:"Texada Mines, British Columbia",
   type:"T",
   latitude:"49.7",
   longitude:"-124.55"}
  ,
  {name:"Phoenix Park, Florida",
   type:"T",
   latitude:"30.3833",
   longitude:"-81.6367"}
  ,
  {name:"Spry Harbour, Nova Scotia",
   type:"T",
   latitude:"44.8333",
   longitude:"-62.6167"}
  ,
  {name:"Hudson B (Satellite), Manitoba",
   type:"T",
   latitude:"57.05",
   longitude:"-86.0"}
  ,
  {name:"Portland, Maine (2) (expired 1988-12-31)",
   type:"T",
   latitude:"43.6567",
   longitude:"-70.2467"}
  ,
  {name:"Rockport, Aransas Bay, Texas",
   type:"T",
   latitude:"28.0217",
   longitude:"-97.0467"}
  ,
  {name:"Cape Sheridan, Lincoln Sea, Nunavut",
   type:"T",
   latitude:"82.45",
   longitude:"-61.05"}
  ,
  {name:"Turkey Point, FSU Lab, Florida",
   type:"T",
   latitude:"29.915",
   longitude:"-84.5117"}
  ,
  {name:"Seal Cove, Newfoundland (2)",
   type:"T",
   latitude:"49.7333",
   longitude:"-54.2833"}
  ,
  {name:"La Scie, Newfoundland",
   type:"T",
   latitude:"49.9667",
   longitude:"-55.6"}
  ,
  {name:"Inhambane, Mozambique",
   type:"T",
   latitude:"-23.8667",
   longitude:"35.3833"}
  ,
  {name:"Kagosima, Kagosima, Japan",
   type:"T",
   latitude:"31.6",
   longitude:"130.567"}
  ,
  {name:"Hatteras Inlet, North Carolina",
   type:"T",
   latitude:"35.205",
   longitude:"-75.7033"}
  ,
  {name:"Whitehead (Casp350), Nova Scotia",
   type:"T",
   latitude:"45.2333",
   longitude:"-61.1833"}
  ,
  {name:"Kingscote, Australia",
   type:"T",
   latitude:"-35.6167",
   longitude:"137.6333"}
  ,
  {name:"Saavedra Islands, British Columbia",
   type:"T",
   latitude:"49.6167",
   longitude:"-126.6167"}
  ,
  {name:"Tokuyama, Yamaguti, Japan (2)",
   type:"T",
   latitude:"34.0333",
   longitude:"131.8"}
  ,
  {name:"Québec City, Québec",
   type:"T",
   latitude:"46.8167",
   longitude:"-71.15"}
  ,
  {name:"Malagash, Nova Scotia",
   type:"T",
   latitude:"45.7833",
   longitude:"-63.2833"}
  ,
  {name:"Horta, Azores",
   type:"T",
   latitude:"38.5333",
   longitude:"-28.6167"}
  ,
  {name:"Finnerty Cove, British Columbia (2)",
   type:"T",
   latitude:"48.4667",
   longitude:"-123.3"}
  ,
  {name:"Manzeki-Eastern-Ent., Nagasaki, Japan",
   type:"T",
   latitude:"34.3",
   longitude:"129.367"}
  ,
  {name:"Richmond, California",
   type:"T",
   latitude:"37.9167",
   longitude:"-122.35"}
  ,
  {name:"Pago Pago, American Samoa",
   type:"T",
   latitude:"-14.2783",
   longitude:"-170.6817"}
  ,
  {name:"Kirkenes, Norway",
   type:"T",
   latitude:"69.7333",
   longitude:"30.05"}
  ,
  {name:"Portland Roads, Australia",
   type:"T",
   latitude:"-12.6",
   longitude:"143.4167"}
  ,
  {name:"Takamatu, Kagawa, Japan",
   type:"T",
   latitude:"34.35",
   longitude:"134.05"}
  ,
  {name:"Port Neville, British Columbia (2)",
   type:"T",
   latitude:"50.05",
   longitude:"-126.0833"}
  ,
  {name:"Sidney Bay, British Columbia",
   type:"T",
   latitude:"50.5167",
   longitude:"-125.5833"}
  ,
  {name:"Cape Cod Canal, Buzzards Bay Entrance, Massachusetts",
   type:"T",
   latitude:"41.7417",
   longitude:"-70.6183"}
  ,
  {name:"Mar del Plata, Argentina",
   type:"T",
   latitude:"-38.05",
   longitude:"-57.55"}
  ,
  {name:"Stupart Bay, Québec",
   type:"T",
   latitude:"61.5833",
   longitude:"-71.5333"}
  ,
  {name:"Little Patonga, Australia",
   type:"T",
   latitude:"-33.5667",
   longitude:"151.2667"}
  ,
  {name:"Hunakata, Tiba, Japan",
   type:"T",
   latitude:"35.0333",
   longitude:"139.85"}
  ,
  {name:"Woods Harbour, Nova Scotia",
   type:"T",
   latitude:"43.5333",
   longitude:"-65.7333"}
  ,
  {name:"Akassa, Nigeria",
   type:"T",
   latitude:"4.3167",
   longitude:"6.0667"}
  ,
  {name:"Tacks Beach, Newfoundland",
   type:"T",
   latitude:"47.5833",
   longitude:"-54.2"}
  ,
  {name:"Merauke, Irian Jaya, Indonesia",
   type:"T",
   latitude:"-8.5333",
   longitude:"140.3333"}
  ,
  {name:"Matthews Cove, New Brunswick",
   type:"T",
   latitude:"45.05",
   longitude:"-66.8667"}
  ,
  {name:"Aziro (Hidakatu), Nagasaki, Japan",
   type:"T",
   latitude:"34.65",
   longitude:"129.483"}
  ,
  {name:"Dakar, Senegal",
   type:"T",
   latitude:"14.6667",
   longitude:"-17.4167"}
  ,
  {name:"Walton-on-the-Naze, England",
   type:"T",
   latitude:"51.85",
   longitude:"1.2667"}
  ,
  {name:"Ste-Anne-De-Portneuf, Québec",
   type:"T",
   latitude:"48.6333",
   longitude:"-69.0833"}
  ,
  {name:"Hondo, Kumamoto, Japan",
   type:"T",
   latitude:"32.45",
   longitude:"130.2"}
  ,
  {name:"Halfmoon Bay, British Columbia (2)",
   type:"T",
   latitude:"49.5167",
   longitude:"-123.9167"}
  ,
  {name:"Miminegash, Prince Edward Island",
   type:"T",
   latitude:"46.8833",
   longitude:"-64.2333"}
  ,
  {name:"Welaka, St. Johns River, Florida",
   type:"T",
   latitude:"29.4767",
   longitude:"-81.675"}
  ,
  {name:"West Ste Modeste, Strait of Bell Isle, Labrador",
   type:"T",
   latitude:"51.5833",
   longitude:"-56.7"}
  ,
  {name:"Ra Nong, Thailand",
   type:"T",
   latitude:"9.95",
   longitude:"98.587"}
  ,
  {name:"Rankin Inlet, Nunavut",
   type:"T",
   latitude:"62.8167",
   longitude:"-92.0667"}
  ,
  {name:"London Bridge, England (3)",
   type:"T",
   latitude:"51.5",
   longitude:"-0.0833"}
  ,
  {name:"Nasake Sima, Yamaguti, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"132.467"}
  ,
  {name:"Puerto López, Ecuador",
   type:"T",
   latitude:"-1.5667",
   longitude:"-80.8333"}
  ,
  {name:"Bedwell Harbour, British Columbia (2)",
   type:"T",
   latitude:"48.7333",
   longitude:"-123.2333"}
  ,
  {name:"Little Pottsburg Creek, St. Johns River, Florida (4)",
   type:"T",
   latitude:"30.31",
   longitude:"-81.61"}
  ,
  {name:"Pecks Point, Nova Scotia",
   type:"T",
   latitude:"45.75",
   longitude:"-64.4833"}
  ,
  {name:"Chesnucknuw Creek, British Columbia",
   type:"T",
   latitude:"49.05",
   longitude:"-124.8333"}
  ,
  {name:"Murotu (Awazi Sima), Hyogo, Japan",
   type:"T",
   latitude:"34.5333",
   longitude:"134.867"}
  ,
  {name:"Sutwik Island, West End, Alaska",
   type:"T",
   latitude:"56.54",
   longitude:"-157.3267"}
  ,
  {name:"Siogama-Minatobasi, Miyagi, Japan",
   type:"T",
   latitude:"38.3167",
   longitude:"141.033"}
  ,
  {name:"Tukumi, Oita, Japan",
   type:"T",
   latitude:"33.0667",
   longitude:"131.867"}
  ,
  {name:"Hakodate, Hokkaido, Japan",
   type:"T",
   latitude:"41.7833",
   longitude:"140.717"}
  ,
  {name:"Beaufort, Duke Marine Lab, North Carolina",
   type:"T",
   latitude:"34.72",
   longitude:"-76.67"}
  ,
  {name:"Misima (Hiuti Nada), Ehime, Japan",
   type:"T",
   latitude:"33.9833",
   longitude:"133.55"}
  ,
  {name:"Oma, Aomori, Japan",
   type:"T",
   latitude:"41.5333",
   longitude:"140.9"}
  ,
  {name:"Seal Cove, British Columbia",
   type:"T",
   latitude:"54.3333",
   longitude:"-130.2833"}
  ,
  {name:"Taki, Ishikawa, Japan",
   type:"T",
   latitude:"36.9333",
   longitude:"136.767"}
  ,
  {name:"Kuzi Wan (Osima Kaikyo), Kagosima, Japan",
   type:"T",
   latitude:"28.2333",
   longitude:"129.25"}
  ,
  {name:"Alvarado, Veracruz, Mexico",
   type:"T",
   latitude:"18.77",
   longitude:"-95.765"}
  ,
  {name:"Second Valley, Australia",
   type:"T",
   latitude:"-35.5",
   longitude:"138.2167"}
  ,
  {name:"Squamish, British Columbia",
   type:"T",
   latitude:"49.7",
   longitude:"-123.15"}
  ,
  {name:"Wauwinet (outer shore), Nantucket Island, Massachusetts",
   type:"T",
   latitude:"41.3333",
   longitude:"-70.0"}
  ,
  {name:"Sweeper Cove, Adak Island, Alaska (2) (expired 1988-12-31)",
   type:"T",
   latitude:"51.8633",
   longitude:"-176.6317"}
  ,
  {name:"Nagahama (Hiro Wan), Hirosima, Japan",
   type:"T",
   latitude:"34.2167",
   longitude:"132.617"}
  ,
  {name:"Port Hope Simpson, Labrador",
   type:"T",
   latitude:"52.55",
   longitude:"-56.3"}
  ,
  {name:"Urangan, Australia",
   type:"T",
   latitude:"-25.2833",
   longitude:"152.9167"}
  ,
  {name:"Ponta Delgada, São Miguel, Azores (2)",
   type:"T",
   latitude:"37.7333",
   longitude:"-25.6667"}
  ,
  {name:"Little Pottsburg Creek, St. Johns River, Florida (3)",
   type:"T",
   latitude:"30.31",
   longitude:"-81.61"}
  ,
  {name:"Aburatu, Miyazaki, Japan",
   type:"T",
   latitude:"31.5833",
   longitude:"131.417"}
  ,
  {name:"London Bridge, England (2)",
   type:"T",
   latitude:"51.5",
   longitude:"-0.0833"}
  ,
  {name:"Bukhta Blakiston, Kurile Islands",
   type:"T",
   latitude:"49.4833",
   longitude:"154.833"}
  ,
  {name:"Battle Harbour, Labrador",
   type:"T",
   latitude:"52.2667",
   longitude:"-55.6"}
  ,
  {name:"Khyex Point, British Columbia (2)",
   type:"T",
   latitude:"54.2333",
   longitude:"-129.8"}
  ,
  {name:"Naples (outer coast), Florida",
   type:"T",
   latitude:"26.13",
   longitude:"-81.8067"}
  ,
  {name:"Chatham, England",
   type:"T",
   latitude:"51.4",
   longitude:"0.55"}
  ,
  {name:"Oyragjógv, Faroe Islands",
   type:"T",
   latitude:"62.1167",
   longitude:"-7.1667"}
  ,
  {name:"Ceuta, Spain",
   type:"T",
   latitude:"35.8833",
   longitude:"-5.2667"}
  ,
  {name:"Hirosima, Hirosima, Japan (2)",
   type:"T",
   latitude:"34.35",
   longitude:"132.4667"}
  ,
  {name:"Itihara, Tiba, Japan",
   type:"T",
   latitude:"35.5333",
   longitude:"140.117"}
  ,
  {name:"Vancouver, Argentina",
   type:"T",
   latitude:"-54.7833",
   longitude:"-64.0667"}
  ,
  {name:"Mutine Point, British Columbia",
   type:"T",
   latitude:"48.95",
   longitude:"-125.0167"}
  ,
  {name:"Tarumi, Hyogo, Japan",
   type:"T",
   latitude:"34.6167",
   longitude:"135.067"}
  ,
  {name:"Hakata-Hunadamari, Hukuoka, Japan",
   type:"T",
   latitude:"33.6",
   longitude:"130.4"}
  ,
  {name:"Juskatla, British Columbia",
   type:"T",
   latitude:"53.6167",
   longitude:"-132.3"}
  ,
  {name:"Steveston, British Columbia (2)",
   type:"T",
   latitude:"49.1167",
   longitude:"-123.2"}
  ,
  {name:"Tomari Wan, Hokkaido, Japan",
   type:"T",
   latitude:"43.7333",
   longitude:"145.45"}
  ,
  {name:"Coquimbo, Chile",
   type:"T",
   latitude:"-29.9333",
   longitude:"-71.35"}
  ,
  {name:"Porlier Pass, British Columbia",
   type:"T",
   latitude:"49.0167",
   longitude:"-123.5833"}
  ,
  {name:"Tai-No-Ura, Nagasaki, Japan (2)",
   type:"T",
   latitude:"33.0833",
   longitude:"129.75"}
  ,
  {name:"Waddy Point, Australia",
   type:"T",
   latitude:"-24.9667",
   longitude:"153.35"}
  ,
  {name:"Cardenas (Melchor Ocampo), Mexico",
   type:"T",
   latitude:"17.9167",
   longitude:"-102.175"}
  ,
  {name:"São Luís, Brazil",
   type:"T",
   latitude:"-2.5167",
   longitude:"-44.2833"}
  ,
  {name:"Maizuru (Higasi-Ko), Kyoto, Japan",
   type:"T",
   latitude:"35.4833",
   longitude:"135.4"}
  ,
  {name:"Ie-No-Sima, Ehime, Japan",
   type:"T",
   latitude:"34.1",
   longitude:"133.183"}
  ,
  {name:"Sambro Harbour, Nova Scotia",
   type:"T",
   latitude:"44.4833",
   longitude:"-63.6"}
  ,
  {name:"Uoturi Sima, Okinawa, Japan",
   type:"T",
   latitude:"25.7333",
   longitude:"123.467"}
  ,
  {name:"Blacks Harbour, New Brunswick",
   type:"T",
   latitude:"45.05",
   longitude:"-66.8"}
  ,
  {name:"Trail Bay, British Columbia (2)",
   type:"T",
   latitude:"54.5833",
   longitude:"-130.35"}
  ,
  {name:"Port McNeill, British Columbia (2)",
   type:"T",
   latitude:"50.6",
   longitude:"-127.0833"}
  ,
  {name:"Busselton, Australia",
   type:"T",
   latitude:"-33.65",
   longitude:"115.35"}
  ,
  {name:"Little Pottsburg Creek, St. Johns River, Florida (5)",
   type:"T",
   latitude:"30.31",
   longitude:"-81.61"}
  ,
  {name:"Tusket, Nova Scotia",
   type:"T",
   latitude:"43.85",
   longitude:"-65.9833"}
  ,
  {name:"East Repulse Island, Australia (2)",
   type:"T",
   latitude:"-20.5833",
   longitude:"148.8833"}
  ,
  {name:"Breakwater Harbor, Delaware (2) (expired 1983-12-31)",
   type:"T",
   latitude:"38.7817",
   longitude:"-75.12"}
  ,
  {name:"Apia, Samoa Islands (2)",
   type:"T",
   latitude:"-13.8",
   longitude:"-171.7667"}
  ,
  {name:"Lerwick, Shetland Islands, Scotland",
   type:"T",
   latitude:"60.15",
   longitude:"-1.1333"}
  ,
  {name:"Clyde River, Nunavut",
   type:"T",
   latitude:"69.0833",
   longitude:"-70.3667"}
  ,
  {name:"Ft. George River (Loon Point), Québec",
   type:"T",
   latitude:"53.85",
   longitude:"-79.05"}
  ,
  {name:"Mare Island, Naval Shipyard, California",
   type:"T",
   latitude:"38.07",
   longitude:"-122.25"}
  ,
  {name:"Cape Kakkiviak (Williams Harbour), Labrador",
   type:"T",
   latitude:"60.0",
   longitude:"-64.2667"}
  ,
  {name:"Okeover Inlet, British Columbia",
   type:"T",
   latitude:"49.9833",
   longitude:"-124.7"}
  ,
  {name:"Neah Bay, Washington",
   type:"T",
   latitude:"48.3683",
   longitude:"-124.6167"}
  ,
  {name:"Hamelin Pool, Australia",
   type:"T",
   latitude:"-26.3833",
   longitude:"114.1833"}
  ,
  {name:"Lake Harbour, Nunavut",
   type:"T",
   latitude:"62.85",
   longitude:"-69.8833"}
  ,
  {name:"Azigasawa, Aomori, Japan",
   type:"T",
   latitude:"40.7833",
   longitude:"140.217"}
  ,
  {name:"Moncrief Creek entrance, Trout River, Florida (2)",
   type:"T",
   latitude:"30.3917",
   longitude:"-81.6617"}
  ,
  {name:"Wood Bay, Nunavut/NWT",
   type:"T",
   latitude:"69.75",
   longitude:"-128.75"}
  ,
  {name:"Yokeko Point, British Columbia (2)",
   type:"T",
   latitude:"48.4167",
   longitude:"-122.6167"}
  ,
  {name:"Callao, Peru",
   type:"T",
   latitude:"-12.0333",
   longitude:"-77.15"}
  ,
  {name:"Madang Harbour, Papua New Guinea",
   type:"T",
   latitude:"-5.2167",
   longitude:"145.8"}
  ,
  {name:"Hamilton Island, Nunavut",
   type:"T",
   latitude:"74.2",
   longitude:"-99.0167"}
  ,
  {name:"South Lubec, Maine",
   type:"T",
   latitude:"44.821",
   longitude:"-66.992"}
  ,
  {name:"Swansea, Australia",
   type:"T",
   latitude:"-33.0833",
   longitude:"151.6667"}
  ,
  {name:"Kodiak, Alaska (1) (expired 1993-12-31)",
   type:"T",
   latitude:"57.7883",
   longitude:"-152.4"}
  ,
  {name:"Montmorency, Québec",
   type:"T",
   latitude:"46.8667",
   longitude:"-71.15"}
  ,
  {name:"Surinam River, Surinam",
   type:"T",
   latitude:"6.0",
   longitude:"-55.2333"}
  ,
  {name:"Murotu (Koti), Koti, Japan",
   type:"T",
   latitude:"33.2833",
   longitude:"134.15"}
  ,
  {name:"Xiamen, China",
   type:"T",
   latitude:"24.3833",
   longitude:"118.1667"}
  ,
  {name:"Moruya, Australia",
   type:"T",
   latitude:"-35.9",
   longitude:"150.1167"}
  ,
  {name:"Ooyamanohana, Yamaguti, Japan",
   type:"T",
   latitude:"33.9167",
   longitude:"130.9"}
  ,
  {name:"Ushuaia, Argentina",
   type:"T",
   latitude:"-54.8167",
   longitude:"-68.2167"}
  ,
  {name:"Mayport (ferry dock), Florida",
   type:"T",
   latitude:"30.395",
   longitude:"-81.4317"}
  ,
  {name:"Punta Quilla, Argentina",
   type:"T",
   latitude:"-50.1167",
   longitude:"-68.4167"}
  ,
  {name:"Fundy (Offshore 21), Nova Scotia",
   type:"T",
   latitude:"42.6167",
   longitude:"-64.3667"}
  ,
  {name:"Double Bay, Australia",
   type:"T",
   latitude:"-20.1833",
   longitude:"148.6333"}
  ,
  {name:"Nisi-Oita, Oita, Japan",
   type:"T",
   latitude:"33.25",
   longitude:"131.583"}
  ,
  {name:"Bowen, Australia",
   type:"T",
   latitude:"-20.0167",
   longitude:"148.2167"}
  ,
  {name:"Duncan Bay, British Columbia",
   type:"T",
   latitude:"50.0833",
   longitude:"-125.3"}
  ,
  {name:"Lower Attawaspiskat, Ontario",
   type:"T",
   latitude:"52.9667",
   longitude:"-82.2667"}
  ,
  {name:"Fort Myers, Florida",
   type:"T",
   latitude:"26.6467",
   longitude:"-81.8717"}
  ,
  {name:"Trieste, Italy",
   type:"T",
   latitude:"45.65",
   longitude:"13.7667"}
  ,
  {name:"Saint Helier, Jersey, Channel Islands (2)",
   type:"T",
   latitude:"49.1667",
   longitude:"-2.1"}
  ,
  {name:"Little Pottsburg Creek, St. Johns River, Florida (2)",
   type:"T",
   latitude:"30.31",
   longitude:"-81.61"}
  ,
  {name:"Crofton, British Columbia",
   type:"T",
   latitude:"48.8667",
   longitude:"-123.65"}
  ,
  {name:"Hoden, Okayama, Japan",
   type:"T",
   latitude:"34.5833",
   longitude:"134.1"}
  ,
  {name:"Kagosima, Kagosima, Japan (2)",
   type:"T",
   latitude:"31.6",
   longitude:"130.5667"}
  ,
  {name:"East London, South Africa",
   type:"T",
   latitude:"-33.0333",
   longitude:"27.9167"}
  ,
  {name:"Villa Cisneros, Western Sahara",
   type:"T",
   latitude:"23.3667",
   longitude:"-15.9333"}
  ,
  {name:"Morro Beach, Estero Bay, California",
   type:"T",
   latitude:"35.4",
   longitude:"-120.8667"}
  ,
  {name:"Corta de los Jeronimos, Spain",
   type:"T",
   latitude:"37.1333",
   longitude:"-6.1"}
  ,
  {name:"Matuyama, Ehime, Japan (2)",
   type:"T",
   latitude:"33.8667",
   longitude:"132.7167"}
  ,
  {name:"Bugatti Reef, Australia (2)",
   type:"T",
   latitude:"-20.1",
   longitude:"150.2833"}
  ,
  {name:"San Cristóbal, Galapagos Islands",
   type:"T",
   latitude:"-0.9",
   longitude:"-89.6167"}
  ,
  {name:"Storm Bay, British Columbia (2)",
   type:"T",
   latitude:"49.0667",
   longitude:"-123.8167"}
  ,
  {name:"Comox, British Columbia (2)",
   type:"T",
   latitude:"49.0667",
   longitude:"-124.9333"}
  ,
  {name:"Siziki Wan, Nagasaki, Japan",
   type:"T",
   latitude:"33.2",
   longitude:"129.383"}
  ,
  {name:"Ostrov Atlasova, Kurile Islands",
   type:"T",
   latitude:"50.8333",
   longitude:"155.65"}
  ,
  {name:"Saavedra Islands, British Columbia (2)",
   type:"T",
   latitude:"49.6167",
   longitude:"-126.6167"}
  ,
  {name:"Constantine Harbor, Amchitka, Alaska",
   type:"T",
   latitude:"51.4083",
   longitude:"179.2817"}
  ,
  {name:"Moncrief Creek entrance, Trout River, Florida (3)",
   type:"T",
   latitude:"30.3917",
   longitude:"-81.6617"}
  ,
  {name:"Trout River, Sherwood Forest, Florida",
   type:"T",
   latitude:"30.42",
   longitude:"-81.7283"}
  ,
  {name:"Lynchburg Landing, San Jacinto River, Texas",
   type:"T",
   latitude:"29.765",
   longitude:"-95.0783"}
  ,
  {name:"Old Saybrook Point, Connecticut",
   type:"T",
   latitude:"41.2833",
   longitude:"-72.35"}
  ,
  {name:"Gorge Harbour, British Columbia",
   type:"T",
   latitude:"50.1",
   longitude:"-124.9833"}
  ,
  {name:"Hopewell Cape, New Brunswick",
   type:"T",
   latitude:"45.85",
   longitude:"-64.5833"}
  ,
  {name:"High Island, Australia",
   type:"T",
   latitude:"-17.1667",
   longitude:"146.0167"}
  ,
  {name:"Port Foster, Deception Island, South Shetlands",
   type:"T",
   latitude:"-62.9667",
   longitude:"-60.5667"}
  ,
  {name:"Calais, France",
   type:"T",
   latitude:"50.9667",
   longitude:"1.85"}
  ,
  {name:"Mangalore, India",
   type:"T",
   latitude:"12.85",
   longitude:"74.8333"}
  ,
  {name:"Galway, Ireland (2)",
   type:"T",
   latitude:"53.2667",
   longitude:"-9.05"}
  ,
  {name:"Auckland, New Zealand (2)",
   type:"T",
   latitude:"-36.85",
   longitude:"174.7667"}
  ,
  {name:"Ra's al Mish`ab, Saudi Arabia",
   type:"T",
   latitude:"28.1167",
   longitude:"48.6333"}
  ,
  {name:"Santana, Brazil",
   type:"T",
   latitude:"-0.05",
   longitude:"-51.1667"}
  ,
  {name:"Baie Johan-Beetz, Québec",
   type:"T",
   latitude:"50.2833",
   longitude:"-62.8"}
  ,
  {name:"Saint-Malo, France (2)",
   type:"T",
   latitude:"48.6333",
   longitude:"-2.0333"}
  ,
  {name:"Tu, Mie, Japan",
   type:"T",
   latitude:"34.7167",
   longitude:"136.533"}
  ,
  {name:"Archer River, Australia",
   type:"T",
   latitude:"-13.3333",
   longitude:"141.65"}
  ,
  {name:"Lund, British Columbia (2)",
   type:"T",
   latitude:"49.9833",
   longitude:"-124.7667"}
  ,
  {name:"Deception Bay, Québec",
   type:"T",
   latitude:"62.15",
   longitude:"-74.75"}
  ,
  {name:"Nagoya Ura, Saga, Japan",
   type:"T",
   latitude:"33.5333",
   longitude:"129.867"}
  ,
  {name:"New York, New York (2) (expired 1993-12-31)",
   type:"T",
   latitude:"40.7",
   longitude:"-74.015"}
  ,
  {name:"Salina Cruz, Oaxaca, Mexico (2)",
   type:"T",
   latitude:"16.1667",
   longitude:"-95.2"}
  ,
  {name:"Kamaisi, Iwate, Japan (2)",
   type:"T",
   latitude:"39.2667",
   longitude:"141.9"}
  ,
  {name:"Yamada, Iwate, Japan",
   type:"T",
   latitude:"39.4667",
   longitude:"141.967"}
  ,
  {name:"St-Joseph-De-La-Rive, Québec",
   type:"T",
   latitude:"47.45",
   longitude:"-70.3667"}
  ,
  {name:"Clews Point, Australia",
   type:"T",
   latitude:"-24.0167",
   longitude:"151.75"}
  ,
  {name:"Figueira da Foz, Portugal",
   type:"T",
   latitude:"40.15",
   longitude:"-8.8667"}
  ,
  {name:"Posorja, Ecuador",
   type:"T",
   latitude:"-2.7",
   longitude:"-80.25"}
  ,
  {name:"Newburyport, Merrimack River, Massachusetts",
   type:"T",
   latitude:"42.815",
   longitude:"-70.8733"}
  ,
  {name:"Taeyonp'yong Do, North Korea",
   type:"T",
   latitude:"37.6667",
   longitude:"125.7167"}
  ,
  {name:"Kalbarri, Australia",
   type:"T",
   latitude:"-27.7",
   longitude:"114.1667"}
  ,
  {name:"Port Victoria, Australia",
   type:"T",
   latitude:"-34.5",
   longitude:"137.45"}
  ,
  {name:"Reedy Point, Delaware",
   type:"T",
   latitude:"39.5583",
   longitude:"-75.5733"}
  ,
  {name:"Nisinoomote, Kagosima, Japan",
   type:"T",
   latitude:"30.7333",
   longitude:"131.0"}
  ,
  {name:"St. Asaph Bay, Australia",
   type:"T",
   latitude:"-11.3",
   longitude:"130.4333"}
  ,
  {name:"Qlawdzeet Anchorage, British Columbia",
   type:"T",
   latitude:"54.2167",
   longitude:"-130.7667"}
  ,
  {name:"Silva Bay, British Columbia (2)",
   type:"T",
   latitude:"49.15",
   longitude:"-123.7"}
  ,
  {name:"Long Key Channel (East), Florida",
   type:"T",
   latitude:"24.8033",
   longitude:"-80.85"}
  ,
  {name:"Bagan Datoh, Malaysia",
   type:"T",
   latitude:"4.0",
   longitude:"100.75"}
  ,
  {name:"Rabat, Morocco",
   type:"T",
   latitude:"34.0667",
   longitude:"-6.7667"}
  ,
  {name:"The Race, Long Island Sound, New York Current",
   type:"C",
   latitude:"41.2367",
   longitude:"-72.06"}
  ,
  {name:"Cape Grey, Australia",
   type:"T",
   latitude:"-13.0",
   longitude:"136.65"}
  ,
  {name:"Sable Bank, Nova Scotia",
   type:"T",
   latitude:"43.0833",
   longitude:"-59.95"}
  ,
  {name:"Hoek van Holland, Netherlands (3)",
   type:"T",
   latitude:"51.9833",
   longitude:"4.1167"}
  ,
  {name:"Louiseville, Québec",
   type:"T",
   latitude:"46.2167",
   longitude:"-72.9333"}
  ,
  {name:"Dunkerque, France",
   type:"T",
   latitude:"51.05",
   longitude:"2.3667"}
  ,
  {name:"Griffin Passage, British Columbia",
   type:"T",
   latitude:"52.75",
   longitude:"-128.3667"}
  ,
  {name:"Gethsemani, Québec",
   type:"T",
   latitude:"50.2167",
   longitude:"-60.6833"}
  ,
  {name:"Guinchos Cay, Bahamas",
   type:"T",
   latitude:"22.75",
   longitude:"-78.1167"}
  ,
  {name:"Caloundra Head, Australia",
   type:"T",
   latitude:"-26.8",
   longitude:"153.15"}
  ,
  {name:"Banquereau Bank, Nova Scotia",
   type:"T",
   latitude:"44.5833",
   longitude:"-57.6833"}
  ,
  {name:"Roberts Creek, British Columbia",
   type:"T",
   latitude:"49.4167",
   longitude:"-123.6333"}
  ,
  {name:"Conakry, Guinea",
   type:"T",
   latitude:"9.5",
   longitude:"-13.7167"}
  ,
  {name:"Port Pirie, Australia (2)",
   type:"T",
   latitude:"-33.1667",
   longitude:"138.0167"}
  ,
  {name:"Port Alice, British Columbia (2)",
   type:"T",
   latitude:"50.3833",
   longitude:"-127.45"}
  ,
  {name:"Onahama, Fukusima, Japan",
   type:"T",
   latitude:"36.9333",
   longitude:"140.9"}
  ,
  {name:"Atlantic City (Steel Pier), New Jersey",
   type:"T",
   latitude:"39.355",
   longitude:"-74.4183"}
  ,
  {name:"Ochong Do, South Korea",
   type:"T",
   latitude:"36.1167",
   longitude:"125.9833"}
  ,
  {name:"Jacksonville, Navy Fuel Depot, St. Johns River, Florida",
   type:"T",
   latitude:"30.4",
   longitude:"-81.6267"}
  ,
  {name:"Halifax, Nova Scotia",
   type:"T",
   latitude:"44.6667",
   longitude:"-63.5833"}
  ,
  {name:"North Bimini, Bahamas",
   type:"T",
   latitude:"25.7333",
   longitude:"-79.3"}
  ,
  {name:"Zaliv Kozyrevskogo, Kurile Islands",
   type:"T",
   latitude:"50.7167",
   longitude:"156.2"}
  ,
  {name:"Umm al Hatab, U.A.E.",
   type:"T",
   latitude:"24.2167",
   longitude:"51.8667"}
  ,
  {name:"Pointe de Grave, France",
   type:"T",
   latitude:"45.5667",
   longitude:"-1.0667"}
  ,
  {name:"Hoek van Holland, Netherlands (2)",
   type:"T",
   latitude:"51.9833",
   longitude:"4.1167"}
  ,
  {name:"Santos, Brazil (2)",
   type:"T",
   latitude:"-23.95",
   longitude:"-46.3"}
  ,
  {name:"Iwadate, Akita, Japan",
   type:"T",
   latitude:"40.4",
   longitude:"139.983"}
  ,
  {name:"Puerto Ángel, Oaxaca, Mexico",
   type:"T",
   latitude:"15.65",
   longitude:"-96.4833"}
  ,
  {name:"Saanichton Bay, British Columbia (2)",
   type:"T",
   latitude:"48.6",
   longitude:"-123.3833"}
  ,
  {name:"Matoya, Mie, Japan",
   type:"T",
   latitude:"34.3667",
   longitude:"136.867"}
  ,
  {name:"Gamlagætt, Faroe Islands",
   type:"T",
   latitude:"61.9642",
   longitude:"-6.823"}
  ,
  {name:"Washington Canal, New Jersey",
   type:"T",
   latitude:"40.4717",
   longitude:"-74.3683"}
  ,
  {name:"Korsakov, Russia",
   type:"T",
   latitude:"46.6333",
   longitude:"142.75"}
  ,
  {name:"Yarmouth, Nova Scotia",
   type:"T",
   latitude:"43.8333",
   longitude:"-66.1167"}
  ,
  {name:"Calcasieu Pass, Lighthouse wharf, Louisiana",
   type:"T",
   latitude:"29.7783",
   longitude:"-93.345"}
  ,
  {name:"El Ferrol del Caudillo, Spain",
   type:"T",
   latitude:"43.4667",
   longitude:"-8.2667"}
  ,
  {name:"Black Joke Cove, Labrador",
   type:"T",
   latitude:"52.0167",
   longitude:"-55.8667"}
  ,
  {name:"Turtle Islet, Australia",
   type:"T",
   latitude:"-15.5833",
   longitude:"136.9667"}
  ,
  {name:"O-Tobi Sima, Nagasaki, Japan",
   type:"T",
   latitude:"33.4",
   longitude:"129.783"}
  ,
  {name:"Port Cartier, Québec",
   type:"T",
   latitude:"50.0333",
   longitude:"-66.7833"}
  ,
  {name:"Koluktoo Bay, Nunavut",
   type:"T",
   latitude:"72.1",
   longitude:"-80.7833"}
  ,
  {name:"Tidnish Head, New Brunswick",
   type:"T",
   latitude:"46.0",
   longitude:"-64.0167"}
  ,
  {name:"Sidney, British Columbia (2)",
   type:"T",
   latitude:"48.65",
   longitude:"-123.4"}
  ,
  {name:"Storm Bay, British Columbia",
   type:"T",
   latitude:"49.6667",
   longitude:"-123.75"}
  ,
  {name:"Rigolet, Labrador",
   type:"T",
   latitude:"54.1833",
   longitude:"-58.4333"}
  ,
  {name:"Saint-Louis, Senegal",
   type:"T",
   latitude:"16.0",
   longitude:"-16.5167"}
  ,
  {name:"Adolphus Island, Australia",
   type:"T",
   latitude:"-15.1167",
   longitude:"128.1833"}
  ,
  {name:"Easter Group, Australia",
   type:"T",
   latitude:"-28.7167",
   longitude:"113.7833"}
  ,
  {name:"Etang De L'ouest, Prince Edward Island",
   type:"T",
   latitude:"47.25",
   longitude:"-62.0167"}
  ,
  {name:"Welaka, St. Johns River, Florida (4)",
   type:"T",
   latitude:"29.4767",
   longitude:"-81.675"}
  ,
  {name:"Namu, British Columbia (2)",
   type:"T",
   latitude:"51.8667",
   longitude:"-127.8667"}
  ,
  {name:"Alligator Reef Light, Florida",
   type:"T",
   latitude:"24.85",
   longitude:"-80.6183"}
  ,
  {name:"Lower Escuminac, New Brunswick",
   type:"T",
   latitude:"47.0667",
   longitude:"-64.8833"}
  ,
  {name:"Thomas Point Shoal Light, Maryland",
   type:"T",
   latitude:"38.9",
   longitude:"-76.4333"}
  ,
  {name:"Heart's Content, Newfoundland",
   type:"T",
   latitude:"47.8667",
   longitude:"-53.3667"}
  ,
  {name:"Scots Bay, Nova Scotia",
   type:"T",
   latitude:"45.3167",
   longitude:"-64.4333"}
  ,
  {name:"Sunatu, Hukuoka, Japan",
   type:"T",
   latitude:"33.8833",
   longitude:"130.9"}
  ,
  {name:"Sharp Island, Papua New Guinea",
   type:"T",
   latitude:"-9.25",
   longitude:"152.55"}
  ,
  {name:"Soya Misaki, Hokkaido, Japan",
   type:"T",
   latitude:"45.5167",
   longitude:"141.95"}
  ,
  {name:"Cape Domett, Australia",
   type:"T",
   latitude:"-14.8167",
   longitude:"128.3833"}
  ,
  {name:"Cape Hatteras (fishing pier), North Carolina (2) (expired 1993-08-05)",
   type:"T",
   latitude:"35.2233",
   longitude:"-75.635"}
  ,
  {name:"Wrangell Narrows (off Petersburg), Alaska Current",
   type:"C",
   latitude:"56.8167",
   longitude:"-132.9667"}
  ,
  {name:"Malakal Harbor, Palau Islands, Caroline Islands",
   type:"T",
   latitude:"7.33",
   longitude:"134.47"}
  ,
  {name:"Punta Gorda, Charlotte Harbor, Florida",
   type:"T",
   latitude:"26.9283",
   longitude:"-82.065"}
  ,
  {name:"Ko-No-Ura, Nagasaki, Japan",
   type:"T",
   latitude:"33.2667",
   longitude:"129.083"}
  ,
  {name:"Dipper Harbour West, New Brunswick",
   type:"T",
   latitude:"45.1",
   longitude:"-66.4167"}
  ,
  {name:"Te Iro Bay, South Island, New Zealand",
   type:"T",
   latitude:"-41.2333",
   longitude:"174.1833"}
  ,
  {name:"Ganges Harbour, British Columbia",
   type:"T",
   latitude:"48.85",
   longitude:"-123.5"}
  ,
  {name:"Kawasaki (Siohama Unga), Kanagawa, Japan",
   type:"T",
   latitude:"35.5167",
   longitude:"139.75"}
  ,
  {name:"Pebane, Mozambique",
   type:"T",
   latitude:"-17.2667",
   longitude:"38.1333"}
  ,
  {name:"Port De Boucherville, Nunavut",
   type:"T",
   latitude:"63.25",
   longitude:"-77.4667"}
  ,
  {name:"Tanowaki, Kagosima, Japan",
   type:"T",
   latitude:"30.6833",
   longitude:"131.067"}
  ,
  {name:"Trounce Inlet, British Columbia",
   type:"T",
   latitude:"53.15",
   longitude:"-132.3167"}
  ,
  {name:"Goaribari Island, Papua New Guinea",
   type:"T",
   latitude:"-7.75",
   longitude:"144.2"}
  ,
  {name:"Welaka, St. Johns River, Florida (3)",
   type:"T",
   latitude:"29.4767",
   longitude:"-81.675"}
  ,
  {name:"North Galiano, British Columbia",
   type:"T",
   latitude:"49.0",
   longitude:"-123.5833"}
  ,
  {name:"St. Georges, Newfoundland",
   type:"T",
   latitude:"48.4333",
   longitude:"-58.05"}
  ,
  {name:"Kure, Hirosima, Japan",
   type:"T",
   latitude:"34.2333",
   longitude:"132.55"}
  ,
  {name:"Sunday Harbour, British Columbia",
   type:"T",
   latitude:"50.7167",
   longitude:"-126.7"}
  ,
  {name:"Haysport, British Columbia",
   type:"T",
   latitude:"54.1833",
   longitude:"-130.0"}
  ,
  {name:"São Francisco do Sul, Brazil",
   type:"T",
   latitude:"-26.2333",
   longitude:"-48.6333"}
  ,
  {name:"Campbell River, British Columbia",
   type:"T",
   latitude:"50.0167",
   longitude:"-125.2333"}
  ,
  {name:"Kampong Saom, Cambodia",
   type:"T",
   latitude:"10.6333",
   longitude:"103.4833"}
  ,
  {name:"Resolute, Nunavut",
   type:"T",
   latitude:"74.6833",
   longitude:"-94.9"}
  ,
  {name:"Two Hills Bay, Australia",
   type:"T",
   latitude:"-11.5167",
   longitude:"132.0667"}
  ,
  {name:"Guaymas, Sonora, Mexico (3)",
   type:"T",
   latitude:"27.925",
   longitude:"-110.8917"}
  ,
  {name:"Sand Island, Midway Islands",
   type:"T",
   latitude:"28.2117",
   longitude:"-177.36"}
  ,
  {name:"Akita, Akita, Japan",
   type:"T",
   latitude:"39.75",
   longitude:"140.067"}
  ,
  {name:"Welaka, St. Johns River, Florida (2)",
   type:"T",
   latitude:"29.4767",
   longitude:"-81.675"}
  ,
  {name:"Terneuzen, Netherlands",
   type:"T",
   latitude:"51.3333",
   longitude:"3.8333"}
  ,
  {name:"Abram River, Nova Scotia",
   type:"T",
   latitude:"43.8333",
   longitude:"-65.95"}
  ,
  {name:"Punta Gorda, Venezuela",
   type:"T",
   latitude:"10.1667",
   longitude:"-62.6333"}
  ,
  {name:"Fort Ross, Nunavut (2)",
   type:"T",
   latitude:"72.0167",
   longitude:"-94.2333"}
  ,
  {name:"Aracaju, Brazil",
   type:"T",
   latitude:"-10.9167",
   longitude:"-37.05"}
  ,
  {name:"Shoreham, England",
   type:"T",
   latitude:"50.8333",
   longitude:"-0.25"}
  ,
  {name:"Argentia, Newfoundland",
   type:"T",
   latitude:"47.3",
   longitude:"-53.9833"}
  ,
  {name:"Baltimore (Chesapeake Bay), Maryland",
   type:"T",
   latitude:"39.16",
   longitude:"-76.347"}
  ,
  {name:"Atkinson Point, Nunavut/NWT",
   type:"T",
   latitude:"69.95",
   longitude:"-131.4167"}
  ,
  {name:"Kazi-Ga-Hana, Hukuoka, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"130.967"}
  ,
  {name:"Great Whale River, Québec",
   type:"T",
   latitude:"55.2667",
   longitude:"-77.7667"}
  ,
  {name:"Hunadomari, Hokkaido, Japan",
   type:"T",
   latitude:"45.45",
   longitude:"141.033"}
  ,
  {name:"Mill Bay, British Columbia",
   type:"T",
   latitude:"55.0",
   longitude:"-129.9"}
  ,
  {name:"Guaymas, Sonora, Mexico (2)",
   type:"T",
   latitude:"27.925",
   longitude:"-110.8917"}
  ,
  {name:"Yampi Sound, Australia",
   type:"T",
   latitude:"-16.0833",
   longitude:"123.5833"}
  ,
  {name:"Nova Zembla Island, Nunavut",
   type:"T",
   latitude:"72.2167",
   longitude:"-74.65"}
  ,
  {name:"Botwood, Newfoundland",
   type:"T",
   latitude:"49.1333",
   longitude:"-55.3333"}
  ,
  {name:"Harrington Harbour, Québec (2)",
   type:"T",
   latitude:"50.5",
   longitude:"-59.4833"}
  ,
  {name:"La Coruna, Spain",
   type:"T",
   latitude:"43.3667",
   longitude:"-8.6667"}
  ,
  {name:"Spuyten Duyvil Creek Entrance, Hudson River, New York",
   type:"T",
   latitude:"40.8783",
   longitude:"-73.925"}
  ,
  {name:"Yonago, Tottori, Japan",
   type:"T",
   latitude:"35.4333",
   longitude:"133.317"}
  ,
  {name:"Crowdy Head, Australia",
   type:"T",
   latitude:"-31.8333",
   longitude:"152.75"}
  ,
  {name:"Friday Harbor, San Juan Channel, Washington (2)",
   type:"T",
   latitude:"48.55",
   longitude:"-123.0"}
  ,
  {name:"Hirohata, Hyogo, Japan",
   type:"T",
   latitude:"34.7833",
   longitude:"134.617"}
  ,
  {name:"Cape Grenville, Australia",
   type:"T",
   latitude:"-11.9667",
   longitude:"143.25"}
  ,
  {name:"Figueira da Foz, Portugal (2)",
   type:"T",
   latitude:"40.15",
   longitude:"-8.8667"}
  ,
  {name:"Monterey, Monterey Harbor, California (2)",
   type:"T",
   latitude:"36.605",
   longitude:"-121.8883"}
  ,
  {name:"Fort Chimo, Québec",
   type:"T",
   latitude:"58.1",
   longitude:"-68.3167"}
  ,
  {name:"Butedale, British Columbia (2)",
   type:"T",
   latitude:"53.1667",
   longitude:"-128.7"}
  ,
  {name:"Simayama, Nagasaki, Japan",
   type:"T",
   latitude:"34.3167",
   longitude:"129.317"}
  ,
  {name:"Needle Cove, Nunavut",
   type:"T",
   latitude:"69.1",
   longitude:"-79.0167"}
  ,
  {name:"Jacksonville, Acosta Bridge, Florida (3)",
   type:"T",
   latitude:"30.325",
   longitude:"-81.665"}
  ,
  {name:"Pointe Saint-Pierre, Québec (2)",
   type:"T",
   latitude:"48.6253",
   longitude:"-64.1739"}
  ,
  {name:"Raynor Group, British Columbia",
   type:"T",
   latitude:"50.8833",
   longitude:"-127.2333"}
  ,
  {name:"Petit De Grat, Nova Scotia",
   type:"T",
   latitude:"45.5",
   longitude:"-60.9667"}
  ,
  {name:"Harmac, British Columbia (2)",
   type:"T",
   latitude:"49.1333",
   longitude:"-123.85"}
  ,
  {name:"Mituisi, Hokkaido, Japan",
   type:"T",
   latitude:"42.25",
   longitude:"142.55"}
  ,
  {name:"Wada, Hukui, Japan",
   type:"T",
   latitude:"35.5",
   longitude:"135.583"}
  ,
  {name:"Inverness, Scotland",
   type:"T",
   latitude:"57.5",
   longitude:"-4.25"}
  ,
  {name:"Pictou Island, Nova Scotia",
   type:"T",
   latitude:"45.8",
   longitude:"-62.5833"}
  ,
  {name:"Kitkatla Islands, British Columbia",
   type:"T",
   latitude:"53.8",
   longitude:"-130.35"}
  ,
  {name:"San Salvador (Watling Island), Bahamas",
   type:"T",
   latitude:"24.05",
   longitude:"-74.55"}
  ,
  {name:"Kasari Wan, Kagosima, Japan",
   type:"T",
   latitude:"28.45",
   longitude:"129.65"}
  ,
  {name:"Galveston (Galveston Channel), Texas (2) (expired 1993-12-31)",
   type:"T",
   latitude:"29.3133",
   longitude:"-94.7867"}
  ,
  {name:"Ship Sands Island, Nunavut",
   type:"T",
   latitude:"51.0333",
   longitude:"-80.4333"}
  ,
  {name:"Itozaki, Hirosima, Japan",
   type:"T",
   latitude:"34.3833",
   longitude:"133.117"}
  ,
  {name:"Hackensack, Hackensack River, New Jersey",
   type:"T",
   latitude:"40.89",
   longitude:"-74.0383"}
  ,
  {name:"Hamilton Bank 795, Labrador",
   type:"T",
   latitude:"54.4667",
   longitude:"-55.4333"}
  ,
  {name:"Jacksonville, Acosta Bridge, Florida (4)",
   type:"T",
   latitude:"30.325",
   longitude:"-81.665"}
  ,
  {name:"Cuttyhunk Pond entrance, Buzzards Bay, Massachusetts",
   type:"T",
   latitude:"41.425",
   longitude:"-70.9167"}
  ,
  {name:"Kaga, Simane, Japan",
   type:"T",
   latitude:"35.5667",
   longitude:"133.05"}
  ,
  {name:"Charleston, Oregon",
   type:"T",
   latitude:"43.345",
   longitude:"-124.3217"}
  ,
  {name:"Kubura, Okinawa, Japan",
   type:"T",
   latitude:"24.45",
   longitude:"122.933"}
  ,
  {name:"Islets Perces, Québec",
   type:"T",
   latitude:"46.1167",
   longitude:"-72.95"}
  ,
  {name:"Narvaez Bay, British Columbia (2)",
   type:"T",
   latitude:"48.7667",
   longitude:"-123.1"}
  ,
  {name:"Village Bay, British Columbia",
   type:"T",
   latitude:"48.85",
   longitude:"-123.3167"}
  ,
  {name:"Ladysmith, British Columbia (2)",
   type:"T",
   latitude:"48.9833",
   longitude:"-123.7833"}
  ,
  {name:"Simizu, Sizuoka, Japan (2)",
   type:"T",
   latitude:"35.0167",
   longitude:"138.5"}
  ,
  {name:"Manazuru, Kanagawa, Japan",
   type:"T",
   latitude:"35.15",
   longitude:"139.15"}
  ,
  {name:"Masset, British Columbia",
   type:"T",
   latitude:"54.0",
   longitude:"-132.15"}
  ,
  {name:"Bay Shore, Watchogue Creek Entrance, Long Island, New York",
   type:"T",
   latitude:"40.7167",
   longitude:"-73.24"}
  ,
  {name:"Ulladulla Harbour, Australia",
   type:"T",
   latitude:"-35.3667",
   longitude:"150.5"}
  ,
  {name:"Bermuda Esso Pier, St. Georges, Bermuda",
   type:"T",
   latitude:"32.3733",
   longitude:"-64.7033"}
  ,
  {name:"San Juan, Puerto Rico (2) (expired 1998-12-31)",
   type:"T",
   latitude:"18.4617",
   longitude:"-66.1167"}
  ,
  {name:"Suisyo Sima, Hokkaido, Japan",
   type:"T",
   latitude:"43.4167",
   longitude:"145.9"}
  ,
  {name:"Urago, Simane, Japan",
   type:"T",
   latitude:"36.0833",
   longitude:"133.017"}
  ,
  {name:"Lake Worth Pier, Florida",
   type:"T",
   latitude:"26.6117",
   longitude:"-80.0333"}
  ,
  {name:"Jacksonville, Acosta Bridge, Florida (5)",
   type:"T",
   latitude:"30.7967",
   longitude:"-81.515"}
  ,
  {name:"Sakate (Syodo Sima), Kagawa, Japan (2)",
   type:"T",
   latitude:"34.45",
   longitude:"134.3167"}
  ,
  {name:"Black Creek, S.C.L. RR. bridge, Florida",
   type:"T",
   latitude:"30.08",
   longitude:"-81.7617"}
  ,
  {name:"Bonsecours, Québec",
   type:"T",
   latitude:"47.1333",
   longitude:"-70.3667"}
  ,
  {name:"Sevigny Point, Nunavut",
   type:"T",
   latitude:"69.7833",
   longitude:"-82.1167"}
  ,
  {name:"Mazatlán, Sinaloa, Mexico (2)",
   type:"T",
   latitude:"23.1983",
   longitude:"-106.4217"}
  ,
  {name:"St. Johns, Antigua",
   type:"T",
   latitude:"17.1333",
   longitude:"-61.8667"}
  ,
  {name:"Tannowa, Osaka, Japan",
   type:"T",
   latitude:"34.3333",
   longitude:"135.183"}
  ,
  {name:"Port Pirie, Australia",
   type:"T",
   latitude:"-33.1667",
   longitude:"138.0167"}
  ,
  {name:"Monrovia, Liberia",
   type:"T",
   latitude:"6.3333",
   longitude:"-10.8"}
  ,
  {name:"Sakate (Syodo Sima), Kagawa, Japan",
   type:"T",
   latitude:"34.45",
   longitude:"134.317"}
  ,
  {name:"Taketoyo, Aichi, Japan",
   type:"T",
   latitude:"34.8833",
   longitude:"136.933"}
  ,
  {name:"Arichat, Nova Scotia",
   type:"T",
   latitude:"45.5167",
   longitude:"-61.0333"}
  ,
  {name:"Miyanoura (Nao Sima), Kagawa, Japan",
   type:"T",
   latitude:"34.45",
   longitude:"133.967"}
  ,
  {name:"Surge Narrows, British Columbia Current",
   type:"C",
   latitude:"50.2333",
   longitude:"-125.15"}
  ,
  {name:"Malhado, Brazil",
   type:"T",
   latitude:"-14.7667",
   longitude:"-39.0167"}
  ,
  {name:"Red Bluff, Australia",
   type:"T",
   latitude:"-17.0667",
   longitude:"122.3167"}
  ,
  {name:"Welaka, St. Johns River, Florida (5)",
   type:"T",
   latitude:"29.4767",
   longitude:"-81.675"}
  ,
  {name:"Barry, Wales",
   type:"T",
   latitude:"51.3833",
   longitude:"-3.2667"}
  ,
  {name:"St-Thomas-De-Kent, New Brunswick",
   type:"T",
   latitude:"46.45",
   longitude:"-64.6333"}
  ,
  {name:"Point Lookout, Maryland",
   type:"T",
   latitude:"38.04",
   longitude:"-76.3233"}
  ,
  {name:"North Point, Pier 41, San Francisco Bay, California",
   type:"T",
   latitude:"37.81",
   longitude:"-122.4133"}
  ,
  {name:"Cape Defosse, Nunavut",
   type:"T",
   latitude:"81.2167",
   longitude:"-65.7167"}
  ,
  {name:"Punta Tuna, Puerto Rico",
   type:"T",
   latitude:"17.99",
   longitude:"-65.885"}
  ,
  {name:"Coatzacoalcos, Veracruz, Mexico (2)",
   type:"T",
   latitude:"18.15",
   longitude:"-94.4167"}
  ,
  {name:"Minas Basin (Ray .4), Nova Scotia",
   type:"T",
   latitude:"45.3167",
   longitude:"-64.2"}
  ,
  {name:"Cap-Aux-Meules, Nova Scotia",
   type:"T",
   latitude:"47.3833",
   longitude:"-61.8667"}
  ,
  {name:"Cambridge, Choptank River, Maryland",
   type:"T",
   latitude:"38.5733",
   longitude:"-76.0683"}
  ,
  {name:"Bangkok, Thailand",
   type:"T",
   latitude:"13.4333",
   longitude:"100.6"}
  ,
  {name:"Whyalla, Australia",
   type:"T",
   latitude:"-33.0167",
   longitude:"137.6"}
  ,
  {name:"Impression Bay, Tasmania",
   type:"T",
   latitude:"-43.05",
   longitude:"147.7833"}
  ,
  {name:"Kivitoo, Baffin Island, Nunavut",
   type:"T",
   latitude:"67.9333",
   longitude:"-64.9333"}
  ,
  {name:"Owls Head, Nova Scotia",
   type:"T",
   latitude:"44.5833",
   longitude:"-63.9167"}
  ,
  {name:"Puertecitos, Baja California Norte, Mexico",
   type:"T",
   latitude:"30.35",
   longitude:"-114.6"}
  ,
  {name:"Canoe Cove, Prince Edward Island",
   type:"T",
   latitude:"46.15",
   longitude:"-63.3"}
  ,
  {name:"Pointe Saint-Pierre, Québec",
   type:"T",
   latitude:"48.6333",
   longitude:"-64.1667"}
  ,
  {name:"Little St. Marys River, Florida",
   type:"T",
   latitude:"30.7317",
   longitude:"-81.7267"}
  ,
  {name:"Oki-Kamuro Sima, Yamaguti, Japan",
   type:"T",
   latitude:"33.85",
   longitude:"132.367"}
  ,
  {name:"Blunden Harbour, British Columbia",
   type:"T",
   latitude:"50.9",
   longitude:"-127.2833"}
  ,
  {name:"Havre-St-Pierre, Québec",
   type:"T",
   latitude:"50.2333",
   longitude:"-63.6"}
  ,
  {name:"Kyuquot, British Columbia",
   type:"T",
   latitude:"50.0333",
   longitude:"-127.3667"}
  ,
  {name:"Leroy Bay, British Columbia",
   type:"T",
   latitude:"51.2667",
   longitude:"-127.6833"}
  ,
  {name:"Rottnest Island, Australia",
   type:"T",
   latitude:"-32.0",
   longitude:"115.55"}
  ,
  {name:"La Carraca, Spain",
   type:"T",
   latitude:"36.5",
   longitude:"-6.1833"}
  ,
  {name:"Miojin Hana, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"130.9667"}
  ,
  {name:"Singapore (Horsburgh Lighthouse)",
   type:"T",
   latitude:"1.3333",
   longitude:"104.4"}
  ,
  {name:"West Palm Beach Canal, Florida",
   type:"T",
   latitude:"26.645",
   longitude:"-80.045"}
  ,
  {name:"Norah Island, Nunavut",
   type:"T",
   latitude:"77.0333",
   longitude:"-96.75"}
  ,
  {name:"Tiba Light, Tiba, Japan",
   type:"T",
   latitude:"35.5667",
   longitude:"140.05"}
  ,
  {name:"Ranger Inlet, British Columbia",
   type:"T",
   latitude:"54.8333",
   longitude:"-130.1667"}
  ,
  {name:"Misima, Papua New Guinea",
   type:"T",
   latitude:"-10.7",
   longitude:"152.7833"}
  ,
  {name:"Port Leopold, Nunavut",
   type:"T",
   latitude:"73.0833",
   longitude:"-90.0333"}
  ,
  {name:"San Fernando, Philippines",
   type:"T",
   latitude:"16.6167",
   longitude:"120.3"}
  ,
  {name:"Eiði, Faroe Islands",
   type:"T",
   latitude:"62.2958",
   longitude:"-7.09"}
  ,
  {name:"Bay Du Vin, New Brunswick",
   type:"T",
   latitude:"47.05",
   longitude:"-65.0167"}
  ,
  {name:"Gold Coast Seaway, Australia",
   type:"T",
   latitude:"-27.95",
   longitude:"153.4333"}
  ,
  {name:"Hitati, Ibaraki, Japan",
   type:"T",
   latitude:"36.5",
   longitude:"140.633"}
  ,
  {name:"Wewak, Papua New Guinea",
   type:"T",
   latitude:"-3.55",
   longitude:"143.6333"}
  ,
  {name:"Pusur River, Bangladesh",
   type:"T",
   latitude:"21.7167",
   longitude:"89.55"}
  ,
  {name:"Gamagori, Aichi, Japan",
   type:"T",
   latitude:"34.8167",
   longitude:"137.233"}
  ,
  {name:"Tysoe Point, Nunavut/NWT",
   type:"T",
   latitude:"69.6167",
   longitude:"-120.7833"}
  ,
  {name:"Nayoka, Hokkaido, Japan",
   type:"T",
   latitude:"45.2667",
   longitude:"147.867"}
  ,
  {name:"Clapboard Creek, Pelotes Island, St. Johns River, Florida",
   type:"T",
   latitude:"30.4067",
   longitude:"-81.51"}
  ,
  {name:"Unalaska, Alaska",
   type:"T",
   latitude:"53.88",
   longitude:"-166.5367"}
  ,
  {name:"Block Islands, British Columbia",
   type:"T",
   latitude:"53.15",
   longitude:"-129.7667"}
  ,
  {name:"Prospect, Nova Scotia",
   type:"T",
   latitude:"44.45",
   longitude:"-63.7833"}
  ,
  {name:"Antofagasta, Chile",
   type:"T",
   latitude:"-23.65",
   longitude:"-70.4167"}
  ,
  {name:"House Harbour, Labrador",
   type:"T",
   latitude:"56.2333",
   longitude:"-61.05"}
  ,
  {name:"Isla Socorro, Revillagigedo Islands, Mexico (2)",
   type:"T",
   latitude:"18.7167",
   longitude:"-111.0167"}
  ,
  {name:"Terazu, Aichi, Japan",
   type:"T",
   latitude:"34.8167",
   longitude:"137.0"}
  ,
  {name:"Kearney Point, Passaic River, New Jersey",
   type:"T",
   latitude:"40.7317",
   longitude:"-74.1167"}
  ,
  {name:"Denbigh Island, Labrador",
   type:"T",
   latitude:"52.5333",
   longitude:"-55.8333"}
  ,
  {name:"Blind Bay, British Columbia",
   type:"T",
   latitude:"49.7167",
   longitude:"-124.1833"}
  ,
  {name:"Hagi, Yamaguti, Japan",
   type:"T",
   latitude:"34.4333",
   longitude:"131.417"}
  ,
  {name:"Santa Barbara, California",
   type:"T",
   latitude:"34.4083",
   longitude:"-119.685"}
  ,
  {name:"Port San Luis, California",
   type:"T",
   latitude:"35.1767",
   longitude:"-120.76"}
  ,
  {name:"Zaliv Chikhacheva, Russia",
   type:"T",
   latitude:"51.4333",
   longitude:"140.8667"}
  ,
  {name:"Kasima, Ibaraki, Japan",
   type:"T",
   latitude:"35.9333",
   longitude:"140.7"}
  ,
  {name:"Ozello, St. Martin's River, Florida",
   type:"T",
   latitude:"28.825",
   longitude:"-82.6583"}
  ,
  {name:"Wabasso, Indian River, Florida",
   type:"T",
   latitude:"27.755",
   longitude:"-80.425"}
  ,
  {name:"Bayonne Bridge, Staten Island, New York",
   type:"T",
   latitude:"40.64",
   longitude:"-74.1467"}
  ,
  {name:"North Cat Cay, Bahamas",
   type:"T",
   latitude:"25.55",
   longitude:"-79.2817"}
  ,
  {name:"Lakes Entrance, Australia",
   type:"T",
   latitude:"-37.8833",
   longitude:"147.9667"}
  ,
  {name:"Port Walcott, Australia",
   type:"T",
   latitude:"-20.5833",
   longitude:"117.1833"}
  ,
  {name:"Kokopo, Papua New Guinea",
   type:"T",
   latitude:"-4.35",
   longitude:"152.2833"}
  ,
  {name:"Namu, British Columbia",
   type:"T",
   latitude:"51.8667",
   longitude:"-127.8667"}
  ,
  {name:"Jacksonville, Acosta Bridge, Florida (2)",
   type:"T",
   latitude:"30.325",
   longitude:"-81.665"}
  ,
  {name:"San Diego, California (2)",
   type:"T",
   latitude:"32.717",
   longitude:"-117.167"}
  ,
  {name:"Strait Of Canso Bass, Nova Scotia",
   type:"T",
   latitude:"45.4667",
   longitude:"-61.1833"}
  ,
  {name:"Lowe Inlet, British Columbia",
   type:"T",
   latitude:"53.55",
   longitude:"-129.5833"}
  ,
  {name:"George River (Derived), Québec",
   type:"T",
   latitude:"58.5167",
   longitude:"-66.0"}
  ,
  {name:"Lowe Inlet, British Columbia (2)",
   type:"T",
   latitude:"53.55",
   longitude:"-129.5833"}
  ,
  {name:"Ujung Pandang, Sulawesi, Indonesia",
   type:"T",
   latitude:"-5.15",
   longitude:"119.4"}
  ,
  {name:"Little Pottsburg Creek, St. Johns River, Florida",
   type:"T",
   latitude:"30.31",
   longitude:"-81.61"}
  ,
  {name:"Vopnafjörður, Iceland",
   type:"T",
   latitude:"65.75",
   longitude:"-14.8333"}
  ,
  {name:"Palmetto Bluff, St. Johns River, Florida (2)",
   type:"T",
   latitude:"30.7633",
   longitude:"-81.5617"}
  ,
  {name:"Port Aux Basques, Newfoundland",
   type:"T",
   latitude:"47.5833",
   longitude:"-59.15"}
  ,
  {name:"Florida Bay (West), Florida",
   type:"T",
   latitude:"24.84",
   longitude:"-80.78"}
  ,
  {name:"Newman Bay, Greenland",
   type:"T",
   latitude:"81.9667",
   longitude:"-60.0"}
  ,
  {name:"Sherman Island (East), California Current",
   type:"C",
   latitude:"38.0587",
   longitude:"-121.8"}
  ,
  {name:"Osyoro, Hokkaido, Japan",
   type:"T",
   latitude:"43.2167",
   longitude:"140.85"}
  ,
  {name:"Port Townsend, Washington (3)",
   type:"T",
   latitude:"48.1333",
   longitude:"-122.7667"}
  ,
  {name:"Port St. Francois, Québec",
   type:"T",
   latitude:"46.2667",
   longitude:"-72.6167"}
  ,
  {name:"Miyanoura (Oita), Oita, Japan",
   type:"T",
   latitude:"32.8833",
   longitude:"132.0"}
  ,
  {name:"Coconut Island, Torres Strait",
   type:"T",
   latitude:"-10.05",
   longitude:"143.0667"}
  ,
  {name:"Zaliv Baykal, Russia",
   type:"T",
   latitude:"53.5333",
   longitude:"142.2333"}
  ,
  {name:"Misumi, Kumamoto, Japan",
   type:"T",
   latitude:"32.6167",
   longitude:"130.45"}
  ,
  {name:"Gannet Rock, Nova Scotia",
   type:"T",
   latitude:"44.5167",
   longitude:"-66.7833"}
  ,
  {name:"Trincomalee, Sri Lanka",
   type:"T",
   latitude:"8.55",
   longitude:"81.2167"}
  ,
  {name:"Toba, Mie, Japan",
   type:"T",
   latitude:"34.4833",
   longitude:"136.85"}
  ,
  {name:"Saga (Tusima), Nagasaki, Japan",
   type:"T",
   latitude:"34.45",
   longitude:"129.383"}
  ,
  {name:"Cape Blomidon, Nova Scotia (2)",
   type:"T",
   latitude:"45.2667",
   longitude:"-64.35"}
  ,
  {name:"Dame Point, Florida",
   type:"T",
   latitude:"30.3867",
   longitude:"-81.5583"}
  ,
  {name:"Pearce Point, Australia",
   type:"T",
   latitude:"-14.4333",
   longitude:"129.3667"}
  ,
  {name:"Chignecto (Ray .4), Nova Scotia",
   type:"T",
   latitude:"45.4833",
   longitude:"-64.9833"}
  ,
  {name:"Bella Bella, British Columbia (2)",
   type:"T",
   latitude:"52.1667",
   longitude:"-128.1333"}
  ,
  {name:"Rio de Janeiro, Brazil",
   type:"T",
   latitude:"-22.9",
   longitude:"-43.2"}
  ,
  {name:"Kumeon Bay, British Columbia (2)",
   type:"T",
   latitude:"54.7167",
   longitude:"-130.2333"}
  ,
  {name:"Cape Cliff, Nova Scotia",
   type:"T",
   latitude:"45.8833",
   longitude:"-63.4667"}
  ,
  {name:"Gold River, British Columbia",
   type:"T",
   latitude:"49.6833",
   longitude:"-126.1333"}
  ,
  {name:"Naha, Okinawa, Japan (2)",
   type:"T",
   latitude:"26.2167",
   longitude:"127.667"}
  ,
  {name:"Nueces Bay, Texas",
   type:"T",
   latitude:"27.8233",
   longitude:"-97.415"}
  ,
  {name:"Mitarai, Hirosima, Japan",
   type:"T",
   latitude:"34.1833",
   longitude:"132.867"}
  ,
  {name:"Porto Amelia, Mozambique",
   type:"T",
   latitude:"-12.9667",
   longitude:"40.4833"}
  ,
  {name:"Palmetto Bluff, St. Johns River, Florida (4)",
   type:"T",
   latitude:"29.7633",
   longitude:"-81.5617"}
  ,
  {name:"Bayonne Bridge, Kill van Kull, New York Current (2)",
   type:"C",
   latitude:"40.6417",
   longitude:"-74.1433"}
  ,
  {name:"Tauranga, New Zealand (2)",
   type:"T",
   latitude:"-37.65",
   longitude:"176.1833"}
  ,
  {name:"Nanoose Bay, British Columbia",
   type:"T",
   latitude:"49.2667",
   longitude:"-124.1333"}
  ,
  {name:"Bundaberg, Australia",
   type:"T",
   latitude:"-24.7667",
   longitude:"152.3833"}
  ,
  {name:"Avila, California",
   type:"T",
   latitude:"35.17",
   longitude:"-120.74"}
  ,
  {name:"Oomon, Kumamoto, Japan",
   type:"T",
   latitude:"32.4333",
   longitude:"130.217"}
  ,
  {name:"East Quoddy Head, New Brunswick",
   type:"T",
   latitude:"44.9667",
   longitude:"-66.9"}
  ,
  {name:"Palmetto Bluff, St. Johns River, Florida (5)",
   type:"T",
   latitude:"29.7633",
   longitude:"-81.5617"}
  ,
  {name:"Salinópolis, Brazil",
   type:"T",
   latitude:"-0.6167",
   longitude:"-47.35"}
  ,
  {name:"New London, Connecticut",
   type:"T",
   latitude:"41.355",
   longitude:"-72.0867"}
  ,
  {name:"Port Macquarie, Australia",
   type:"T",
   latitude:"-31.4333",
   longitude:"152.9167"}
  ,
  {name:"Povungnituk, Québec",
   type:"T",
   latitude:"60.0333",
   longitude:"-77.2833"}
  ,
  {name:"Ribault River, Lake Forest, Florida",
   type:"T",
   latitude:"30.3983",
   longitude:"-81.6983"}
  ,
  {name:"Port-au-Prince, Haiti",
   type:"T",
   latitude:"18.55",
   longitude:"-72.35"}
  ,
  {name:"Manzeki-Western-Ent., Nagasaki, Japan",
   type:"T",
   latitude:"34.3",
   longitude:"129.367"}
  ,
  {name:"Titii, Simane, Japan",
   type:"T",
   latitude:"36.0667",
   longitude:"133.117"}
  ,
  {name:"Broughton Island, Nunavut",
   type:"T",
   latitude:"67.5167",
   longitude:"-64.0667"}
  ,
  {name:"Chicoutimi, Québec (2)",
   type:"T",
   latitude:"48.4333",
   longitude:"-71.0833"}
  ,
  {name:"Nakagawara Ura, Kagosima, Japan",
   type:"T",
   latitude:"31.85",
   longitude:"129.85"}
  ,
  {name:"Palmetto Bluff, St. Johns River, Florida (3)",
   type:"T",
   latitude:"29.7633",
   longitude:"-81.5617"}
  ,
  {name:"Saint Helier, Jersey, Channel Islands",
   type:"T",
   latitude:"49.1667",
   longitude:"-2.1"}
  ,
  {name:"Eskimo Lakes Station 2b, Nunavut/NWT",
   type:"T",
   latitude:"69.5667",
   longitude:"-131.4"}
  ,
  {name:"North Rustico, Prince Edward Island (2)",
   type:"T",
   latitude:"46.4667",
   longitude:"-63.2833"}
  ,
  {name:"Prince Rupert, British Columbia",
   type:"T",
   latitude:"54.3167",
   longitude:"-130.3333"}
  ,
  {name:"Thousand Ships Bay, Solomon Islands",
   type:"T",
   latitude:"-8.4333",
   longitude:"159.7"}
  ,
  {name:"Scott Reef, Australia",
   type:"T",
   latitude:"-14.05",
   longitude:"121.8"}
  ,
  {name:"Byam Island, Nunavut",
   type:"T",
   latitude:"75.0167",
   longitude:"-104.2167"}
  ,
  {name:"Uramu Island, Papua New Guinea (2)",
   type:"T",
   latitude:"-7.6667",
   longitude:"144.65"}
  ,
  {name:"Yokkaiti, Mie, Japan",
   type:"T",
   latitude:"34.95",
   longitude:"136.633"}
  ,
  {name:"Puerto Bolívar, Ecuador",
   type:"T",
   latitude:"-3.2667",
   longitude:"-80.0"}
  ,
  {name:"Angra do Heroismo, Terceira, Azores",
   type:"T",
   latitude:"38.65",
   longitude:"-27.2167"}
  ,
  {name:"Inoura, Nagasaki, Japan",
   type:"T",
   latitude:"33.05",
   longitude:"129.75"}
  ,
  {name:"Melbourne, Australia (2)",
   type:"T",
   latitude:"-37.8667",
   longitude:"144.9167"}
  ,
  {name:"Windmill Point, Rappahannock River, Virginia",
   type:"T",
   latitude:"37.6117",
   longitude:"-76.275"}
  ,
  {name:"Sandgerði, Iceland",
   type:"T",
   latitude:"64.0383",
   longitude:"-22.715"}
  ,
  {name:"Edithburgh, Australia",
   type:"T",
   latitude:"-35.0833",
   longitude:"137.75"}
  ,
  {name:"Huelva, Spain",
   type:"T",
   latitude:"37.1333",
   longitude:"-6.8667"}
  ,
  {name:"Kuantan, Malaysia",
   type:"T",
   latitude:"3.8333",
   longitude:"103.3333"}
  ,
  {name:"San Francisco, Pier 22 1/2, California",
   type:"T",
   latitude:"37.79",
   longitude:"-122.3867"}
  ,
  {name:"Harbour Breton, Newfoundland",
   type:"T",
   latitude:"47.4667",
   longitude:"-55.8"}
  ,
  {name:"Cowichan Bay, British Columbia",
   type:"T",
   latitude:"48.7333",
   longitude:"-123.6167"}
  ,
  {name:"Baie Verte, Newfoundland",
   type:"T",
   latitude:"49.95",
   longitude:"-56.1833"}
  ,
  {name:"Mary Ann Haven, Australia",
   type:"T",
   latitude:"-33.95",
   longitude:"120.1167"}
  ,
  {name:"Pasajes, Spain",
   type:"T",
   latitude:"43.3333",
   longitude:"-1.9333"}
  ,
  {name:"Puerto Belgrano, Argentina",
   type:"T",
   latitude:"-38.8833",
   longitude:"-62.1"}
  ,
  {name:"Waretown, Barnegat Bay, New Jersey",
   type:"T",
   latitude:"38.7917",
   longitude:"-74.1817"}
  ,
  {name:"Port Lincoln, Australia (2)",
   type:"T",
   latitude:"-34.7167",
   longitude:"135.8667"}
  ,
  {name:"Washington, D.C.",
   type:"T",
   latitude:"38.8733",
   longitude:"-77.0217"}
  ,
  {name:"Big Bay, British Columbia (2)",
   type:"T",
   latitude:"50.4",
   longitude:"-125.1333"}
  ,
  {name:"Lady Musgrave Island, Australia",
   type:"T",
   latitude:"-23.9",
   longitude:"152.3833"}
  ,
  {name:"Odaito, Hokkaido, Japan",
   type:"T",
   latitude:"43.5667",
   longitude:"145.233"}
  ,
  {name:"Portneuf, Québec",
   type:"T",
   latitude:"46.6833",
   longitude:"-71.8833"}
  ,
  {name:"Okukari Bay, South Island, New Zealand",
   type:"T",
   latitude:"-41.2",
   longitude:"174.3167"}
  ,
  {name:"Seymour Narrows, British Columbia (2)",
   type:"T",
   latitude:"50.1333",
   longitude:"-125.35"}
  ,
  {name:"Bahía Pinas, Panama",
   type:"T",
   latitude:"8.3",
   longitude:"-78.1833"}
  ,
  {name:"Bluffton, South Carolina",
   type:"T",
   latitude:"32.0833",
   longitude:"-80.8667"}
  ,
  {name:"Vancouver, British Columbia",
   type:"T",
   latitude:"49.2833",
   longitude:"-123.1167"}
  ,
  {name:"Itaqui, Brazil",
   type:"T",
   latitude:"-2.5667",
   longitude:"-44.3667"}
  ,
  {name:"Awasima (Bisan Seto), Kagawa, Japan",
   type:"T",
   latitude:"34.2667",
   longitude:"133.633"}
  ,
  {name:"Wadsworth Island, Nunavut",
   type:"T",
   latitude:"73.4333",
   longitude:"-95.6833"}
  ,
  {name:"Abasiri, Hokkaido, Japan",
   type:"T",
   latitude:"44.0167",
   longitude:"144.283"}
  ,
  {name:"Cape Charles Coast Guard Station, Virginia",
   type:"T",
   latitude:"37.2633",
   longitude:"-76.015"}
  ,
  {name:"Duck Key, Hawk Channel, Florida",
   type:"T",
   latitude:"24.765",
   longitude:"-80.9133"}
  ,
  {name:"Hukuyama, Hirosima, Japan",
   type:"T",
   latitude:"34.4833",
   longitude:"133.417"}
  ,
  {name:"Brown Bay, British Columbia (2)",
   type:"T",
   latitude:"50.0167",
   longitude:"-125.3667"}
  ,
  {name:"St. Peters Bay, Prince Edward Island",
   type:"T",
   latitude:"46.4333",
   longitude:"-62.7333"}
  ,
  {name:"Le Petit Pelerin, Québec",
   type:"T",
   latitude:"47.7",
   longitude:"-69.7667"}
  ,
  {name:"Angra do Heroismo, Terceira, Azores (2)",
   type:"T",
   latitude:"38.65",
   longitude:"-27.2167"}
  ,
  {name:"Hamazima, Mie, Japan",
   type:"T",
   latitude:"34.3",
   longitude:"136.767"}
  ,
  {name:"Uppurui Wan, Simane, Japan",
   type:"T",
   latitude:"35.45",
   longitude:"132.75"}
  ,
  {name:"Sand Point, Popof Island, Alaska",
   type:"T",
   latitude:"55.3367",
   longitude:"-160.5017"}
  ,
  {name:"Seattle, Washington",
   type:"T",
   latitude:"47.605",
   longitude:"-122.3383"}
  ,
  {name:"Flat Island, Nova Scotia",
   type:"T",
   latitude:"43.5",
   longitude:"-66.0"}
  ,
  {name:"Rocky Point, Back River, Maryland",
   type:"T",
   latitude:"39.25",
   longitude:"-76.4"}
  ,
  {name:"Kelsey Bay, British Columbia (2)",
   type:"T",
   latitude:"50.4",
   longitude:"-125.9667"}
  ,
  {name:"Belize City, Belize",
   type:"T",
   latitude:"17.5",
   longitude:"-88.1833"}
  ,
  {name:"Cape Wilson 2, Nunavut",
   type:"T",
   latitude:"67.1",
   longitude:"-81.3833"}
  ,
  {name:"Boston, Massachusetts",
   type:"T",
   latitude:"42.355",
   longitude:"-71.0517"}
  ,
  {name:"Portage Island, New Brunswick",
   type:"T",
   latitude:"47.0167",
   longitude:"-65.05"}
  ,
  {name:"Wiah Point, British Columbia",
   type:"T",
   latitude:"54.1167",
   longitude:"-132.3167"}
  ,
  {name:"Masset, British Columbia (2)",
   type:"T",
   latitude:"54.0167",
   longitude:"-132.15"}
  ,
  {name:"Cape Elizabeth, Australia",
   type:"T",
   latitude:"-34.25",
   longitude:"137.3333"}
  ,
  {name:"Port-Alfred, Québec",
   type:"T",
   latitude:"48.3333",
   longitude:"-70.8667"}
  ,
  {name:"Marble Island, Nunavut",
   type:"T",
   latitude:"62.6833",
   longitude:"-91.2"}
  ,
  {name:"Matuyama, Ehime, Japan",
   type:"T",
   latitude:"33.8667",
   longitude:"132.717"}
  ,
  {name:"Hachinohe, Aomori, Japan",
   type:"T",
   latitude:"40.5333",
   longitude:"141.533"}
  ,
  {name:"Newburyport (Merrimack River), Massachusetts Current",
   type:"C",
   latitude:"42.8133",
   longitude:"-70.8683"}
  ,
  {name:"Port-Menier, Québec",
   type:"T",
   latitude:"49.8167",
   longitude:"-64.3667"}
  ,
  {name:"Hull, England",
   type:"T",
   latitude:"53.7333",
   longitude:"-0.25"}
  ,
  {name:"False Strait, Nunavut (2)",
   type:"T",
   latitude:"71.9833",
   longitude:"-95.0167"}
  ,
  {name:"Stockton, California",
   type:"T",
   latitude:"37.9667",
   longitude:"-121.2833"}
  ,
  {name:"Petite Rivière, Québec",
   type:"T",
   latitude:"48.4106",
   longitude:"-64.4131"}
  ,
  {name:"Swansea, Wales",
   type:"T",
   latitude:"51.6167",
   longitude:"-3.9167"}
  ,
  {name:"Bahía Crossley, Argentina",
   type:"T",
   latitude:"-54.8",
   longitude:"-64.7"}
  ,
  {name:"Rae Island, Nunavut/NWT",
   type:"T",
   latitude:"69.5333",
   longitude:"-135.1167"}
  ,
  {name:"Roscoff, France (2)",
   type:"T",
   latitude:"48.7167",
   longitude:"-3.9667"}
  ,
  {name:"Shippegan, New Brunswick",
   type:"T",
   latitude:"47.75",
   longitude:"-64.7"}
  ,
  {name:"Yotuiwa, Kurile Islands",
   type:"T",
   latitude:"50.2833",
   longitude:"155.917"}
  ,
  {name:"Ponape Harbor, Caroline Islands (2)",
   type:"T",
   latitude:"6.9667",
   longitude:"158.2"}
  ,
  {name:"Broome, Australia",
   type:"T",
   latitude:"-18.0",
   longitude:"122.2167"}
  ,
  {name:"Buntzen Lake, British Columbia",
   type:"T",
   latitude:"49.3667",
   longitude:"-122.8833"}
  ,
  {name:"Cristóbal, Panama (2)",
   type:"T",
   latitude:"9.35",
   longitude:"-79.9167"}
  ,
  {name:"Kwokwesta Creek, British Columbia (2)",
   type:"T",
   latitude:"50.5167",
   longitude:"-127.5667"}
  ,
  {name:"Wilhelmshaven, Germany",
   type:"T",
   latitude:"53.5167",
   longitude:"8.1667"}
  ,
  {name:"Winisk, Ontario",
   type:"T",
   latitude:"55.2833",
   longitude:"-85.1"}
  ,
  {name:"Samch'onp'o, South Korea",
   type:"T",
   latitude:"34.9333",
   longitude:"128.0667"}
  ,
  {name:"Samuel Island (South Shore), British Columbia",
   type:"T",
   latitude:"48.8",
   longitude:"-123.2"}
  ,
  {name:"Turuga, Hukui, Japan",
   type:"T",
   latitude:"35.6667",
   longitude:"136.067"}
  ,
  {name:"Nahcotta, Willipa Bay, Washington",
   type:"T",
   latitude:"46.5",
   longitude:"-124.0233"}
  ,
  {name:"Point Sapin, New Brunswick",
   type:"T",
   latitude:"46.9833",
   longitude:"-64.8167"}
  ,
  {name:"Picton, New Zealand (2)",
   type:"T",
   latitude:"-41.2833",
   longitude:"174.0"}
  ,
  {name:"Point Judith Harbor of Refuge, Rhode Island",
   type:"T",
   latitude:"41.36",
   longitude:"-71.49"}
  ,
  {name:"Galway, Ireland",
   type:"T",
   latitude:"53.2667",
   longitude:"-9.05"}
  ,
  {name:"Hamilton Bank 796, Newfoundland",
   type:"T",
   latitude:"51.0667",
   longitude:"-53.0167"}
  ,
  {name:"Esasi (Kitami), Hokkaido, Japan",
   type:"T",
   latitude:"44.9333",
   longitude:"142.6"}
  ,
  {name:"Saint-Nazaire, France",
   type:"T",
   latitude:"47.2667",
   longitude:"-2.2"}
  ,
  {name:"Kutinotu, Nagasaki, Japan",
   type:"T",
   latitude:"32.6",
   longitude:"130.2"}
  ,
  {name:"Mobile (Mobile State Docks), Alabama (2) (expired 1989-12-31)",
   type:"T",
   latitude:"30.705",
   longitude:"-88.0367"}
  ,
  {name:"Songkhla, Thailand",
   type:"T",
   latitude:"7.2333",
   longitude:"100.6167"}
  ,
  {name:"Merrimack River Entrance, Massachusetts",
   type:"T",
   latitude:"42.8167",
   longitude:"-70.8167"}
  ,
  {name:"Cobh, Ireland",
   type:"T",
   latitude:"51.8333",
   longitude:"-8.3"}
  ,
  {name:"Elkhorn, California",
   type:"T",
   latitude:"36.8183",
   longitude:"-121.745"}
  ,
  {name:"Red Bay, Strait of Bell Isle, Labrador",
   type:"T",
   latitude:"51.7167",
   longitude:"-56.4167"}
  ,
  {name:"Kodomari, Aomori, Japan",
   type:"T",
   latitude:"41.1333",
   longitude:"140.3"}
  ,
  {name:"Point Murat, Australia",
   type:"T",
   latitude:"-21.8167",
   longitude:"114.1833"}
  ,
  {name:"Dzaoudzi, Île de Mayotte",
   type:"T",
   latitude:"-12.7833",
   longitude:"45.25"}
  ,
  {name:"Esquimalt Lagoon, British Columbia",
   type:"T",
   latitude:"48.4333",
   longitude:"-123.4667"}
  ,
  {name:"North Sydney, Nova Scotia",
   type:"T",
   latitude:"46.2167",
   longitude:"-60.25"}
  ,
  {name:"Hamilton Bank 334, Labrador",
   type:"T",
   latitude:"53.7333",
   longitude:"-53.6167"}
  ,
  {name:"Agvik Island, Québec",
   type:"T",
   latitude:"60.0167",
   longitude:"-69.7"}
  ,
  {name:"Kaohsiung, Taiwan",
   type:"T",
   latitude:"22.6167",
   longitude:"120.2667"}
  ,
  {name:"Otaru, Hokkaido, Japan",
   type:"T",
   latitude:"43.2167",
   longitude:"141.017"}
  ,
  {name:"Abbot Point, Australia",
   type:"T",
   latitude:"-19.8833",
   longitude:"148.0833"}
  ,
  {name:"Cape Upstart, Australia",
   type:"T",
   latitude:"-19.7",
   longitude:"147.75"}
  ,
  {name:"Iwahune, Niigata, Japan",
   type:"T",
   latitude:"38.1833",
   longitude:"139.433"}
  ,
  {name:"Antonio Enes, Mozambique",
   type:"T",
   latitude:"-16.2333",
   longitude:"39.9"}
  ,
  {name:"Baie-Comeau, Québec",
   type:"T",
   latitude:"49.2333",
   longitude:"-68.1333"}
  ,
  {name:"Eureka, Nunavut",
   type:"T",
   latitude:"79.9833",
   longitude:"-85.95"}
  ,
  {name:"Vilano Beach Bridge, Tolomato River, Florida",
   type:"T",
   latitude:"29.9167",
   longitude:"-81.3"}
  ,
  {name:"Drury Entrance, British Columbia",
   type:"T",
   latitude:"50.9",
   longitude:"-126.9"}
  ,
  {name:"Juneau, Alaska (2)",
   type:"T",
   latitude:"58.3",
   longitude:"-134.41"}
  ,
  {name:"Halfmoon Bay, British Columbia",
   type:"T",
   latitude:"49.5167",
   longitude:"-123.9167"}
  ,
  {name:"Deep Cove, British Columbia (2)",
   type:"T",
   latitude:"49.0333",
   longitude:"-122.95"}
  ,
  {name:"Carquinez Strait, California Current",
   type:"C",
   latitude:"38.0617",
   longitude:"-122.2183"}
  ,
  {name:"Savannah River Entrance, Georgia",
   type:"T",
   latitude:"32.0333",
   longitude:"-80.9017"}
  ,
  {name:"Tête-à-la-Baleine, Québec",
   type:"T",
   latitude:"50.6833",
   longitude:"-59.2333"}
  ,
  {name:"Table Head Point, Nova Scotia",
   type:"T",
   latitude:"46.3333",
   longitude:"-60.3667"}
  ,
  {name:"Saint John, New Brunswick",
   type:"T",
   latitude:"45.2667",
   longitude:"-66.0667"}
  ,
  {name:"Taisya, Simane, Japan",
   type:"T",
   latitude:"35.4",
   longitude:"132.667"}
  ,
  {name:"Toya, Okinawa, Japan",
   type:"T",
   latitude:"26.3833",
   longitude:"127.733"}
  ,
  {name:"Cape Alava, Washington",
   type:"T",
   latitude:"48.1667",
   longitude:"-124.7333"}
  ,
  {name:"Malindi, Kenya",
   type:"T",
   latitude:"-3.2167",
   longitude:"40.1167"}
  ,
  {name:"Serrurier Island, Australia",
   type:"T",
   latitude:"-21.6",
   longitude:"114.6833"}
  ,
  {name:"Cam Pha, Vietnam",
   type:"T",
   latitude:"21.0333",
   longitude:"107.3667"}
  ,
  {name:"Nugu Island, Solomon Islands",
   type:"T",
   latitude:"-9.2833",
   longitude:"160.35"}
  ,
  {name:"Mimitu, Miyazaki, Japan",
   type:"T",
   latitude:"32.3333",
   longitude:"131.617"}
  ,
  {name:"Bombay, India",
   type:"T",
   latitude:"18.9167",
   longitude:"72.8333"}
  ,
  {name:"Toulon, France",
   type:"T",
   latitude:"43.1167",
   longitude:"5.9"}
  ,
  {name:"Unnamed Reef No. 2, Australia",
   type:"T",
   latitude:"-19.6167",
   longitude:"149.8333"}
  ,
  {name:"Chittagong, Bangladesh",
   type:"T",
   latitude:"22.3333",
   longitude:"91.8333"}
  ,
  {name:"Havre-De-Beaubassin, Québec",
   type:"T",
   latitude:"48.0333",
   longitude:"-65.4833"}
  ,
  {name:"Takara Sima, Kagosima, Japan",
   type:"T",
   latitude:"29.15",
   longitude:"129.2"}
  ,
  {name:"Drainey Inlet, British Columbia (2)",
   type:"T",
   latitude:"51.4833",
   longitude:"-127.55"}
  ,
  {name:"Sault-Au-Cochon, Québec",
   type:"T",
   latitude:"47.2",
   longitude:"-70.6333"}
  ,
  {name:"Sima Saki, Kyoto, Japan",
   type:"T",
   latitude:"35.5333",
   longitude:"135.2"}
  ,
  {name:"Rincon Island, California",
   type:"T",
   latitude:"34.3483",
   longitude:"-119.4433"}
  ,
  {name:"Burntcoat Head, Nova Scotia (2)",
   type:"T",
   latitude:"45.3",
   longitude:"-63.8"}
  ,
  {name:"Surprise Bay, Tasmania",
   type:"T",
   latitude:"-40.1333",
   longitude:"143.9667"}
  ,
  {name:"Haiphong, Vietnam",
   type:"T",
   latitude:"20.8667",
   longitude:"106.6667"}
  ,
  {name:"Cape D'or, Nova Scotia",
   type:"T",
   latitude:"45.2833",
   longitude:"-64.7667"}
  ,
  {name:"Grassy Key, south side, Hawk Channel, Florida",
   type:"T",
   latitude:"24.755",
   longitude:"-80.9583"}
  ,
  {name:"Crescent Bay, Washington (2)",
   type:"T",
   latitude:"48.0167",
   longitude:"-123.7167"}
  ,
  {name:"Kaminato (Hatizyo Sima), Tokyo, Japan",
   type:"T",
   latitude:"33.1333",
   longitude:"139.8"}
  ,
  {name:"Corpus Christi, Texas (2) (expired 1999-07-23)",
   type:"T",
   latitude:"27.7933",
   longitude:"-97.39"}
  ,
  {name:"Dover, England",
   type:"T",
   latitude:"51.1167",
   longitude:"1.3167"}
  ,
  {name:"Kwokwesta Creek, British Columbia",
   type:"T",
   latitude:"50.5167",
   longitude:"-127.5667"}
  ,
  {name:"Northwest Bay, British Columbia",
   type:"T",
   latitude:"49.3",
   longitude:"-124.2"}
  ,
  {name:"Ottozawa, Fukusima, Japan",
   type:"T",
   latitude:"37.4167",
   longitude:"141.033"}
  ,
  {name:"Grindstone Island, New Brunswick",
   type:"T",
   latitude:"45.7167",
   longitude:"-64.6167"}
  ,
  {name:"Cherry Point, Washington",
   type:"T",
   latitude:"48.8633",
   longitude:"-122.7583"}
  ,
  {name:"Cape Cod Canal (East Entrance), Massachusetts",
   type:"T",
   latitude:"41.7717",
   longitude:"-70.5067"}
  ,
  {name:"Davis, Antarctica (2)",
   type:"T",
   latitude:"-68.0",
   longitude:"78.5"}
  ,
  {name:"Sonora, St. Mary River, Nova Scotia",
   type:"T",
   latitude:"45.05",
   longitude:"-61.9167"}
  ,
  {name:"Bahía Honda Key (Bridge), Florida",
   type:"T",
   latitude:"24.655",
   longitude:"-81.2817"}
  ,
  {name:"Oura (Sekito Seto), Ehime, Japan",
   type:"T",
   latitude:"33.9833",
   longitude:"132.633"}
  ,
  {name:"Stack Island, Tasmania",
   type:"T",
   latitude:"-40.6",
   longitude:"144.7833"}
  ,
  {name:"Postville, Labrador",
   type:"T",
   latitude:"54.9",
   longitude:"-59.7833"}
  ,
  {name:"Maple Bay, British Columbia (2)",
   type:"T",
   latitude:"48.8167",
   longitude:"-123.45"}
  ,
  {name:"Ko Si Chang, Thailand",
   type:"T",
   latitude:"13.15",
   longitude:"100.8167"}
  ,
  {name:"Money Key, Florida",
   type:"T",
   latitude:"24.6833",
   longitude:"-81.2167"}
  ,
  {name:"Cambridge Narrows, New Brunswick",
   type:"T",
   latitude:"45.8333",
   longitude:"-65.95"}
  ,
  {name:"St. Petersburg, Florida (2) (expired 1995-12-31)",
   type:"T",
   latitude:"27.7733",
   longitude:"-82.6217"}
  ,
  {name:"Humoto, Kagosima, Japan",
   type:"T",
   latitude:"31.55",
   longitude:"130.733"}
  ,
  {name:"Settlement Point, Grand Bahama Island, Bahamas",
   type:"T",
   latitude:"26.71",
   longitude:"-78.9967"}
  ,
  {name:"Rae Point, Nunavut/NWT",
   type:"T",
   latitude:"75.3667",
   longitude:"-105.7"}
  ,
  {name:"Finsch Harbour, Papua New Guinea",
   type:"T",
   latitude:"-6.55",
   longitude:"147.85"}
  ,
  {name:"Reykjavik, Iceland (3)",
   type:"T",
   latitude:"64.15",
   longitude:"-21.9333"}
  ,
  {name:"River Tyne Entrance, England (2)",
   type:"T",
   latitude:"55.0167",
   longitude:"-1.4"}
  ,
  {name:"Tuckers Island, Homosassa River, Florida",
   type:"T",
   latitude:"28.7717",
   longitude:"-82.695"}
  ,
  {name:"Isihama (Matusima Wan), Miyagi, Japan",
   type:"T",
   latitude:"38.3167",
   longitude:"141.117"}
  ,
  {name:"Okeover Inlet, British Columbia (2)",
   type:"T",
   latitude:"49.9833",
   longitude:"-124.7"}
  ,
  {name:"Willets Point, New York",
   type:"T",
   latitude:"40.7933",
   longitude:"-73.7817"}
  ,
  {name:"Mozi, Hukuoka, Japan",
   type:"T",
   latitude:"33.9333",
   longitude:"130.967"}
  ,
  {name:"La Rochelle-La Pallice, France",
   type:"T",
   latitude:"46.1667",
   longitude:"-1.2167"}
  ,
  {name:"Kavieng, Papua New Guinea",
   type:"T",
   latitude:"-2.5833",
   longitude:"150.8"}
  ,
  {name:"Nagasima (Mie), Mie, Japan",
   type:"T",
   latitude:"34.2",
   longitude:"136.333"}
  ,
  {name:"Hasirimizu, Kanagawa, Japan",
   type:"T",
   latitude:"35.25",
   longitude:"139.733"}
  ,
  {name:"Oak Point, New Brunswick",
   type:"T",
   latitude:"47.1167",
   longitude:"-65.2667"}
  ,
  {name:"Marie Joseph, Nova Scotia",
   type:"T",
   latitude:"44.9667",
   longitude:"-62.0833"}
  ,
  {name:"Samuel Island (North Shore), British Columbia (2)",
   type:"T",
   latitude:"48.8167",
   longitude:"-123.2"}
  ,
  {name:"Heywood Shoal, Australia",
   type:"T",
   latitude:"-13.4667",
   longitude:"124.05"}
  ,
  {name:"Astoria (Tongue Point), Oregon (3)",
   type:"T",
   latitude:"46.208",
   longitude:"-123.767"}
  ,
  {name:"Rattlesnake Island, Australia",
   type:"T",
   latitude:"-19.0333",
   longitude:"146.6167"}
  ,
  {name:"Fécamp, France",
   type:"T",
   latitude:"49.7667",
   longitude:"0.3667"}
  ,
  {name:"Lolomo Passage, Solomon Islands",
   type:"T",
   latitude:"-8.1833",
   longitude:"157.6833"}
  ,
  {name:"Reykjavik, Iceland (2)",
   type:"T",
   latitude:"64.15",
   longitude:"-21.9333"}
  ,
  {name:"Tarrytown, Hudson River, New York",
   type:"T",
   latitude:"41.0783",
   longitude:"-73.87"}
  ,
  {name:"Georgetown Harbour, Prince Edward Island",
   type:"T",
   latitude:"46.1833",
   longitude:"-62.5333"}
  ,
  {name:"Bailay Creek, Australia",
   type:"T",
   latitude:"-16.2",
   longitude:"145.45"}
  ,
  {name:"Tampico, Tamaulipas, Mexico (2)",
   type:"T",
   latitude:"22.25",
   longitude:"-97.85"}
  ,
  {name:"Tuktoyaktuk, Nunavut/NWT",
   type:"T",
   latitude:"69.45",
   longitude:"-133.0"}
  ,
  {name:"Hampden, Newfoundland",
   type:"T",
   latitude:"49.5667",
   longitude:"-56.8667"}
  ,
  {name:"Stanley, Tasmania",
   type:"T",
   latitude:"-40.7667",
   longitude:"145.3"}
  ,
  {name:"Beechy Island, Barrow Strait, Nunavut",
   type:"T",
   latitude:"74.7167",
   longitude:"-91.9"}
  ,
  {name:"Jervis Bay, Australia",
   type:"T",
   latitude:"-35.1167",
   longitude:"150.7"}
  ,
  {name:"Sisters Creek, St. Johns River, Florida",
   type:"T",
   latitude:"30.4167",
   longitude:"-81.4533"}
  ,
  {name:"Cape Scott, British Columbia (2)",
   type:"T",
   latitude:"50.7833",
   longitude:"-128.4167"}
  ,
  {name:"St. Martins, New Brunswick",
   type:"T",
   latitude:"45.35",
   longitude:"-65.5333"}
  ,
  {name:"Palatka, St. Johns River, Florida (6)",
   type:"T",
   latitude:"29.6433",
   longitude:"-81.6317"}
  ,
  {name:"Baillie Island (South Spit), Nunavut/NWT",
   type:"T",
   latitude:"70.5167",
   longitude:"-128.35"}
  ,
  {name:"Yodoe, Tottori, Japan",
   type:"T",
   latitude:"35.4667",
   longitude:"133.433"}
  ,
  {name:"Musquash Harbour, New Brunswick",
   type:"T",
   latitude:"45.15",
   longitude:"-66.25"}
  ,
  {name:"Ullapool, Scotland",
   type:"T",
   latitude:"57.9",
   longitude:"-5.1667"}
  ,
  {name:"Middle Arm, British Columbia",
   type:"T",
   latitude:"49.1833",
   longitude:"-123.0167"}
  ,
  {name:"Sandpiper Island, Nunavut",
   type:"T",
   latitude:"63.4333",
   longitude:"-90.0667"}
  ,
  {name:"Imigen Island, Nunavut",
   type:"T",
   latitude:"66.0167",
   longitude:"-67.15"}
  ,
  {name:"Moncrief Creek entrance, Trout River, Florida",
   type:"T",
   latitude:"30.3917",
   longitude:"-81.6617"}
  ,
  {name:"Palatka, St. Johns River, Florida (5)",
   type:"T",
   latitude:"29.6433",
   longitude:"-81.6317"}
  ,
  {name:"Long Key, east of drawbridge, Florida Current",
   type:"C",
   latitude:"24.84",
   longitude:"-80.77"}
  ,
  {name:"Ao, Toyama, Japan",
   type:"T",
   latitude:"36.8833",
   longitude:"136.983"}
  ,
  {name:"Sharjah (Ash Shariqah), U.A.E.",
   type:"T",
   latitude:"25.3667",
   longitude:"55.3833"}
  ,
  {name:"Lewisporte, Newfoundland",
   type:"T",
   latitude:"49.2333",
   longitude:"-55.05"}
  ,
  {name:"Kearney Point, Hackensack River, New Jersey",
   type:"T",
   latitude:"40.7267",
   longitude:"-74.105"}
  ,
  {name:"Ohata, Aomori, Japan",
   type:"T",
   latitude:"41.4167",
   longitude:"141.167"}
  ,
  {name:"Victoria (Labuan), Malaysia",
   type:"T",
   latitude:"5.2667",
   longitude:"115.25"}
  ,
  {name:"Hudson Bay Passage, British Columbia",
   type:"T",
   latitude:"54.45",
   longitude:"-130.85"}
  ,
  {name:"Ibo, Mozambique",
   type:"T",
   latitude:"-12.35",
   longitude:"40.5833"}
  ,
  {name:"Oslo, Indian River, Florida",
   type:"T",
   latitude:"27.5933",
   longitude:"-80.3567"}
  ,
  {name:"Hook Island, Australia",
   type:"T",
   latitude:"-20.0667",
   longitude:"148.9333"}
  ,
  {name:"Jolo, Philippines",
   type:"T",
   latitude:"6.0667",
   longitude:"121.0"}
  ,
  {name:"Isinomaki, Miyagi, Japan",
   type:"T",
   latitude:"38.4167",
   longitude:"141.317"}
  ,
  {name:"Loreto, Baja California Sur, Mexico",
   type:"T",
   latitude:"26.0167",
   longitude:"-111.35"}
  ,
  {name:"North Star Bay, Wolstenholme Fjord, Greenland",
   type:"T",
   latitude:"76.55",
   longitude:"-68.8833"}
  ,
  {name:"Sugluk, Québec",
   type:"T",
   latitude:"62.2167",
   longitude:"-75.65"}
  ,
  {name:"Totoro, Miyazaki, Japan",
   type:"T",
   latitude:"32.5",
   longitude:"131.683"}
  ,
  {name:"Immingham, England",
   type:"T",
   latitude:"53.6333",
   longitude:"-0.1833"}
  ,
  {name:"Humboldt Bay (south jetty), California (expired 1984-12-31)",
   type:"T",
   latitude:"40.745",
   longitude:"-124.2267"}
  ,
  {name:"Palatka, St. Johns River, Florida (4)",
   type:"T",
   latitude:"29.6433",
   longitude:"-81.6317"}
  ,
  {name:"Ísafjörður, Iceland",
   type:"T",
   latitude:"66.0666",
   longitude:"-23.1166"}
  ,
  {name:"Molle Island, Australia",
   type:"T",
   latitude:"-20.25",
   longitude:"148.8333"}
  ,
  {name:"Nuku`alofa, Tonga (2)",
   type:"T",
   latitude:"-21.1333",
   longitude:"-175.2167"}
  ,
  {name:"Cape Capel, Nunavut",
   type:"T",
   latitude:"75.0333",
   longitude:"-98.0333"}
  ,
  {name:"Sonok Do, South Korea",
   type:"T",
   latitude:"34.5",
   longitude:"127.15"}
  ,
  {name:"Dalhousie, New Brunswick",
   type:"T",
   latitude:"48.0667",
   longitude:"-66.3833"}
  ,
  {name:"Macau, China",
   type:"T",
   latitude:"22.2",
   longitude:"113.55"}
  ,
  {name:"Sept-Îles, Québec (2)",
   type:"T",
   latitude:"50.2167",
   longitude:"-66.4"}
  ,
  {name:"Bubaque, Guinea-Bissau",
   type:"T",
   latitude:"11.3333",
   longitude:"-15.8667"}
  ,
  {name:"Solomons Island, Patuxent River, Maryland (2)",
   type:"T",
   latitude:"38.3167",
   longitude:"-76.4533"}
  ,
  {name:"Hanga Piko, Easter Island",
   type:"T",
   latitude:"-27.1667",
   longitude:"-109.3333"}
  ,
  {name:"Koksoak River, West Entrance, Québec",
   type:"T",
   latitude:"58.5333",
   longitude:"-68.2"}
  ,
  {name:"Bar Harbor, Frenchman Bay, Maine",
   type:"T",
   latitude:"44.3917",
   longitude:"-68.205"}
  ,
  {name:"Sesimbra, Portugal",
   type:"T",
   latitude:"38.4333",
   longitude:"-9.1167"}
  ,
  {name:"Port Noarlunga, Australia",
   type:"T",
   latitude:"-35.1667",
   longitude:"138.5"}
  ,
  {name:"Estus Point, Hagemeister Strait, Alaska",
   type:"T",
   latitude:"58.8083",
   longitude:"-161.1"}
  ,
  {name:"Singapore (Victoria Dock)",
   type:"T",
   latitude:"1.2667",
   longitude:"103.85"}
  ,
  {name:"Tarilag Island, Endeavour Strait",
   type:"T",
   latitude:"-10.75",
   longitude:"142.2333"}
  ,
  {name:"Hutami (Mano Wan), Niigata, Japan",
   type:"T",
   latitude:"37.9667",
   longitude:"138.267"}
  ,
  {name:"Palatka, St. Johns River, Florida (3)",
   type:"T",
   latitude:"29.6433",
   longitude:"-81.6317"}
  ,
  {name:"Degnen Bay, British Columbia",
   type:"T",
   latitude:"49.1333",
   longitude:"-123.7167"}
  ,
  {name:"Lazaro Cardenas, Michoacan, Mexico",
   type:"T",
   latitude:"17.9167",
   longitude:"-102.1667"}
  ,
  {name:"Mallison Island, Australia",
   type:"T",
   latitude:"-12.1833",
   longitude:"136.1"}
  ,
  {name:"Margate, England",
   type:"T",
   latitude:"51.3833",
   longitude:"1.3833"}
  ,
  {name:"Atlantic City (Steel Pier), New Jersey (2) (expired 1989-12-31)",
   type:"T",
   latitude:"39.355",
   longitude:"-74.4183"}
  ,
  {name:"Franklin River, British Columbia",
   type:"T",
   latitude:"49.1",
   longitude:"-124.8167"}
  ,
  {name:"Otome Wan, Kurile Islands",
   type:"T",
   latitude:"48.7833",
   longitude:"154.05"}
  ,
  {name:"Boca Grande Channel, Florida Current",
   type:"C",
   latitude:"24.5667",
   longitude:"-82.0667"}
  ,
  {name:"Cape Town, South Africa",
   type:"T",
   latitude:"-33.9",
   longitude:"18.4167"}
  ,
  {name:"Avonmouth (Port of Bristol), England",
   type:"T",
   latitude:"51.5",
   longitude:"-2.7167"}
  ,
  {name:"Vágur, Faroe Islands",
   type:"T",
   latitude:"61.47",
   longitude:"-6.8"}
  ,
  {name:"Ince Point, Torres Strait",
   type:"T",
   latitude:"-10.5",
   longitude:"142.3167"}
  ,
  {name:"Tutóia, Baia da, Brazil",
   type:"T",
   latitude:"-2.75",
   longitude:"-42.2333"}
  ,
  {name:"The Race, Long Island Sound, New York Current (2) (expired 1993-12-31)",
   type:"C",
   latitude:"41.2367",
   longitude:"-72.06"}
  ,
  {name:"Utiura Wan, Hukui, Japan",
   type:"T",
   latitude:"35.55",
   longitude:"135.5"}
  ,
  {name:"Tomamae, Hokkaido, Japan",
   type:"T",
   latitude:"44.3167",
   longitude:"141.65"}
  ,
  {name:"Kumamoto, Kumamoto, Japan",
   type:"T",
   latitude:"32.75",
   longitude:"130.567"}
  ,
  {name:"Acapulco, Guerrero, Mexico",
   type:"T",
   latitude:"16.84",
   longitude:"-99.9117"}
  ,
  {name:"Palatka, St. Johns River, Florida (2)",
   type:"T",
   latitude:"29.6433",
   longitude:"-81.6317"}
  ,
  {name:"Tom Bay, British Columbia (2)",
   type:"T",
   latitude:"52.4",
   longitude:"-128.2667"}
  ,
  {name:"Hayman Island, Australia",
   type:"T",
   latitude:"-20.05",
   longitude:"148.8833"}
  ,
  {name:"Northwest Bay, British Columbia (2)",
   type:"T",
   latitude:"49.3",
   longitude:"-124.2"}
  ,
  {name:"Bellingham, Washington",
   type:"T",
   latitude:"48.75",
   longitude:"-122.5"}
  ,
  {name:"Little Cornwallis, Nunavut",
   type:"T",
   latitude:"75.3833",
   longitude:"-96.95"}
  ,
  {name:"Spence Bay, Nunavut/NWT",
   type:"T",
   latitude:"69.5333",
   longitude:"-93.5167"}
  ,
  {name:"St. Johns River at Shands Bridge, Florida",
   type:"T",
   latitude:"29.9786",
   longitude:"-81.6286"}
  ,
  {name:"Holyrood, Newfoundland",
   type:"T",
   latitude:"47.35",
   longitude:"-53.1167"}
  ,
  {name:"Hesikiya, Okinawa, Japan",
   type:"T",
   latitude:"26.3",
   longitude:"127.917"}
  ,
  {name:"Sand Head, Ontario (2)",
   type:"T",
   latitude:"51.4167",
   longitude:"-80.35"}
  ,
  {name:"Tanjong Baram, Malaysia",
   type:"T",
   latitude:"4.5833",
   longitude:"113.9833"}
  ,
  {name:"Gillard Pass, British Columbia Current",
   type:"C",
   latitude:"50.3933",
   longitude:"-125.1567"}
  ,
  {name:"Puerto de Esmeraldas, Ecuador",
   type:"T",
   latitude:"1.0",
   longitude:"-79.65"}
  ,
  {name:"Izuhara, Nagasaki, Japan",
   type:"T",
   latitude:"34.2",
   longitude:"129.3"}
  ,
  {name:"Castle Island, Labrador",
   type:"T",
   latitude:"51.9667",
   longitude:"-55.85"}
  ,
  {name:"Canal Galheta, Brazil",
   type:"T",
   latitude:"-25.5667",
   longitude:"-48.3167"}
  ,
  {name:"Holden Beach, North Carolina",
   type:"T",
   latitude:"33.9167",
   longitude:"-78.2667"}
  ,
  {name:"Trois-Pistoles, Québec",
   type:"T",
   latitude:"48.1333",
   longitude:"-69.1833"}
  ,
  {name:"Menado, Sulawesi, Indonesia",
   type:"T",
   latitude:"1.5",
   longitude:"124.8333"}
  ,
  {name:"Musay'id, Qatar",
   type:"T",
   latitude:"25.0167",
   longitude:"51.65"}
  ,
  {name:"Nanaimo, British Columbia",
   type:"T",
   latitude:"49.1667",
   longitude:"-123.9333"}
  ,
  {name:"Saizyo, Ehime, Japan",
   type:"T",
   latitude:"33.9333",
   longitude:"133.167"}
  ,
  {name:"Ford Harbour, Labrador",
   type:"T",
   latitude:"56.45",
   longitude:"-61.2"}
  ,
  {name:"Comodoro Rivadavia, Argentina",
   type:"T",
   latitude:"-45.8667",
   longitude:"-67.4833"}
  ,
  {name:"Cordero Islands, British Columbia",
   type:"T",
   latitude:"50.4333",
   longitude:"-125.4833"}
  ,
  {name:"Frontera, Tabasco, Mexico",
   type:"T",
   latitude:"18.5333",
   longitude:"-92.65"}
  ,
  {name:"Cliff Cove, Nova Scotia",
   type:"T",
   latitude:"44.5167",
   longitude:"-63.9333"}
  ,
  {name:"Peniche, Portugal",
   type:"T",
   latitude:"39.35",
   longitude:"-9.3667"}
  ,
  {name:"Ortega River Entrance, Florida (2)",
   type:"T",
   latitude:"30.2783",
   longitude:"-81.705"}
  ,
  {name:"Tacloban, Philippines",
   type:"T",
   latitude:"11.25",
   longitude:"125.0"}
  ,
  {name:"Emily Harbour, Labrador",
   type:"T",
   latitude:"54.5333",
   longitude:"-57.1833"}
  ,
  {name:"Clover Point, British Columbia (2)",
   type:"T",
   latitude:"48.4",
   longitude:"-123.35"}
  ,
  {name:"Fox Island, Newfoundland",
   type:"T",
   latitude:"48.7333",
   longitude:"-58.7"}
  ,
  {name:"Sakai (Osaka Wan), Osaka, Japan",
   type:"T",
   latitude:"34.5833",
   longitude:"135.467"}
  ,
  {name:"Hayase Seto, Hirosima, Japan",
   type:"T",
   latitude:"34.15",
   longitude:"132.483"}
  ,
  {name:"Sullom Voe, Shetland Islands, Scotland",
   type:"T",
   latitude:"60.45",
   longitude:"-1.35"}
  ,
  {name:"Sandy Beach Centre, Québec",
   type:"T",
   latitude:"48.8194",
   longitude:"-64.4289"}
  ,
  {name:"Takoradi, Ghana",
   type:"T",
   latitude:"4.8833",
   longitude:"-1.75"}
  ,
  {name:"Gay Head, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.3533",
   longitude:"-70.83"}
  ,
  {name:"Crofton, British Columbia (2)",
   type:"T",
   latitude:"48.85",
   longitude:"-123.6333"}
  ,
  {name:"Leroy Bay, British Columbia (2)",
   type:"T",
   latitude:"51.2667",
   longitude:"-127.6833"}
  ,
  {name:"Aziro (Sizuoka), Sizuoka, Japan",
   type:"T",
   latitude:"35.05",
   longitude:"139.083"}
  ,
  {name:"Bermagui, Australia",
   type:"T",
   latitude:"-36.4333",
   longitude:"150.0667"}
  ,
  {name:"Io Sima (Nagasaki), Nagasaki, Japan",
   type:"T",
   latitude:"32.7",
   longitude:"129.783"}
  ,
  {name:"Mori, Hokkaido, Japan",
   type:"T",
   latitude:"42.1167",
   longitude:"140.6"}
  ,
  {name:"Naha, Okinawa, Japan",
   type:"T",
   latitude:"26.2167",
   longitude:"127.6667"}
  ,
  {name:"Newcastle Creek, New Brunswick",
   type:"T",
   latitude:"46.0667",
   longitude:"-66.0"}
  ,
  {name:"Rabaul, Papua New Guinea (2)",
   type:"T",
   latitude:"-4.2",
   longitude:"152.1833"}
  ,
  {name:"Haedomari, Yamaguti, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"130.883"}
  ,
  {name:"Mourilyan Harbour, Australia (2)",
   type:"T",
   latitude:"-17.6",
   longitude:"146.1167"}
  ,
  {name:"Southampton, England (3)",
   type:"T",
   latitude:"50.9",
   longitude:"-1.4"}
  ,
  {name:"Ekalugarsuit, Greenland",
   type:"T",
   latitude:"60.7333",
   longitude:"-46.0167"}
  ,
  {name:"Maeda, Yamaguti, Japan",
   type:"T",
   latitude:"33.9667",
   longitude:"130.967"}
  ,
  {name:"Sydney, Nova Scotia (2)",
   type:"T",
   latitude:"46.15",
   longitude:"-60.2"}
  ,
  {name:"Trindade Island",
   type:"T",
   latitude:"-20.5",
   longitude:"-29.3"}
  ,
  {name:"Philadelphia, Delaware River",
   type:"T",
   latitude:"39.9333",
   longitude:"-75.1417"}
  ,
  {name:"Port Seeadler, Manus, Admiralty Islands",
   type:"T",
   latitude:"-2.0167",
   longitude:"147.2667"}
  ,
  {name:"Woods Hole, Massachusetts Current (use with caution)",
   type:"C",
   latitude:"41.52",
   longitude:"-70.685"}
  ,
  {name:"Hamilton Bank 790, Labrador",
   type:"T",
   latitude:"54.1833",
   longitude:"-52.1333"}
  ,
  {name:"Sirahama (Tiba), Tiba, Japan",
   type:"T",
   latitude:"34.9167",
   longitude:"139.933"}
  ,
  {name:"San Carlos, Baja California Sur, Mexico",
   type:"T",
   latitude:"24.7833",
   longitude:"-112.1167"}
  ,
  {name:"Duck Pier, outside, North Carolina",
   type:"T",
   latitude:"36.1833",
   longitude:"-75.7467"}
  ,
  {name:"Tarawa, Gilbert Islands",
   type:"T",
   latitude:"1.3667",
   longitude:"172.9333"}
  ,
  {name:"Cato Island, Coral Sea",
   type:"T",
   latitude:"-23.25",
   longitude:"155.5333"}
  ,
  {name:"Gokasyo, Mie, Japan",
   type:"T",
   latitude:"34.3167",
   longitude:"136.667"}
  ,
  {name:"Pelly Island, Nunavut/NWT",
   type:"T",
   latitude:"69.6167",
   longitude:"-135.3667"}
  ,
  {name:"Eastmain, Québec",
   type:"T",
   latitude:"52.0167",
   longitude:"-78.05"}
  ,
  {name:"Ortega River Entrance, Florida (4)",
   type:"T",
   latitude:"30.2783",
   longitude:"-81.705"}
  ,
  {name:"Nagoya, Aichi, Japan (2)",
   type:"T",
   latitude:"35.0833",
   longitude:"136.8833"}
  ,
  {name:"Bere Bay, Nunavut",
   type:"T",
   latitude:"76.95",
   longitude:"-94.0167"}
  ,
  {name:"Port Simpson, British Columbia (2)",
   type:"T",
   latitude:"54.5667",
   longitude:"-130.4333"}
  ,
  {name:"Freetown, Sierra Leone",
   type:"T",
   latitude:"8.5",
   longitude:"-13.2333"}
  ,
  {name:"Surprise Fiord, Nunavut",
   type:"T",
   latitude:"78.0333",
   longitude:"-90.0333"}
  ,
  {name:"Upper Hell Gate (Sasanoa River, Maine) Current",
   type:"C",
   latitude:"43.895",
   longitude:"-69.7717"}
  ,
  {name:"Kobi Syo, Okinawa, Japan",
   type:"T",
   latitude:"25.9333",
   longitude:"123.683"}
  ,
  {name:"Ootu, Ibaraki, Japan",
   type:"T",
   latitude:"36.8333",
   longitude:"140.8"}
  ,
  {name:"Port Clyde, Maine",
   type:"T",
   latitude:"43.925",
   longitude:"-69.26"}
  ,
  {name:"Albany Island, Endeavour Strait",
   type:"T",
   latitude:"-10.7167",
   longitude:"142.5833"}
  ,
  {name:"North Twin Island, Nunavut",
   type:"T",
   latitude:"53.0333",
   longitude:"-80.0"}
  ,
  {name:"Lunenburg, Nova Scotia",
   type:"T",
   latitude:"44.3667",
   longitude:"-64.3167"}
  ,
  {name:"Bristol, Rhode Island",
   type:"T",
   latitude:"41.6667",
   longitude:"-71.2667"}
  ,
  {name:"Elliot Heads, Australia",
   type:"T",
   latitude:"-24.9167",
   longitude:"152.4833"}
  ,
  {name:"Low Wooded Isle, Australia",
   type:"T",
   latitude:"-15.0833",
   longitude:"145.25"}
  ,
  {name:"Dover, New Brunswick",
   type:"T",
   latitude:"45.9833",
   longitude:"-64.6833"}
  ,
  {name:"Richibucto, New Brunswick",
   type:"T",
   latitude:"46.6833",
   longitude:"-64.8667"}
  ,
  {name:"Ortega River Entrance, Florida (3)",
   type:"T",
   latitude:"30.2783",
   longitude:"-81.705"}
  ,
  {name:"Daytona Beach Shores (Sunglow Pier), Florida",
   type:"T",
   latitude:"29.1467",
   longitude:"-80.9633"}
  ,
  {name:"Turnavik Island, Labrador",
   type:"T",
   latitude:"55.3",
   longitude:"-59.35"}
  ,
  {name:"Rausu, Hokkaido, Japan",
   type:"T",
   latitude:"44.0167",
   longitude:"145.2"}
  ,
  {name:"Malibu Inner, British Columbia",
   type:"T",
   latitude:"50.0167",
   longitude:"-123.85"}
  ,
  {name:"Kenneth Passage, British Columbia (2)",
   type:"T",
   latitude:"50.95",
   longitude:"-126.8"}
  ,
  {name:"Sines, Portugal",
   type:"T",
   latitude:"37.95",
   longitude:"-8.8667"}
  ,
  {name:"Sydney, Nova Scotia",
   type:"T",
   latitude:"46.15",
   longitude:"-60.2"}
  ,
  {name:"Hati Lawi Harbour, Papua New Guinea",
   type:"T",
   latitude:"-11.2667",
   longitude:"153.1667"}
  ,
  {name:"Lund, British Columbia",
   type:"T",
   latitude:"49.9833",
   longitude:"-124.7667"}
  ,
  {name:"Sable Island Drill Site, Nova Scotia",
   type:"T",
   latitude:"44.0333",
   longitude:"-59.6"}
  ,
  {name:"Newman Sound, Newfoundland",
   type:"T",
   latitude:"48.5833",
   longitude:"-53.95"}
  ,
  {name:"Tilt Cove, Newfoundland",
   type:"T",
   latitude:"49.8833",
   longitude:"-55.6167"}
  ,
  {name:"Arctic Bay, Nunavut",
   type:"T",
   latitude:"73.0333",
   longitude:"-85.0167"}
  ,
  {name:"Hurue, Mie, Japan",
   type:"T",
   latitude:"33.9667",
   longitude:"136.217"}
  ,
  {name:"Lagrange Bay, Australia",
   type:"T",
   latitude:"-18.7",
   longitude:"121.7333"}
  ,
  {name:"Dar Es Salaam, Tanzania",
   type:"T",
   latitude:"-6.8167",
   longitude:"39.3167"}
  ,
  {name:"Guayaquil, Ecuador",
   type:"T",
   latitude:"-2.2",
   longitude:"-79.8833"}
  ,
  {name:"Eureka, Humboldt Bay, California",
   type:"T",
   latitude:"40.8067",
   longitude:"-124.1667"}
  ,
  {name:"Belledune, New Brunswick",
   type:"T",
   latitude:"47.9",
   longitude:"-65.85"}
  ,
  {name:"Kurihama, Kanagawa, Japan",
   type:"T",
   latitude:"35.2167",
   longitude:"139.717"}
  ,
  {name:"Portsmouth, England (2)",
   type:"T",
   latitude:"50.8",
   longitude:"-1.1167"}
  ,
  {name:"Sooke Basin, British Columbia (2)",
   type:"T",
   latitude:"48.3833",
   longitude:"-123.6833"}
  ,
  {name:"Gabriola Passage, British Columbia Current",
   type:"C",
   latitude:"49.1283",
   longitude:"-123.7"}
  ,
  {name:"Ikema, Okinawa, Japan",
   type:"T",
   latitude:"24.9167",
   longitude:"125.25"}
  ,
  {name:"Eastmain River, Québec",
   type:"T",
   latitude:"52.25",
   longitude:"-78.55"}
  ,
  {name:"Bayou Rigaud, Grand Isle, Mississippi River Delta, Louisiana",
   type:"T",
   latitude:"29.255",
   longitude:"-89.9683"}
  ,
  {name:"Hukura, Hyogo, Japan",
   type:"T",
   latitude:"34.25",
   longitude:"134.7"}
  ,
  {name:"Dampier, Australia (2)",
   type:"T",
   latitude:"-20.65",
   longitude:"116.7167"}
  ,
  {name:"Obe, Kagawa, Japan",
   type:"T",
   latitude:"34.55",
   longitude:"134.283"}
  ,
  {name:"Victoria, British Columbia (3)",
   type:"T",
   latitude:"48.4167",
   longitude:"-123.3667"}
  ,
  {name:"Bahía San Juanico, Baja California Sur, Mexico",
   type:"T",
   latitude:"26.25",
   longitude:"-112.4667"}
  ,
  {name:"Cape Croker, Australia",
   type:"T",
   latitude:"-11.0",
   longitude:"132.5667"}
  ,
  {name:"Cabo San Lucas, Baja California Sur, Mexico",
   type:"T",
   latitude:"22.8833",
   longitude:"-109.9"}
  ,
  {name:"Takasago, Hyogo, Japan",
   type:"T",
   latitude:"34.7333",
   longitude:"134.8"}
  ,
  {name:"Plymouth, Massachusetts",
   type:"T",
   latitude:"41.96",
   longitude:"-70.6633"}
  ,
  {name:"Mikuni, Hukui, Japan",
   type:"T",
   latitude:"36.2167",
   longitude:"136.133"}
  ,
  {name:"Zeebrugge, Belgium",
   type:"T",
   latitude:"51.3333",
   longitude:"3.2"}
  ,
  {name:"Long Pond, Newfoundland",
   type:"T",
   latitude:"47.5167",
   longitude:"-52.9667"}
  ,
  {name:"Jennis Bay, British Columbia",
   type:"T",
   latitude:"50.9167",
   longitude:"-127.0167"}
  ,
  {name:"Punta Arenas, Costa Rica",
   type:"T",
   latitude:"9.9667",
   longitude:"-84.8333"}
  ,
  {name:"Red Island, Endeavour Strait",
   type:"T",
   latitude:"-10.85",
   longitude:"142.3667"}
  ,
  {name:"Bampfield Head, Endeavour Strait",
   type:"T",
   latitude:"-10.7",
   longitude:"142.1"}
  ,
  {name:"Port Greville, Nova Scotia",
   type:"T",
   latitude:"45.4",
   longitude:"-64.55"}
  ,
  {name:"Coral Harbour, Southampton Island, Nunavut",
   type:"T",
   latitude:"64.1333",
   longitude:"-83.0167"}
  ,
  {name:"Hejka Drill Site, Nunavut",
   type:"T",
   latitude:"62.0167",
   longitude:"-62.9667"}
  ,
  {name:"Victoria, British Columbia (2)",
   type:"T",
   latitude:"48.4167",
   longitude:"-123.3667"}
  ,
  {name:"Yahata, Hukuoka, Japan",
   type:"T",
   latitude:"33.8667",
   longitude:"130.8"}
  ,
  {name:"Hornby Island, British Columbia",
   type:"T",
   latitude:"49.5",
   longitude:"-124.6833"}
  ,
  {name:"North Harbour, Newfoundland",
   type:"T",
   latitude:"47.85",
   longitude:"-54.1"}
  ,
  {name:"Kawaihae, Big Island, Hawaii (2)",
   type:"T",
   latitude:"20.05",
   longitude:"-155.8333"}
  ,
  {name:"Miri, Malaysia",
   type:"T",
   latitude:"4.3833",
   longitude:"113.9833"}
  ,
  {name:"Kaohsiung, Taiwan (2)",
   type:"T",
   latitude:"22.6167",
   longitude:"120.2667"}
  ,
  {name:"San Carlos, Baja California Sur, Mexico (3)",
   type:"T",
   latitude:"24.79",
   longitude:"-112.12"}
  ,
  {name:"Tuyazaki, Hukuoka, Japan",
   type:"T",
   latitude:"33.7833",
   longitude:"130.45"}
  ,
  {name:"Kahului, Kahului Harbor, Hawaii (2) (expired 1999-12-31)",
   type:"T",
   latitude:"20.8983",
   longitude:"-156.4717"}
  ,
  {name:"Octopus Islands, British Columbia",
   type:"T",
   latitude:"50.2833",
   longitude:"-125.2167"}
  ,
  {name:"Mcewin Islet, Australia",
   type:"T",
   latitude:"-22.15",
   longitude:"149.6"}
  ,
  {name:"Nikisiyoro, Hokkaido, Japan",
   type:"T",
   latitude:"44.05",
   longitude:"145.733"}
  ,
  {name:"Useless Loop, Australia",
   type:"T",
   latitude:"-26.1333",
   longitude:"113.4167"}
  ,
  {name:"Abrahams Bay, Mayaguana Island, Bahamas",
   type:"T",
   latitude:"22.3667",
   longitude:"-73.0"}
  ,
  {name:"Aioi, Hyogo, Japan",
   type:"T",
   latitude:"34.8",
   longitude:"134.467"}
  ,
  {name:"Jamestown, Newfoundland",
   type:"T",
   latitude:"48.4333",
   longitude:"-53.8"}
  ,
  {name:"San Fernando, Argentina",
   type:"T",
   latitude:"-34.4333",
   longitude:"-58.5333"}
  ,
  {name:"Port Elizabeth, South Africa",
   type:"T",
   latitude:"-33.9667",
   longitude:"25.6333"}
  ,
  {name:"San Carlos, Baja California Sur, Mexico (2)",
   type:"T",
   latitude:"24.79",
   longitude:"-112.12"}
  ,
  {name:"Port Renfrew, British Columbia",
   type:"T",
   latitude:"48.55",
   longitude:"-124.4167"}
  ,
  {name:"Coats Island, Nunavut",
   type:"T",
   latitude:"62.45",
   longitude:"-81.35"}
  ,
  {name:"Hii Wan, Wakayama, Japan",
   type:"T",
   latitude:"33.9167",
   longitude:"135.1"}
  ,
  {name:"Crescent City, California (2) (expired 1989-12-31)",
   type:"T",
   latitude:"41.745",
   longitude:"-124.1833"}
  ,
  {name:"Katanohara, Aichi, Japan",
   type:"T",
   latitude:"34.7833",
   longitude:"137.183"}
  ,
  {name:"Apia, Samoa Islands",
   type:"T",
   latitude:"-13.8",
   longitude:"-171.7667"}
  ,
  {name:"Kanazawa, Ishikawa, Japan",
   type:"T",
   latitude:"36.6167",
   longitude:"136.6"}
  ,
  {name:"Bluff, New Zealand",
   type:"T",
   latitude:"-46.6",
   longitude:"168.35"}
  ,
  {name:"Herald Camp, Endeavour Strait",
   type:"T",
   latitude:"-10.9333",
   longitude:"142.15"}
  ,
  {name:"Fongafale, Funafuti, Tuvalu",
   type:"T",
   latitude:"-8.5333",
   longitude:"179.2"}
  ,
  {name:"Port Borden, Prince Edward Island",
   type:"T",
   latitude:"46.25",
   longitude:"-63.7"}
  ,
  {name:"Siranuka, Aomori, Japan",
   type:"T",
   latitude:"41.1333",
   longitude:"141.4"}
  ,
  {name:"Cobh, Ireland (2)",
   type:"T",
   latitude:"51.8333",
   longitude:"-8.3"}
  ,
  {name:"Mitaziri, Yamaguti, Japan",
   type:"T",
   latitude:"34.0333",
   longitude:"131.583"}
  ,
  {name:"Kaga Sima, Kumamoto, Japan",
   type:"T",
   latitude:"32.5167",
   longitude:"130.533"}
  ,
  {name:"Mergui, Myanmar",
   type:"T",
   latitude:"12.4333",
   longitude:"98.6"}
  ,
  {name:"Gosford, Australia",
   type:"T",
   latitude:"-33.4333",
   longitude:"151.35"}
  ,
  {name:"Hall Beach, Foxe Basin, Nunavut (2)",
   type:"T",
   latitude:"68.75",
   longitude:"-81.2167"}
  ,
  {name:"Utinoura, Ehime, Japan",
   type:"T",
   latitude:"33.3667",
   longitude:"132.05"}
  ,
  {name:"Bramble Cay, Coral Sea",
   type:"T",
   latitude:"-9.1333",
   longitude:"143.8667"}
  ,
  {name:"Sand Key Lighthouse, Sand Key Channel, Florida",
   type:"T",
   latitude:"24.4533",
   longitude:"-81.8767"}
  ,
  {name:"San Mateo Bridge (West), California (2)",
   type:"T",
   latitude:"37.5833",
   longitude:"-122.25"}
  ,
  {name:"Donoura, Tokusima, Japan",
   type:"T",
   latitude:"34.2167",
   longitude:"134.583"}
  ,
  {name:"Ugaiushak Island, Alaska",
   type:"T",
   latitude:"56.7967",
   longitude:"-156.8483"}
  ,
  {name:"Geraldton, Australia (2)",
   type:"T",
   latitude:"-28.7833",
   longitude:"114.5833"}
  ,
  {name:"Les Heaux de Brehat, France",
   type:"T",
   latitude:"48.9167",
   longitude:"-3.0833"}
  ,
  {name:"Aigura Point, Papua New Guinea",
   type:"T",
   latitude:"-10.1333",
   longitude:"150.25"}
  ,
  {name:"Forari, Vanuatu",
   type:"T",
   latitude:"-17.6833",
   longitude:"168.55"}
  ,
  {name:"Degerando Island, Australia",
   type:"T",
   latitude:"-15.3333",
   longitude:"124.1833"}
  ,
  {name:"Grassy, King Island, Tasmania",
   type:"T",
   latitude:"-40.0667",
   longitude:"144.0833"}
  ,
  {name:"Hososima, Miyazaki, Japan (2)",
   type:"T",
   latitude:"32.4333",
   longitude:"131.6667"}
  ,
  {name:"Vero Beach, Indian River, Florida",
   type:"T",
   latitude:"27.6333",
   longitude:"-80.375"}
  ,
  {name:"Yekaterininskaya, Russia",
   type:"T",
   latitude:"69.2",
   longitude:"33.4667"}
  ,
  {name:"Cape Deliverance, Papua New Guinea",
   type:"T",
   latitude:"-11.4",
   longitude:"154.2833"}
  ,
  {name:"Port Blair, Andaman Islands",
   type:"T",
   latitude:"11.6833",
   longitude:"92.7667"}
  ,
  {name:"Omati, Papua New Guinea (2)",
   type:"T",
   latitude:"-7.4333",
   longitude:"143.9667"}
  ,
  {name:"Sedgwick Bay, British Columbia (2)",
   type:"T",
   latitude:"52.6333",
   longitude:"-131.5667"}
  ,
  {name:"McKenney Islands, British Columbia",
   type:"T",
   latitude:"52.65",
   longitude:"-129.4833"}
  ,
  {name:"Taehuksan Do, South Korea",
   type:"T",
   latitude:"34.6833",
   longitude:"125.4333"}
  ,
  {name:"Wake Island, Pacific Ocean",
   type:"T",
   latitude:"19.29",
   longitude:"166.6183"}
  ,
  {name:"Sand Heads, British Columbia",
   type:"T",
   latitude:"49.1",
   longitude:"-123.3"}
  ,
  {name:"Winchelsea Island, British Columbia (2)",
   type:"T",
   latitude:"49.3",
   longitude:"-124.0833"}
  ,
  {name:"Seyðisfjörður, Iceland",
   type:"T",
   latitude:"65.2666",
   longitude:"-13.9833"}
  ,
  {name:"Moulmein, Myanmar",
   type:"T",
   latitude:"16.4833",
   longitude:"97.6167"}
  ,
  {name:"Manzanillo, Colima, Mexico",
   type:"T",
   latitude:"19.0533",
   longitude:"-104.33"}
  ,
  {name:"Osidomari, Hokkaido, Japan",
   type:"T",
   latitude:"45.2333",
   longitude:"141.233"}
  ,
  {name:"Pedder Bay, British Columbia",
   type:"T",
   latitude:"48.3333",
   longitude:"-123.55"}
  ,
  {name:"Ozello North, Crystal Bay, Florida",
   type:"T",
   latitude:"28.8633",
   longitude:"-82.6667"}
  ,
  {name:"Ito, Sizuoka, Japan",
   type:"T",
   latitude:"34.9667",
   longitude:"139.117"}
  ,
  {name:"Neuville, Québec",
   type:"T",
   latitude:"46.7",
   longitude:"-71.5667"}
  ,
  {name:"Green Cove Springs, St. Johns River, Florida",
   type:"T",
   latitude:"29.99",
   longitude:"-81.6633"}
  ,
  {name:"Tukarak, Québec",
   type:"T",
   latitude:"56.3167",
   longitude:"-78.0833"}
  ,
  {name:"Yawata, Japan",
   type:"T",
   latitude:"33.9167",
   longitude:"130.8167"}
  ,
  {name:"Kleybolt Peninsula, Nunavut",
   type:"T",
   latitude:"81.55",
   longitude:"-91.55"}
  ,
  {name:"Westernport, Australia",
   type:"T",
   latitude:"-38.3667",
   longitude:"145.2167"}
  ,
  {name:"Aberdeen, Scotland",
   type:"T",
   latitude:"57.15",
   longitude:"-2.0833"}
  ,
  {name:"Baleen Island, Nunavut",
   type:"T",
   latitude:"63.95",
   longitude:"-93.0833"}
  ,
  {name:"Kaligola Point, Papua New Guinea",
   type:"T",
   latitude:"-10.15",
   longitude:"148.2667"}
  ,
  {name:"Port Alma, Australia",
   type:"T",
   latitude:"-23.5833",
   longitude:"150.8667"}
  ,
  {name:"Ponce de Leon Inlet (inside), Florida",
   type:"T",
   latitude:"29.0633",
   longitude:"-80.915"}
  ,
  {name:"Huludao, Taiwan",
   type:"T",
   latitude:"23.0833",
   longitude:"120.9833"}
  ,
  {name:"Stopper Islands, British Columbia",
   type:"T",
   latitude:"49.0",
   longitude:"-125.35"}
  ,
  {name:"Gibraltar (U.K.) (2)",
   type:"T",
   latitude:"36.1333",
   longitude:"-5.35"}
  ,
  {name:"Miyako, Iwate, Japan",
   type:"T",
   latitude:"39.6333",
   longitude:"141.983"}
  ,
  {name:"Saint-Godefroi, Québec",
   type:"T",
   latitude:"48.0333",
   longitude:"-65.1"}
  ,
  {name:"Willemstad, Curaçao",
   type:"T",
   latitude:"12.1",
   longitude:"-68.9333"}
  ,
  {name:"Partridge Island, New Brunswick",
   type:"T",
   latitude:"45.2333",
   longitude:"-66.05"}
  ,
  {name:"Uchucklesit Inlet, British Columbia",
   type:"T",
   latitude:"49.0167",
   longitude:"-125.05"}
  ,
  {name:"Yatusiro, Kumamoto, Japan",
   type:"T",
   latitude:"32.5167",
   longitude:"130.567"}
  ,
  {name:"Throg's Neck, Long Island Sound, New York Current",
   type:"C",
   latitude:"40.8017",
   longitude:"-73.7883"}
  ,
  {name:"Iceberg Point, Nunavut",
   type:"T",
   latitude:"80.4167",
   longitude:"-86.0167"}
  ,
  {name:"Deep Cove, Nova Scotia",
   type:"T",
   latitude:"44.6667",
   longitude:"-65.8333"}
  ,
  {name:"Basilaki, Pitt Bay, Papua New Guinea",
   type:"T",
   latitude:"-10.6167",
   longitude:"151.05"}
  ,
  {name:"Menemsha Bight, Martha's Vineyard, Massachusetts",
   type:"T",
   latitude:"41.35",
   longitude:"-70.7667"}
  ,
  {name:"Flinders Reef, Coral Sea (2)",
   type:"T",
   latitude:"-17.8667",
   longitude:"148.5667"}
  ,
  {name:"Lark Harbour, Newfoundland",
   type:"T",
   latitude:"49.1",
   longitude:"-58.3667"}
  ,
  {name:"Ugusu, Sizuoka, Japan",
   type:"T",
   latitude:"34.85",
   longitude:"138.767"}
  ,
  {name:"Philadelphia, Pennsylvania",
   type:"T",
   latitude:"39.9533",
   longitude:"-75.1383"}
  ,
  {name:"Twin Islands, British Columbia (2)",
   type:"T",
   latitude:"50.0333",
   longitude:"-124.9333"}
  ,
  {name:"Chi-Lung, Taiwan",
   type:"T",
   latitude:"25.15",
   longitude:"121.75"}
  ,
  {name:"Emu Bay, Australia",
   type:"T",
   latitude:"-35.6",
   longitude:"137.5333"}
  ,
  {name:"Blubber Bay (Powell River Approaches), British Columbia (2)",
   type:"T",
   latitude:"49.8",
   longitude:"-124.6167"}
  ,
  {name:"Naoetu, Niigata, Japan",
   type:"T",
   latitude:"37.1833",
   longitude:"138.25"}
  ,
  {name:"Auckland, New Zealand",
   type:"T",
   latitude:"-36.85",
   longitude:"174.7667"}
  ,
  {name:"Tanoura, Hukuoka, Japan",
   type:"T",
   latitude:"33.95",
   longitude:"130.983"}
  ,
  {name:"Sabine Pass, North, Texas",
   type:"T",
   latitude:"29.73",
   longitude:"-93.87"}
  ,
  {name:"Bouverie Island, Nunavut",
   type:"T",
   latitude:"69.6333",
   longitude:"-82.2"}
  ,
  {name:"Ie (Okinawa), Okinawa, Japan",
   type:"T",
   latitude:"26.7",
   longitude:"127.8"}
  ,
  {name:"Kincolith, British Columbia (2)",
   type:"T",
   latitude:"55.0",
   longitude:"-129.9833"}
  ,
  {name:"Dark Cove, Dildo Run, Newfoundland",
   type:"T",
   latitude:"49.5333",
   longitude:"-54.75"}
  ,
  {name:"Port Dickson, Malaysia",
   type:"T",
   latitude:"2.5167",
   longitude:"101.7833"}
  ,
  {name:"Santos, Brazil",
   type:"T",
   latitude:"-23.95",
   longitude:"-46.3167"}
  ,
  {name:"Camp Latona Beach, British Columbia",
   type:"T",
   latitude:"49.5333",
   longitude:"-123.3833"}
  ,
  {name:"Large Islet, Australia",
   type:"T",
   latitude:"-21.3",
   longitude:"115.5"}
  ,
  {name:"Tokuyama, Yamaguti, Japan",
   type:"T",
   latitude:"34.0333",
   longitude:"131.8"}
  ,
  {name:"Fundy (Offshore 23), Nova Scotia",
   type:"T",
   latitude:"40.3667",
   longitude:"-67.75"}
  ,
  {name:"King Edward Point, Nunavut",
   type:"T",
   latitude:"76.1333",
   longitude:"-81.0667"}
  ,
  {name:"Sergius Narrows, Peril Strait, Alaska Current",
   type:"C",
   latitude:"57.4067",
   longitude:"-135.6267"}
  ,
  {name:"Yasugi, Simane, Japan",
   type:"T",
   latitude:"35.4333",
   longitude:"133.267"}
  ,
  {name:"Sullivan Bay, British Columbia",
   type:"T",
   latitude:"50.8833",
   longitude:"-126.7"}
  ,
  {name:"Port-Vila, Vanuatu",
   type:"T",
   latitude:"-17.75",
   longitude:"168.3167"}
  ,
  {name:"Humboldt Bay, North Spit, California (2) (expired 1993-12-31)",
   type:"T",
   latitude:"40.7667",
   longitude:"-124.2167"}
  ,
  {name:"Klaxton Creek, British Columbia",
   type:"T",
   latitude:"54.0833",
   longitude:"-130.0833"}
  ,
  {name:"Miami Harbor Entrance, Florida",
   type:"T",
   latitude:"25.7683",
   longitude:"-80.1317"}
  ,
  {name:"Aguire, Argentina",
   type:"T",
   latitude:"-54.9167",
   longitude:"-65.9667"}
  ,
  {name:"Mazatlán, Sinaloa, Mexico",
   type:"T",
   latitude:"23.1983",
   longitude:"-106.4217"}
  ,
  {name:"General Dynamics Pier, Cooper River, South Carolina",
   type:"T",
   latitude:"33.015",
   longitude:"-79.9233"}
  ,
  {name:"San Francisco, California",
   type:"T",
   latitude:"37.8067",
   longitude:"-122.465"}
  ,
  {name:"Piper Island, Australia",
   type:"T",
   latitude:"-12.25",
   longitude:"143.25"}
  ,
  {name:"Glendale Cove, British Columbia",
   type:"T",
   latitude:"50.6667",
   longitude:"-125.7333"}
  ,
  {name:"Seal Island, Nova Scotia",
   type:"T",
   latitude:"43.4833",
   longitude:"-66.0"}
  ,
  {name:"Patreksfjörður, Iceland",
   type:"T",
   latitude:"65.5833",
   longitude:"-24.0"}
  ,
  {name:"Tomioka (Amakusa), Kumamoto, Japan",
   type:"T",
   latitude:"32.5333",
   longitude:"130.033"}
  ,
  {name:"Grande-Vallée, Québec",
   type:"T",
   latitude:"49.2333",
   longitude:"-65.1333"}
  ,
  {name:"Tampico Harbor (Madero), Tamaulipas, Mexico",
   type:"T",
   latitude:"22.2167",
   longitude:"-97.85"}
  ,
  {name:"Alcatraz (North Point), San Francisco Bay, California Current",
   type:"C",
   latitude:"37.8267",
   longitude:"-122.4167"}
  ,
  {name:"Louisbourg, Nova Scotia",
   type:"T",
   latitude:"45.9167",
   longitude:"-59.9667"}
  ,
  {name:"Grand Manan Channel (Bay of Fundy Entrance), New Brunswick Current",
   type:"C",
   latitude:"44.7533",
   longitude:"-66.9317"}
  ,
  {name:"North Barnard Island, Australia",
   type:"T",
   latitude:"-17.6833",
   longitude:"146.1833"}
  ,
  {name:"Rigby Bay, Nunavut",
   type:"T",
   latitude:"74.55",
   longitude:"-90.0167"}
  ,
  {name:"Kings Bay NSB, Kings Bay, Cumberland Sound, Georgia",
   type:"T",
   latitude:"30.7967",
   longitude:"-81.515"}
  ,
  {name:"Kumul Tkr Mrg, Papua New Guinea",
   type:"T",
   latitude:"-8.1333",
   longitude:"144.5667"}
  ,
  {name:"San Juan, Puerto Rico (3)",
   type:"T",
   latitude:"18.4617",
   longitude:"-66.115"}
  ,
  {name:"Odomari (Kagosima), Kagosima, Japan",
   type:"T",
   latitude:"31.0167",
   longitude:"130.683"}
  ,
  {name:"Raynor Group, British Columbia (2)",
   type:"T",
   latitude:"50.8833",
   longitude:"-127.2333"}
  ,
  {name:"Setoda, Hirosima, Japan",
   type:"T",
   latitude:"34.3",
   longitude:"133.083"}
  ,
  {name:"Lagoon Cove, British Columbia",
   type:"T",
   latitude:"50.6",
   longitude:"-126.3167"}
  ,
  {name:"Tarumizu, Kagosima, Japan",
   type:"T",
   latitude:"31.5",
   longitude:"130.7"}
  ,
  {name:"Orange Bay, Chile",
   type:"T",
   latitude:"-55.5167",
   longitude:"-68.0833"}
  ,
  {name:"Kikuma, Ehime, Japan",
   type:"T",
   latitude:"34.0333",
   longitude:"132.833"}
  ,
  {name:"Matavai, Tahiti",
   type:"T",
   latitude:"-17.5167",
   longitude:"-149.5167"}
  ,
  {name:"Roggan-River, Québec",
   type:"T",
   latitude:"54.3833",
   longitude:"-79.05"}
  ,
  {name:"Leixoes, Portugal",
   type:"T",
   latitude:"41.1833",
   longitude:"-8.7"}
  ,
  {name:"Caraquet Harbour, New Brunswick",
   type:"T",
   latitude:"47.8",
   longitude:"-64.9333"}
  ,
  {name:"Dahlgren, Upper Machodoc Creek, Virginia",
   type:"T",
   latitude:"38.32",
   longitude:"-77.0367"}
  ,
  {name:"Odomari (Senzaki), Yamaguti, Japan",
   type:"T",
   latitude:"34.4",
   longitude:"131.183"}
  ,
  {name:"Hampton Roads, Virginia",
   type:"T",
   latitude:"36.9467",
   longitude:"-76.33"}
  ,
  {name:"Grise Fiord, Nunavut",
   type:"T",
   latitude:"76.4167",
   longitude:"-83.0833"}
  ,
  {name:"Skinner's Pond, Prince Edward Island",
   type:"T",
   latitude:"46.95",
   longitude:"-64.1167"}
  ,
  {name:"Barnard Harbour, British Columbia",
   type:"T",
   latitude:"53.0833",
   longitude:"-129.1167"}
  ,
  {name:"Lawyer Island, British Columbia",
   type:"T",
   latitude:"54.1333",
   longitude:"-130.0333"}
  ,
  {name:"Unimak Pass (off Scotch Cap), Alaska Current",
   type:"C",
   latitude:"54.365",
   longitude:"-164.8"}
  ,
  {name:"Wellington, New Zealand",
   type:"T",
   latitude:"-41.2833",
   longitude:"174.7833"}
  ,
  {name:"Oita-Turusaki, Oita, Japan (2)",
   type:"T",
   latitude:"33.2667",
   longitude:"131.6833"}
  ,
  {name:"Isla Guadalupe, Baja California Norte, Mexico",
   type:"T",
   latitude:"28.8817",
   longitude:"-118.2933"}
  ,
  {name:"Unten, Okinawa, Japan",
   type:"T",
   latitude:"26.6667",
   longitude:"128.017"}
  ,
  {name:"St. Johns River Entrance, Florida Current (2) (expired 1999-12-31)",
   type:"C",
   latitude:"30.4",
   longitude:"-81.3833"}
  ,
  {name:"Point Reyes, California (2)",
   type:"T",
   latitude:"37.9967",
   longitude:"-122.975"}
  ,
  {name:"Grundarfjörður, Iceland",
   type:"T",
   latitude:"64.9333",
   longitude:"-23.25"}
  ,
  {name:"Kincolith, British Columbia",
   type:"T",
   latitude:"55.0",
   longitude:"-129.9833"}
  ,
  {name:"Dannoura (Simonoseki), Yamaguti, Japan (2)",
   type:"T",
   latitude:"33.9667",
   longitude:"130.95"}
  ,
  {name:"Shushartie Bay, British Columbia",
   type:"T",
   latitude:"50.85",
   longitude:"-127.85"}
  ,
  {name:"Île Brion, Magdalen, Québec",
   type:"T",
   latitude:"47.7833",
   longitude:"-61.5"}
  ,
  {name:"Becher Bay, British Columbia",
   type:"T",
   latitude:"48.3333",
   longitude:"-123.6333"}
  ,
  {name:"Port Campbell, Australia",
   type:"T",
   latitude:"-38.6333",
   longitude:"143.0"}
  ,
  {name:"Baltimore (Fort McHenry), Maryland",
   type:"T",
   latitude:"39.2667",
   longitude:"-76.5783"}
  ,
  {name:"Jazireh-ye Lavan, Iran",
   type:"T",
   latitude:"26.8",
   longitude:"52.3833"}
  ,
  {name:"Usu Wan, Hokkaido, Japan",
   type:"T",
   latitude:"42.5167",
   longitude:"140.767"}
  ,
  {name:"Miike, Hukuoka, Japan (2)",
   type:"T",
   latitude:"33.0167",
   longitude:"130.4167"}
  ,
  {name:"Summerside, Prince Edward Island",
   type:"T",
   latitude:"46.3833",
   longitude:"-63.7833"}
  ,
  {name:"Booby Island, Torres Strait (2)",
   type:"T",
   latitude:"-10.6",
   longitude:"141.9167"}
  ,
  {name:"Manta, Ecuador",
   type:"T",
   latitude:"-0.9333",
   longitude:"-80.7167"}
  ,
  {name:"Honolulu, Oahu (Hawaii) (2) (expired 1989-12-31)",
   type:"T",
   latitude:"21.3067",
   longitude:"-157.8667"}
  ,
  {name:"Nelson, New Zealand",
   type:"T",
   latitude:"-41.2667",
   longitude:"173.2667"}
  ,
  {name:"Winter Harbour, British Columbia (2)",
   type:"T",
   latitude:"50.5167",
   longitude:"-128.0"}
  ,
  {name:"Mera-Koura, Sizuoka, Japan",
   type:"T",
   latitude:"34.6667",
   longitude:"138.783"}
  ,
  {name:"Blanc Sablon, Québec",
   type:"T",
   latitude:"51.4167",
   longitude:"-57.15"}
  ,
  {name:"Cape Southwest, Nunavut",
   type:"T",
   latitude:"78.2167",
   longitude:"-91.0833"}
  ,
  {name:"George Washington Bridge (Hudson River), New York Current",
   type:"C",
   latitude:"40.85",
   longitude:"-73.95"}
  ,
  {name:"Garibaldi, Oregon",
   type:"T",
   latitude:"45.5583",
   longitude:"-123.9117"}
  ,
  {name:"Windmill Point, Rappahannock River, Virginia (2)",
   type:"T",
   latitude:"37.6117",
   longitude:"-76.275"}
  ,
  {name:"Miners Bay, British Columbia (2)",
   type:"T",
   latitude:"48.85",
   longitude:"-123.3"}
  ,
  {name:"Little Ferry, New Jersey",
   type:"T",
   latitude:"40.8467",
   longitude:"-74.0317"}
  ,
  {name:"Yosimo, Yamaguti, Japan",
   type:"T",
   latitude:"34.0833",
   longitude:"130.867"}
  ,
  {name:"Upper Gagetown, New Brunswick",
   type:"T",
   latitude:"45.85",
   longitude:"-66.2333"}
  ,
  {name:"Half Moon Bay, California",
   type:"T",
   latitude:"37.5",
   longitude:"-122.4833"}
  ,
  {name:"New Westminster, British Columbia",
   type:"T",
   latitude:"49.1833",
   longitude:"-122.9"}
  ,
  {name:"Saint-Jean-de-Luz, France",
   type:"T",
   latitude:"43.3833",
   longitude:"-1.6667"}
  ,
  {name:"Konoura, Akita, Japan",
   type:"T",
   latitude:"39.25",
   longitude:"139.917"}
  ,
  {name:"Maxwell Bay, Nunavut",
   type:"T",
   latitude:"74.6833",
   longitude:"-88.9"}
  ,
  {name:"Saltery Bay, British Columbia (2)",
   type:"T",
   latitude:"49.7833",
   longitude:"-124.1833"}
  ,
  {name:"Naples (outer coast), Florida (2)",
   type:"T",
   latitude:"26.13",
   longitude:"-81.8067"}
  ,
  {name:"North Lake Harbour, Prince Edward Island",
   type:"T",
   latitude:"46.4667",
   longitude:"-62.0667"}
  ,
  {name:"Bremerhaven, Germany",
   type:"T",
   latitude:"53.5333",
   longitude:"8.5833"}
  ,
  {name:"Cumberland Basin, Nova Scotia",
   type:"T",
   latitude:"45.6667",
   longitude:"-64.5167"}
  ,
  {name:"Punchbowl, Labrador",
   type:"T",
   latitude:"53.25",
   longitude:"-55.7667"}
  ,
  {name:"Haiki Jetty (N.side), Nagasaki, Japan",
   type:"T",
   latitude:"33.1333",
   longitude:"129.8"}
  ,
  {name:"Pelican Island (North Coast), Australia",
   type:"T",
   latitude:"-14.7667",
   longitude:"128.7833"}
  ,
  {name:"Ei, Hyogo, Japan",
   type:"T",
   latitude:"34.4667",
   longitude:"134.817"}
  ,
  {name:"Chatham Point, British Columbia",
   type:"T",
   latitude:"50.3333",
   longitude:"-125.4333"}
  ,
  {name:"Areia Branca, Brazil",
   type:"T",
   latitude:"-4.8167",
   longitude:"-37.0333"}
  ,
  {name:"Gulfport, Gulfport Harbor, Mississippi",
   type:"T",
   latitude:"30.36",
   longitude:"-89.0817"}
  ,
  {name:"St. Mary's, Isles Of Scilly, England",
   type:"T",
   latitude:"49.9167",
   longitude:"-6.3167"}
  ,
  {name:"Kaunakakai, Molokai (Hawaii)",
   type:"T",
   latitude:"21.085",
   longitude:"-157.0317"}
  ,
  {name:"Sizugawa, Miyagi, Japan",
   type:"T",
   latitude:"38.6667",
   longitude:"141.45"}
  ,
  {name:"Suehiro (Turumi), Kanagawa, Japan",
   type:"T",
   latitude:"35.4833",
   longitude:"139.7"}
  ,
  {name:"Havre Aubert (Amherst), Nova Scotia",
   type:"T",
   latitude:"47.2333",
   longitude:"-61.8472"}
  ,
  {name:"Tomlee Bay, Nova Scotia",
   type:"T",
   latitude:"44.8333",
   longitude:"-62.6"}
  ,
  {name:"Fundy (Offshore 6), Nova Scotia",
   type:"T",
   latitude:"42.4667",
   longitude:"-67.7167"}
  ,
  {name:"Cádiz, Spain (2)",
   type:"T",
   latitude:"36.5333",
   longitude:"-6.2833"}
  ,
  {name:"Minamata, Kumamoto, Japan",
   type:"T",
   latitude:"32.2",
   longitude:"130.383"}
  ,
  {name:"Franklin River, British Columbia (2)",
   type:"T",
   latitude:"49.1",
   longitude:"-124.8167"}
  ,
  {name:"Gordon Point, New Brunswick",
   type:"T",
   latitude:"47.0833",
   longitude:"-65.4"}
  ,
  {name:"Hibernia 109, Newfoundland",
   type:"T",
   latitude:"46.8667",
   longitude:"-48.7167"}
  ,
  {name:"Puerto San Antonio, Argentina",
   type:"T",
   latitude:"-40.8",
   longitude:"-64.8667"}
  ,
  {name:"Anamizu, Ishikawa, Japan",
   type:"T",
   latitude:"37.2167",
   longitude:"136.917"}
  ,
  {name:"Nurse Channel, Bahamas",
   type:"T",
   latitude:"22.5167",
   longitude:"-75.85"}
  ,
  {name:"Ra's al Qulay`ah, Saudi Arabia",
   type:"T",
   latitude:"26.8667",
   longitude:"49.9"}
  ,
  {name:"Akkesi, Hokkaido, Japan",
   type:"T",
   latitude:"43.0333",
   longitude:"144.85"}
  ,
  {name:"Port Romilly, Papua New Guinea",
   type:"T",
   latitude:"-7.6667",
   longitude:"144.8333"}
  ,
  {name:"Santo Antonio, Zaire",
   type:"T",
   latitude:"-6.1167",
   longitude:"12.3667"}
  ,
  {name:"Kuala Trengganu, Malaysia",
   type:"T",
   latitude:"5.35",
   longitude:"103.1333"}
  ,
  {name:"Caesar Creek, Biscayne Bay, Florida Current",
   type:"C",
   latitude:"25.3867",
   longitude:"-80.2267"}
  ,
  {name:"Port Daniel, Québec",
   type:"T",
   latitude:"48.1833",
   longitude:"-64.95"}
  ,
  {name:"Nakai Iri, Ishikawa, Japan",
   type:"T",
   latitude:"37.2333",
   longitude:"136.95"}
  ,
  {name:"Monbetu, Hokkaido, Japan (2)",
   type:"T",
   latitude:"44.35",
   longitude:"143.3667"}
  ,
  {name:"Moonstone Beach, Rhode Island",
   type:"T",
   latitude:"41.3667",
   longitude:"-71.55"}
  ,
  {name:"Mukogasaki, Kanagawa, Japan",
   type:"T",
   latitude:"35.1333",
   longitude:"139.617"}
  ,
  {name:"Warrnambool, Australia",
   type:"T",
   latitude:"-38.4",
   longitude:"142.8167"}
  ,
  {name:"Egmont, British Columbia",
   type:"T",
   latitude:"49.75",
   longitude:"-123.9333"}
  ,
  {name:"Belle Cote Breakwater, Nova Scotia",
   type:"T",
   latitude:"46.4333",
   longitude:"-61.0833"}
  ,
  {name:"Seal Bay, Nunavut",
   type:"T",
   latitude:"69.5167",
   longitude:"-98.5167"}
  ,
  {name:"Campbell River, British Columbia (2)",
   type:"T",
   latitude:"50.0167",
   longitude:"-125.2333"}
  ,
  {name:"Isla Baltra, Galapagos Islands",
   type:"T",
   latitude:"-0.45",
   longitude:"-90.2833"}
  ,
  {name:"Sedgwick Bay, British Columbia",
   type:"T",
   latitude:"52.6333",
   longitude:"-131.5667"}
  ,
  {name:"Avarua, Rarotonga",
   type:"T",
   latitude:"-21.2",
   longitude:"-159.9333"}
  ,
  {name:"Robichaud Spit, New Brunswick",
   type:"T",
   latitude:"47.1167",
   longitude:"-65.25"}
  ,
  {name:"Goaribari Island, Papua New Guinea (2)",
   type:"T",
   latitude:"-7.75",
   longitude:"144.2"}
  ,
  {name:"St. Stephen, New Brunswick",
   type:"T",
   latitude:"45.2",
   longitude:"-67.2833"}
  ,
  {name:"Galveston Bay Entrance, Texas Current",
   type:"C",
   latitude:"29.3467",
   longitude:"-94.705"}
  ,
  {name:"Nauset Harbor, Cape Cod, Massachusetts",
   type:"T",
   latitude:"41.8",
   longitude:"-69.9333"}
  ,
  {name:"Bandar-e Lengeh, Iran",
   type:"T",
   latitude:"26.55",
   longitude:"54.8833"}
  ,
  {name:"Hickman's Harbour, Newfoundland",
   type:"T",
   latitude:"48.1",
   longitude:"-53.7333"}
  ,
  {name:"Talbert Island, River Shannon, Ireland",
   type:"T",
   latitude:"52.5833",
   longitude:"-9.3667"}
  ,
  {name:"Buenos Aires, Argentina",
   type:"T",
   latitude:"-34.6",
   longitude:"-58.3667"}
  ,
  {name:"Northwest Solitary Island, Australia",
   type:"T",
   latitude:"-30.0167",
   longitude:"153.2833"}
  ,
  {name:"Aokata, Nagasaki, Japan",
   type:"T",
   latitude:"33.0",
   longitude:"129.05"}
  ,
  {name:"Cartwright Harbour, Labrador",
   type:"T",
   latitude:"53.7",
   longitude:"-57.0333"}
  ,
  {name:"Sasebo, Nagasaki, Japan",
   type:"T",
   latitude:"33.15",
   longitude:"129.733"}
  ,
  {name:"San Francisco, California (2) (expired 1998-12-31)",
   type:"T",
   latitude:"37.8067",
   longitude:"-122.465"}
  ,
  {name:"Marblehead, Massachusetts",
   type:"T",
   latitude:"42.5",
   longitude:"-70.85"}
  ,
  {name:"White Island, Australia",
   type:"T",
   latitude:"-15.0667",
   longitude:"124.6667"}
  ,
  {name:"Southampton, England (2)",
   type:"T",
   latitude:"50.9",
   longitude:"-1.4"}
  ,
  {name:"Broughton Island, Australia",
   type:"T",
   latitude:"-32.6167",
   longitude:"152.3333"}
  ,
  {name:"Mera, Tiba, Japan",
   type:"T",
   latitude:"34.9167",
   longitude:"139.833"}
  ,
  {name:"Snake Bay, Australia",
   type:"T",
   latitude:"-11.4",
   longitude:"130.6833"}
  ,
  {name:"Monte Hermoso, Argentina",
   type:"T",
   latitude:"-38.9833",
   longitude:"-61.6833"}
  ,
  {name:"Myrtle Beach, South Carolina",
   type:"T",
   latitude:"33.6833",
   longitude:"-78.885"}
  ,
  {name:"Simabara, Nagasaki, Japan",
   type:"T",
   latitude:"32.7667",
   longitude:"130.367"}
  ,
  {name:"Bay Waveland Yacht Club, Bay St. Louis, Mississippi",
   type:"T",
   latitude:"30.325",
   longitude:"-89.325"}
  ,
  {name:"Brooksby Point, British Columbia",
   type:"T",
   latitude:"48.9833",
   longitude:"-124.9833"}
  ,
  {name:"Harmac, British Columbia",
   type:"T",
   latitude:"49.1333",
   longitude:"-123.85"}
  ,
  {name:"Ashe Inlet, Big Island, Nunavut",
   type:"T",
   latitude:"62.55",
   longitude:"-70.5833"}
  ,
  {name:"Shields Bay, British Columbia",
   type:"T",
   latitude:"53.3167",
   longitude:"-132.4167"}
  ,
  {name:"Broad Creek, Hilton Head Island, South Carolina",
   type:"T",
   latitude:"32.1833",
   longitude:"-80.75"}
  ,
  {name:"Rivière-Au-Renard, Québec",
   type:"T",
   latitude:"49.0",
   longitude:"-64.3833"}
  ,
  {name:"Cedar Point, Maryland",
   type:"T",
   latitude:"38.2983",
   longitude:"-76.37"}
  ,
  {name:"Hirao, Yamaguti, Japan",
   type:"T",
   latitude:"33.9167",
   longitude:"132.05"}
  ,
  {name:"Osaka, Osaka, Japan (2)",
   type:"T",
   latitude:"34.65",
   longitude:"135.4333"}
  ,
  {name:"Pelican Island (East Coast), Australia",
   type:"T",
   latitude:"-13.9",
   longitude:"143.8333"}
  ,
  {name:"Hook Island, Nunavut",
   type:"T",
   latitude:"53.4333",
   longitude:"-79.1167"}
  ,
  {name:"Saibai Island, Torres Strait",
   type:"T",
   latitude:"-9.3833",
   longitude:"142.6167"}
  ,
  {name:"Doctor Island, Québec",
   type:"T",
   latitude:"61.6833",
   longitude:"-71.5667"}
  ,
  {name:"William Head, Washington",
   type:"T",
   latitude:"48.0333",
   longitude:"-123.5333"}
  ,
  {name:"Grondines, Québec (2)",
   type:"T",
   latitude:"46.5833",
   longitude:"-72.0333"}
  ,
  {name:"Kamoise, Nagasaki, Japan",
   type:"T",
   latitude:"34.3333",
   longitude:"129.383"}
  ,
  {name:"South Jamesport, Gt. Peconic Bay, New York",
   type:"T",
   latitude:"40.935",
   longitude:"-72.5767"}
  ,
  {name:"Hay Point, Australia (2)",
   type:"T",
   latitude:"-21.2667",
   longitude:"149.3"}
  ,
  {name:"Tufi Harbour, Papua New Guinea",
   type:"T",
   latitude:"-9.0833",
   longitude:"149.3167"}
  ,
  {name:"Camp Cove, Australia",
   type:"T",
   latitude:"-33.8333",
   longitude:"151.2833"}
  ,
  {name:"Secaucus, New Jersey",
   type:"T",
   latitude:"40.7983",
   longitude:"-74.07"}
  ,
  {name:"Tiromo, Nagasaki, Japan",
   type:"T",
   latitude:"34.4",
   longitude:"129.383"}
  ,
  {name:"Clifton, Newfoundland",
   type:"T",
   latitude:"48.1833",
   longitude:"-53.7333"}
  ,
  {name:"Leith, Scotland",
   type:"T",
   latitude:"55.9833",
   longitude:"-3.1667"}
  ,
  {name:"Moen Island, Chuuk, F.S.M.",
   type:"T",
   latitude:"7.4467",
   longitude:"151.8467"}
  ,
  {name:"Little Talbot Island, Florida",
   type:"T",
   latitude:"30.43",
   longitude:"-81.405"}
  ,
  {name:"Charlottetown, Newfoundland",
   type:"T",
   latitude:"48.4333",
   longitude:"-54.0167"}
  ,
  {name:"Beachley (Aust), River Severn, England",
   type:"T",
   latitude:"51.6",
   longitude:"-2.6333"}
  ,
  {name:"Squamish, British Columbia (3)",
   type:"T",
   latitude:"49.7",
   longitude:"-123.15"}
  ,
  {name:"Gisborne, New Zealand (2)",
   type:"T",
   latitude:"-38.6833",
   longitude:"178.0333"}
  ,
  {name:"Luanda, Angola",
   type:"T",
   latitude:"-8.7833",
   longitude:"13.2333"}
  ,
  {name:"Cape Wilson 1, Nunavut",
   type:"T",
   latitude:"67.0667",
   longitude:"-81.3667"}
  ,
  {name:"Hilton Head, South Carolina",
   type:"T",
   latitude:"32.2333",
   longitude:"-80.6667"}
  ,
  {name:"Goose Island, Australia",
   type:"T",
   latitude:"-34.0833",
   longitude:"123.1833"}
  ,
  {name:"Night Cliff, Australia",
   type:"T",
   latitude:"-12.3833",
   longitude:"130.8333"}
  ,
  {name:"To-No-Ura (Hamada), Simane, Japan",
   type:"T",
   latitude:"34.9",
   longitude:"132.067"}
  ,
  {name:"Nanao, Ishikawa, Japan",
   type:"T",
   latitude:"37.05",
   longitude:"136.967"}
  ,
  {name:"Kyuquot, British Columbia (2)",
   type:"T",
   latitude:"50.0333",
   longitude:"-127.3667"}
  ,
  {name:"Village Bay, British Columbia (2)",
   type:"T",
   latitude:"48.85",
   longitude:"-123.3167"}
  ,
  {name:"St. Johns River at Main Street Bridge, Florida",
   type:"T",
   latitude:"30.3231",
   longitude:"-81.6639"}
  ,
  {name:"O Sima (Kurusima), Ehime, Japan",
   type:"T",
   latitude:"34.1167",
   longitude:"132.983"}
  ,
  {name:"Patunungan Bay, Philippines",
   type:"T",
   latitude:"18.4",
   longitude:"122.3"}
  ,
  {name:"San Francisco Bay Entrance (Golden Gate), California Current",
   type:"C",
   latitude:"37.8167",
   longitude:"-122.4833"}
  ,
  {name:"Bramble Cove, Tasmania",
   type:"T",
   latitude:"-43.3167",
   longitude:"146.0"}
  ,
  {name:"Port Refuge, Cocos Islands",
   type:"T",
   latitude:"-12.0833",
   longitude:"96.8833"}
  ,
  {name:"Burnie, Tasmania (2)",
   type:"T",
   latitude:"-41.05",
   longitude:"145.95"}
  ,
  {name:"Seeadler Harbour, Papua New Guinea",
   type:"T",
   latitude:"-2.0167",
   longitude:"147.2667"}
  ,
  {name:"Tapa Bay, Australia",
   type:"T",
   latitude:"-12.45",
   longitude:"130.6"}
  ,
  {name:"Alison Sound, British Columbia",
   type:"T",
   latitude:"51.15",
   longitude:"-127.0"}
  ,
  {name:"Cheticamp, Nova Scotia",
   type:"T",
   latitude:"46.6333",
   longitude:"-61.0167"}
  ,
  {name:"Cutler, Little River, Maine (2)",
   type:"T",
   latitude:"44.65",
   longitude:"-67.2167"}
  ,
  {name:"Titusville, Indian River, Florida",
   type:"T",
   latitude:"28.62",
   longitude:"-80.8"}
  ,
  {name:"Bandar Abbas, Iran",
   type:"T",
   latitude:"27.1833",
   longitude:"56.2833"}
  ,
  {name:"Ponquogue Bridge, Shinnecock Bay, Long Island, New York",
   type:"T",
   latitude:"40.85",
   longitude:"-72.5"}
  ,
  {name:"The Narrows, Midchannel, New York Harbor, New York Current",
   type:"C",
   latitude:"40.61",
   longitude:"-74.0467"}
  ,
  {name:"Udono, Mie, Japan",
   type:"T",
   latitude:"33.7333",
   longitude:"136.017"}
  ,
  {name:"Wangjia Wan, China",
   type:"T",
   latitude:"36.8667",
   longitude:"122.4"}
  ,
  {name:"Dannoura (Simonoseki), Yamaguti, Japan",
   type:"T",
   latitude:"33.9667",
   longitude:"130.95"}
  ,
  {name:"Bergen, Norway",
   type:"T",
   latitude:"60.4",
   longitude:"5.3"}
  ,
  {name:"Cooktown, Australia",
   type:"T",
   latitude:"-15.4667",
   longitude:"145.25"}
  ,
  {name:"Weipa, Australia",
   type:"T",
   latitude:"-12.6833",
   longitude:"141.8833"}
  ,
  {name:"Cutler, Little River, Maine",
   type:"T",
   latitude:"44.6567",
   longitude:"-67.21"}
  ,
  {name:"Onslow, Australia",
   type:"T",
   latitude:"-21.6333",
   longitude:"115.1"}
  ,
  {name:"Blandford, Nova Scotia",
   type:"T",
   latitude:"44.5",
   longitude:"-64.0833"}
  ,
  {name:"No Name Key, east side, Bahía Honda Channel, Florida",
   type:"T",
   latitude:"24.6983",
   longitude:"-81.3183"}
  ,
  {name:"Cairns, Australia (2)",
   type:"T",
   latitude:"-16.9167",
   longitude:"145.7833"}
  ,
  {name:"Mackay Outer Harbour, Australia (2)",
   type:"T",
   latitude:"-21.1167",
   longitude:"149.2333"}
  ,
  {name:"Champlain, Québec",
   type:"T",
   latitude:"46.4333",
   longitude:"-72.35"}
  ,
  {name:"Ocean City, New Jersey",
   type:"T",
   latitude:"39.2833",
   longitude:"-74.5817"}
  ,
  {name:"Iwaihukuro, Tiba, Japan",
   type:"T",
   latitude:"35.1",
   longitude:"139.833"}
  ,
  {name:"Kasumi, Hyogo, Japan",
   type:"T",
   latitude:"35.65",
   longitude:"134.633"}
  ,
  {name:"Samugawa, Tiba, Japan",
   type:"T",
   latitude:"35.5833",
   longitude:"140.117"}
  ,
  {name:"Syamanbe, Hokkaido, Japan",
   type:"T",
   latitude:"45.3333",
   longitude:"148.017"}
  ,
  {name:"Kunehama, Nagasaki, Japan",
   type:"T",
   latitude:"34.1667",
   longitude:"129.183"}
);
