# Amazon Gateway y Lambda

## Author

Miguel Ángel Rivera.

## Compile and run instructions

Para descargar este proyecto en algún directorio, empezamos abriendo un ventana de consola, vamos al direcorio donde queremos que quede el proyecto y escribimos:

$ git clone https://github.com/migue1994/Gateway-y-Lambda.git

Nos empezará a descargar el contenido dentro de un repositorio local y así poderlo usar.

## Prerequisites

Para empezar, debemos asegurarnos que tenemos las herramientas necesarias para poder ejecutar el proyecto (En caso de que no posea alguna de estas herrmientas, puede dar click sobre los nombres que están a continuación y lo redirecionará a un tutorial de instalacion), estas herramientas son:

- [Java JDK](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-microsoft-windows-platforms.htm#JSJIG-GUID-A740535E-9F97-448C-A141-B95BF1688E6F)
- [Apache Maven](https://howtodoinjava.com/maven/how-to-install-maven-on-windows/)
- [Git](https://www.linode.com/docs/development/version-control/how-to-install-git-on-linux-mac-and-windows/)

## Execute

Para ejecutar el proyecto localmente, debemos ingresar al directorio, donde se encuentra el archivo pom.xml mediante una consola cmd, una vez allí, debemos ingresar el siguiente código que nos permitirá ejecutar el servicio web creado en spark.

``$mvn exec:java -Dexec.mainClass="edu.eci.escuelaing.lambda.services.SparkApp"

Hecho esto, solo debemos ingresar en el navegador e ir a la dirección htttp://localhost:4567, para visualizar el formulario.

## Used tools

- [Microsoft Visual Studio Code](https://code.visualstudio.com/)
- [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Apache Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)
- [GitHub](https://github.com/)

## Licence

[LICENSE.txt](LICENSE.txt)

## Report

Para poder poner a funcionar el servicio, debemos crear primero una función, la cual permitirá calcular el cuadrado de un número, esta clase es la misma que el profesor dejó en el tutorial inicial, por lo tanto solo se mostrará la interfaz de la api rest en aws api gateway.

![gateway]()

La función que usamos, es la misma que está en el tutorial.

A continuación se mostrará el código del servidor que se ejecuta en la máquina que estará en aws EC2

![codigo]()

Por otro lado, se debe realizar una petición a la api rest, con el fin de obtener el resultado que requerimos, el fragmento de código que hace esto posible es el siguiente.

![peticion]()

El fragmento anterior, corresponde a la página principal, en donde se encuantra el formulario que requiere un número como entrada.

posteriormente, se debe crear una instancia EC2 en aws, a la cual le instalaremos maven, git y por último java 8.

Una vez hecho esto, descargamos el repositorio usando git, para después ejecutarlo mediante maven de la siguiente forma

![awsEC2]()

Finalmente, probamos nuestro sercicio corriendo desde la dirección que nos provee aws en la instancia que habíamos creado.

![formulario1]()

Damos en el boton submit, y nos redireccionará a una página que contiene los resultados.

![formulario2]()