SELECT *FROM category_privilege cp,_privilege pr WHERE cp.privilegeid=pr.pid AND cp.categoryid=1;
DELETE FROM category_privilege cp WHERE cp._uuid IN ();
/*
查找出权限表中重复 多字段的
*/
SELECT *FROM category_privilege cp WHERE (cp.privilegeid,categoryid) 
IN (SELECT sucp.privilegeid,sucp.categoryid FROM category_privilege sucp 
GROUP BY sucp.privilegeid,sucp.categoryid 
HAVING COUNT(sucp._uuid) > 1
 ) AND cp._uuid NOT IN(SELECT ccp._uuid FROM category_privilege ccp GROUP BY ccp.privilegeid,ccp.categoryid HAVING
COUNT(*)>
1) 

DELETE  FROM category_privilege   WHERE _uuid IN(
SELECT categorySum._uuid FROM(SELECT cp.* FROM category_privilege cp WHERE (cp.privilegeid,categoryid) 
IN (SELECT sucp.privilegeid,sucp.categoryid FROM category_privilege sucp 
GROUP BY sucp.privilegeid,sucp.categoryid 
HAVING COUNT(sucp._uuid) > 1
 ) AND cp._uuid NOT IN(SELECT ccp._uuid FROM category_privilege ccp GROUP BY ccp.privilegeid,ccp.categoryid HAVING
COUNT(*)>1) 
)  categorySum
)



/*test search */
SELECT c.categoryname,p.pname FROM _category c,category_privilege cp,_privilege p 
WHERE c.categorycode=cp.categorycode AND p.pcode =  cp.privilegecode
