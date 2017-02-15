/* Transaction ó��(or ����)
 * : �۾� ������ ���� 
 * �ֿ� ���- DCL(Data Control Langauge)
 * commt : ���� �����ͺ��̽��� �۾������� �ݿ�
 * rollback : �۾������� ���
 * 
 * JDBC �� Auto Commit�� �⺻�̴�.
 * Transaction ��� �ʿ��� ��쿡��
 * Auto Commit �Ӽ��� �����Ͽ� ���� Ŀ�� ���� ������ �� 
 * ( connection.setAutoCommit(false) )
 * �۾� ���������� ��� �۾��� ���������� ����Ǹ�
 * connection.commit(); --> ���� db�� �ݿ�
 * ������ �߻��Ǹ� 
 * connection.rollback(); --> �۾� ���
 * 
 * ���)  ������ü(){
 * 			try{
 * 			��� ����
 * 			�Ա� ����
 * 				commit
 * 			}catch(){
 * 				rollback
 * 			}
 * 		}
 * 
 * -------------------------------
 * �ű� ī�� �߱�(){
 * 	 try{
 * 	 ����Ʈ ����
 * 	 ī�� �߱�
 * 	   commit
 * 	 }catch(){
 *     rollback
 *   }
 * }
 */

drop table card;
drop table point;

create table card(
	id varchar2(100) primary key,
	name varchar2(100) not null
)
create table point(
	id varchar2(100) primary key,
	point number not null
)

select * from card;
select * from point;

delete from card;
delete from point;
commit





