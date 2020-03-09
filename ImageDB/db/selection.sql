select distinct i.name 
from images i, tags t 
where t.imgname = i.name and
            (upper(t.label) like '%RANGIROA%' or
             upper(t.label) like '%CORINE%'); 