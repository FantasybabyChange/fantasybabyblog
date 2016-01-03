/*test search */
SELECT c.categoryname,p.pname FROM _category c,category_privilege cp,_privilege p 
WHERE c.categorycode=cp.categorycode AND p.pcode =  cp.privilegecode AND c.categorycode='admin';
SELECT *FROM blog_user;
SELECT p.pname FROM blog_user bu,_category c,category_privilege cp,_privilege p 
WHERE bu.categorycode=c.categorycode AND c.categorycode=cp.categorycode AND cp.privilegecode=p.pcode
AND bu._id=1
SELECT *FROM blog_user;
SELECT *FROM _category;
SELECT *FROM _privilege GROUP BY parent;
DESC _privilege;
