use prsdb;

insert user (username, password, firstname, lastname, phone, email, isReviewer, isAdmin)
	values ('sa', 'sa', 'System', 'Admin', '911', 'admin@system.com', true, true),
		   ('rv', 'rv', 'System', 'Reviewer', '811', 'reviewer@system.com', true, false),
		   ('us', 'us', 'System', 'User', '411', 'user@system.com', false, false);
		   
insert vendor (code, name, address, city, state, zip, phone, email)
	values ('MAX', 'Max Technical Training', '4900 Parkway Dr.', 'Mason', 'OH', '45040', '513-322-8888', 'info@maxtrain.com'),
		   ('PG', 'P&G', '1 PG Dr.', 'Cincinnati', 'OH', '45202', '513-555-1212', 'info@pg.com'),
		   ('AMZ', 'Amazon', '1 Amazon Way', 'Seattle', 'WA', '78394', '983-555-1212', 'info@amazon.com'),
		   ('TRG', 'Target', '1 Target Way.', 'Minneapolis', 'MN', '98765', '987-555-1212', 'info@target.com');
		   
insert product (partnbr, name, price, unit, vendorId)
    values ('ECHO', 'Echo', 100, 'Each', 3),
           ('ECHODOT', 'Echo Dot', 50, 'Each', 3),
           ('ECHOSHOW', 'Echo Show', 150, 'Each', 3);
          
insert request (description, justification, deliveryMode, status, total, userId)
    values ('1st Request', 'None', 'Pickup', 'NEW', 0, 3),
           ('2nd Request', 'None', 'Pickup', 'NEW', 0, 3),
           ('3rd Request', 'None', 'Pickup', 'NEW', 0, 3);
          
insert requestline (requestId, productId, quantity)
    values (1, 1, 1),(1, 2, 1),(1,3,1);
           