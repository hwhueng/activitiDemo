create table dept_info (
                           id bigint(20) not null AUTO_INCREMENT,
                           dept_id varchar(20) not null,
                           dept_name varchar(100) not null,
                           parent_id varchar(20) not null default '',
                           status varchar(2) not null default 'Y',
                           dept_path varchar(150) not null default '',
                           create_time DATETIME not null default now(),
                           create_by varchar(20) not null default '',
                           update_time DATETIME not null default now(),
                           update_by varchar(20) not null default '',
                           PRIMARY KEY (id),
                           unique key (dept_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_bin;


create table emp_info (
                          id bigint(20) not null AUTO_INCREMENT,
                          emp_id varchar(20) not null,
                          emp_name varchar(50) not null,
                          dept_id varchar(20) not null default '',
                          mail varchar(50) not null default '',
                          phone varchar(12) not null default '',
                          hire_date Date not null,
                          probation_date Date not null,
                          create_time DATETIME not null default now(),
                          create_by varchar(20) not null default '',
                          update_time DATETIME not null default now(),
                          update_by varchar(20) not null default '',
                          PRIMARY KEY (id),
                          unique key (emp_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_bin;