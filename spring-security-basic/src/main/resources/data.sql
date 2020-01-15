insert into users (username, password, enabled ) values ('amol', 'singh', true);
insert into users (username, password, enabled ) values ('admin', 'singh', true);


insert into authorities ( username, authority ) values ( 'amol', 'ROLE_USER' );   -- ROLE is prefix
insert into authorities ( username, authority ) values ( 'admin', 'ROLE_ADMIN' );