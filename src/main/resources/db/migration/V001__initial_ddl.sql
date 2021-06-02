CREATE TABLE public.customer
(
    id bigint NOT NULL,
    name varchar(128) NOT NULL,
    identification varchar(32),
    phone varchar(32) ,
    city varchar(64),
    address varchar(128),
    state varchar(32),
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);

CREATE TABLE public.equipment
(
    id bigint NOT NULL,
    customer_id bigint NOT NULL,
    description varchar(128) NOT NULL,
    brand varchar(32),
    model varchar(32) ,
    identification varchar(64),
    CONSTRAINT equipment_pkey PRIMARY KEY (id)
);

alter table equipment add constraint fk_equipment_customer
foreign key (customer_id) references customer (id);

CREATE TABLE public."order"
(
    id bigint NOT NULL,
    equipment_id bigint NOT NULL,
    description varchar(128) NOT NULL,
    diagnostic varchar(256),
    solution varchar(256) ,
    CONSTRAINT order_pkey PRIMARY KEY (id)
);

alter table "order" add constraint fk_order_customer
foreign key (equipment_id) references equipment (id);
