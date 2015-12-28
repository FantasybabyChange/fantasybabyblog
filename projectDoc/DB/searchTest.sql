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


INSERT INTO _privilege(_uuid,pName,pCode,pPath,parentcode,`order`,is_show) VALUES
 ('76b47e3d-5bbc-431f-a3de-a1dede060250','首页','home','/home',NULL,0,1)
 (STRING), (STRING), (STRING), (STRING), NULL, 0(INTEGER), 1(INTEGER)