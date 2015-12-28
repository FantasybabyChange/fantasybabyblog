/*test search */
SELECT c.categoryname,p.pname FROM _category c,category_privilege cp,_privilege p 
WHERE c.categorycode=cp.categorycode AND p.pcode =  cp.privilegecode AND c.categorycode='admin'