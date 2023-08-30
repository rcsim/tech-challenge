DROP TABLE IF EXISTS tb_address CASCADE;
DROP TABLE IF EXISTS tb_appliance CASCADE;
DROP TABLE IF EXISTS tb_dependent CASCADE;
DROP TABLE IF EXISTS tb_dependent_appliance CASCADE;

CREATE DATABASE techchallenge_db;

\c techchallenge_db;

CREATE TABLE "tb_address" (
                           "id" SERIAL PRIMARY KEY,
                           "street" TEXT NOT NULL,
                           "number" VARCHAR(255) NOT NULL,
                           "district" VARCHAR(255) NOT NULL,
                           "city" VARCHAR(255) NOT NULL,
                           "state" VARCHAR(255) NOT NULL,
                           "user_id" BIGINT NOT NULL
);

CREATE TABLE "tb_appliance" (
                              "id" SERIAL PRIMARY KEY,
                              "name" VARCHAR(255) NOT NULL,
                              "model" VARCHAR(255) NOT NULL,
                              "power" VARCHAR(255) NOT NULL,
                              "manufacturer" VARCHAR(255) NOT NULL,
                              "user_id" BIGINT NOT NULL,
                              "address_id" BIGINT NOT NULL,
                              FOREIGN KEY (address_id) REFERENCES tb_address(id)
);

CREATE TABLE "tb_dependent" (
                                "id" SERIAL PRIMARY KEY,
                                "name" VARCHAR(255) NOT NULL,
                                "date_of_birth" VARCHAR(255) NOT NULL,
                                "gender" VARCHAR(255) NOT NULL,
                                "parentage" VARCHAR(255) NOT NULL,
                                "user_id" BIGINT NOT NULL,
                                "address_id" BIGINT NOT NULL,
                              FOREIGN KEY (address_id) REFERENCES tb_address(id)
);

CREATE TABLE "tb_dependent_appliance" (
                                "appliance_id" BIGINT NOT NULL,
                                "dependent_id" BIGINT NOT NULL,
                                PRIMARY KEY("appliance_id", "dependent_id"),
                                FOREIGN KEY ("appliance_id") REFERENCES "tb_appliance"("id"),
                                FOREIGN KEY ("dependent_id") REFERENCES "tb_dependent"("id")
);