
FROM postgres:12.18


ENV POSTGRES_DB empleado
ENV POSTGRES_USER usuario
ENV POSTGRES_PASSWORD contraseña


RUN echo "CREATE TABLE Empleado (id SERIAL PRIMARY KEY, nombre VARCHAR(100), direccion VARCHAR(200), telefono VARCHAR(20));" >> /docker-entrypoint-initdb.d/init.sql


EXPOSE 5432

