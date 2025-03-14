# Hilos en Java

Este proyecto demuestra la implementación del modelo Productor-Consumidor utilizando hilos en Java. El objetivo es mostrar cómo se pueden manejar problemas de sincronización y comunicación entre procesos mediante el uso de hilos.

## Contenido

- **Productor**: Clase que simula la producción de datos.
- **Consumidor**: Clase que simula el consumo de datos.
- **Buffer**: Clase que actúa como un contenedor para los datos producidos y consumidos, asegurando la sincronización entre productores y consumidores.

## Requisitos

- Java JDK 8 o superior

## Cómo Ejecutar el Proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/luis-sagx/HilosEnJava.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd HilosEnJava
   ```
3. Compila el proyecto:
   ```bash
   javac *.java
   ```
4. Ejecuta la clase principal:
   ```bash
   java Main
   ```

## Ejemplo de Uso

Al ejecutar el programa, verás cómo los productores generan datos y los consumidores los procesan en tiempo real, mostrando la sincronización entre ellos.

