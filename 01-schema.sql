DROP TABLE IF EXISTS tb_address;

CREATE DATABASE techchallenge_db;

\c techchallenge_db;

CREATE TABLE "tb_address" (
                           "id" SERIAL PRIMARY KEY,
                           "street" TEXT NOT NULL,
                           "number" VARCHAR(255) NOT NULL,
                           "district" VARCHAR(255) NOT NULL,
                           "city" VARCHAR(255) NOT NULL,
                           "state" VARCHAR(255) NOT NULL
);

CREATE TABLE "tb_appliance" (
                              "id" SERIAL PRIMARY KEY,
                              "name" VARCHAR(255) NOT NULL,
                              "model" VARCHAR(255) NOT NULL,
                              "power" VARCHAR(255) NOT NULL,
                              "manufacturer" VARCHAR(255) NOT NULL
);

CREATE TABLE "tb_dependent" (
                                "id" SERIAL PRIMARY KEY,
                                "name" VARCHAR(255) NOT NULL,
                                "dateOfBirth" DATE NOT NULL,
                                "gender" VARCHAR(255) NOT NULL,
                                "parentage" VARCHAR(255) NOT NULL
);

