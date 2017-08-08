CREATE TABLE Cars (
  ID SERIAL PRIMARY KEY,
  Brand       VARCHAR(255) NOT NULL,
  Model       VARCHAR(255) NOT NULL,
  Color       VARCHAR(255) NOT NULL,
  StateNumber VARCHAR(255) NOT NULL
);

CREATE TABLE GeoPoints (
  ID SERIAL PRIMARY KEY,
  n NUMERIC NOT NULL,
  e NUMERIC NOT NULL
);

CREATE TABLE CarDrivers (
  ID SERIAL PRIMARY KEY,
  Name         VARCHAR(255),
  Phone        VARCHAR(50),
  NotifyRadius INTEGER,
  CarId        INTEGER REFERENCES Cars (ID),
  GeoPointId   INTEGER REFERENCES GeoPoints (ID),
  Password     VARCHAR(255) NOT NULL
);

CREATE TABLE Orders (
  ID                                     SERIAL PRIMARY KEY,
  Date                TIMESTAMP NOT NULL,
  Problem             VARCHAR(255),
  CarDriverNeedHelpId INTEGER   NOT NULL REFERENCES CarDrivers (ID),
  CarDriverResponseId INTEGER REFERENCES CarDrivers (ID),
  GeoPointId          INTEGER REFERENCES GeoPoints (ID),
  IsActive            BOOLEAN   NOT NULL DEFAULT TRUE
);





