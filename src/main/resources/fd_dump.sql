-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.cart_data
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    amount numeric(99, 0) NOT NULL,
    product_data_id bigint,
    customer_cart_id bigint,
    CONSTRAINT delivery_list_data_pkey PRIMARY KEY (id)
);

COMMENT ON TABLE public.cart_data
    IS 'Информация о корзине (список желаемого).';

CREATE TABLE IF NOT EXISTS public.courier_data
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    firstname character varying(16) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(20) COLLATE pg_catalog."default" NOT NULL,
    vehicle character varying(20) COLLATE pg_catalog."default" NOT NULL,
    courier_phone character varying(7) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT courier_data_pkey PRIMARY KEY (id)
);

COMMENT ON TABLE public.courier_data
    IS 'Информация о курьере.';

CREATE TABLE IF NOT EXISTS public.customer_cart
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    customer_data_id bigint,
    CONSTRAINT customer_cart_data_pkey PRIMARY KEY (id)
);

COMMENT ON TABLE public.customer_cart
    IS 'Информация принадлежности определенной корзины конкретному пользователю.';

CREATE TABLE IF NOT EXISTS public.customer_data
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    username character varying(40) COLLATE pg_catalog."default" NOT NULL,
    email character varying(256) COLLATE pg_catalog."default" NOT NULL,
    password character varying(35) COLLATE pg_catalog."default" NOT NULL,
    customer_phone character varying(7) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT customer_data_pkey PRIMARY KEY (id),
    CONSTRAINT "username_email_Unique" UNIQUE (username, email)
        INCLUDE(username, email)
);

COMMENT ON TABLE public.customer_data
    IS 'Информация о пользователе-покупателе.';

CREATE TABLE IF NOT EXISTS public.order_data
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    city character varying(20) COLLATE pg_catalog."default" NOT NULL,
    address character varying(50) COLLATE pg_catalog."default" NOT NULL,
    floor smallint NOT NULL,
    "time" timestamp without time zone DEFAULT 'CURRENT_TIMESTAMP',
    payment character varying(20) COLLATE pg_catalog."default" NOT NULL,
    customer_data_id bigint,
    courier_data_id bigint,
    total double precision NOT NULL,
    CONSTRAINT order_data_pkey PRIMARY KEY (id)
);

COMMENT ON TABLE public.order_data
    IS 'Информация о заказе.';

CREATE TABLE IF NOT EXISTS public.product_and_order
(
    order_data_id bigint,
    product_data_id bigint,
    amount_ordered numeric(99, 0) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.product_category_data
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    category_title character varying(30) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT product_category_data_pkey PRIMARY KEY (id)
);

COMMENT ON TABLE public.product_category_data
    IS 'Категория продукта.';

CREATE TABLE IF NOT EXISTS public.product_data
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    product_title character varying(30) COLLATE pg_catalog."default" NOT NULL,
    price double precision NOT NULL,
    product_rating numeric(5, 0) NOT NULL,
    product_category_id bigint,
    image_link text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT product_data_pkey PRIMARY KEY (id)
);

COMMENT ON TABLE public.product_data
    IS 'Информация о продукте.';

CREATE TABLE IF NOT EXISTS public.review_data
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    review_rating numeric(5, 0) NOT NULL,
    comment text COLLATE pg_catalog."default",
    CONSTRAINT review_data_pkey PRIMARY KEY (id)
);

COMMENT ON TABLE public.review_data
    IS 'Информация об отзыве.';

ALTER TABLE IF EXISTS public.cart_data
    ADD CONSTRAINT customer_cart_fkey FOREIGN KEY (customer_cart_id)
    REFERENCES public.customer_cart (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.cart_data
    ADD CONSTRAINT product_fkey FOREIGN KEY (product_data_id)
    REFERENCES public.product_data (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.customer_cart
    ADD CONSTRAINT customer_fkey FOREIGN KEY (customer_data_id)
    REFERENCES public.customer_data (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.order_data
    ADD CONSTRAINT courier_fkey FOREIGN KEY (courier_data_id)
    REFERENCES public.courier_data (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.order_data
    ADD CONSTRAINT customer_fkey FOREIGN KEY (customer_data_id)
    REFERENCES public.customer_data (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.product_and_order
    ADD CONSTRAINT order_fkey FOREIGN KEY (order_data_id)
    REFERENCES public.order_data (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.product_and_order
    ADD CONSTRAINT product_fkey FOREIGN KEY (product_data_id)
    REFERENCES public.product_data (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.product_data
    ADD CONSTRAINT product_category_fkey FOREIGN KEY (product_category_id)
    REFERENCES public.product_category_data (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;