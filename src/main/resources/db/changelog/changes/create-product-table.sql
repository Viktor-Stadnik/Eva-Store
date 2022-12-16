--liquibase formatted sql
--changeset <postgres>:<create-product-table>
CREATE TABLE IF NOT EXISTS public.product
(
    id bigint NOT NULL,
    name character varying(256) NOT NULL,
    description character varying(256) NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

--rollback DROP TABLE product;
