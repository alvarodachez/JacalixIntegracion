# JacalixIntegracion

Este proyecto intenta simular una aplicación de streaming multimedia, en esa primera versión, podrás crear y obtener productos de la aplicación desde la web haciendo peticiones a una aplicación Java. 

## Comenzando 🚀

Para obtener una copia del proyecto en tu máquina local, lo primero que debemos hacer es clonar el proyecto. Habrá dos carpetas diferentes. 

La carpeta "JacalixIntegracion" es el proyecto Java encargado de la parte "Backend" de la aplicación. Por otra parte "frontJacalix" contiene una maquina virtual con vagrant, la cual posee un servidor apache y una base de datos MySQL (que no será necesaria para este proyecto).

Mira **Despliegue** para conocer como desplegar el proyecto.

### Pre-requisitos 📋

Para poder usar este proyecto serán necesarias algnas cosas;

> **Java 11 o superior**
>
> https://www.oracle.com/java/technologies/javase-downloads.html
>
> **Spring Tool Suite**
>
> https://spring.io/tools
>
> **VirtualBox**
>
> https://www.virtualbox.org
>
> **Vagrant**
>
> https://www.vagrantup.com/
>
> **Visual Studio Code**
>
> https://code.visualstudio.com/

## Despliegue 📦

En primer lugar tenemos que levantar el backend de la aplicación. Para ello nos dirigimos a "Spring Tool Suite". Importamos el proyecto **Maven**, que obtuvimos del repositorio. Una vez importado levantaremos el servidor con la aplicación. Si la traza es correcta, tendrás algo como esto.

```
 :: Spring Boot ::        (v2.3.4.RELEASE)

2020-10-24 13:58:09.352  INFO 4916 --- [           main] c.j.J.JacalixIntegracionApplication      : Starting JacalixIntegracionApplication on DESKTOP-RP4V7ML with PID 4916 (C:\Users\rueda\Desktop\JacalixIntegracion\JacalixIntegracion\target\classes started by rueda in C:\Users\rueda\Desktop\JacalixIntegracion\JacalixIntegracion)
2020-10-24 13:58:09.354  INFO 4916 --- [           main] c.j.J.JacalixIntegracionApplication      : No active profile set, falling back to default profiles: default
2020-10-24 13:58:09.863  INFO 4916 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.ws.config.annotation.DelegatingWsConfiguration' of type [org.springframework.ws.config.annotation.DelegatingWsConfiguration$$EnhancerBySpringCGLIB$$a0049d23] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-10-24 13:58:09.919  INFO 4916 --- [           main] .w.s.a.s.AnnotationActionEndpointMapping : Supporting [WS-Addressing August 2004, WS-Addressing 1.0]
2020-10-24 13:58:10.135  INFO 4916 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-10-24 13:58:10.144  INFO 4916 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-10-24 13:58:10.144  INFO 4916 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.38]
2020-10-24 13:58:10.225  INFO 4916 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-10-24 13:58:10.225  INFO 4916 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 823 ms
2020-10-24 13:58:10.389  INFO 4916 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-10-24 13:58:10.587  INFO 4916 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-10-24 13:58:10.596  INFO 4916 --- [           main] c.j.J.JacalixIntegracionApplication      : Started JacalixIntegracionApplication in 1.561 seconds (JVM running for 2.48)
```

A continuación, abrimos una terminal, nos metemos dentro de la carpeta "frontJacalix" que esta dentro del repositorio. Ejecutamos el comando "vagrant up", si todo está correcto tendrás este resultado.

```
$ vagrant up
Bringing machine 'default' up with 'virtualbox' provider...
==> default: Importing base box 'scotch/box'...
==> default: Matching MAC address for NAT networking...
==> default: Checking if box 'scotch/box' version '3.5' is up to date...
==> default: Setting the name of the VM: frontJacalix_default_1603540629815_12554
==> default: Clearing any previously set network interfaces...
==> default: Preparing network interfaces based on configuration...
    default: Adapter 1: nat
    default: Adapter 2: hostonly
==> default: Forwarding ports...
    default: 22 (guest) => 2222 (host) (adapter 1)
==> default: Booting VM...
==> default: Waiting for machine to boot. This may take a few minutes...
    default: SSH address: 127.0.0.1:2222
    default: SSH username: vagrant
    default: SSH auth method: private key
    default: Warning: Connection aborted. Retrying...
    default:
    default: Vagrant insecure key detected. Vagrant will automatically replace
    default: this with a newly generated keypair for better security.
    default:
    default: Inserting generated public key within guest...
    default: Removing insecure key from the guest if it's present...
    default: Key inserted! Disconnecting and reconnecting using new SSH key...
==> default: Machine booted and ready!
==> default: Checking for guest additions in VM...
    default: The guest additions on this VM do not match the installed version of
    default: VirtualBox! In most cases this is fine, but in rare cases it can
    default: prevent things such as shared folders from working properly. If you see
    default: shared folder errors, please make sure the guest additions within the
    default: virtual machine match the version of VirtualBox you have installed on
    default: your host and reload your VM.
    default:
    default: Guest Additions Version: 5.1.21
    default: VirtualBox Version: 6.1
==> default: Setting hostname...
==> default: Configuring and enabling network interfaces...
==> default: Mounting shared folders...
    default: /var/www => C:/Users/rueda/Desktop/JacalixIntegracion/frontJacalix
```

**Nota:** Al levantar la maquina Vagrant puede que de un fallo, si responde este resultado:

```
The VirtualBox VM was created with a user that doesn't match the
current user running Vagrant. VirtualBox requires that the same user
be used to manage the VM that was created. Please re-run Vagrant with
that user. This is not a Vagrant issue.

The UID used to create the VM was: 1000
Your UID is: 0
```

Para solucionar este problema nos movemos a la ruta dentro de la carpeta "frontJacalix":

```
.vagrant/machines/default/virtualbox/creator_uid
```

Cambiamos el numero que esta en ese fichero por "0" y listo.

Una vez hecho esto, ya estamos listos para realizar pruebas y probar la aplicación.

## Ejecutando las pruebas ⚙️

Por ejemplo, hacemos una operación "Post" y posteriormente un "Get".

<img src="C:\Users\rueda\Desktop\screenshotFront.png"  />

Una vez terminadas las pruebas, y queramos cerrar el entorno. Paramos el servidor Backend desde Spring Tool Suite.

```
2020-10-24 14:28:59.591  INFO 4916 --- [n(38)-127.0.0.1] inMXBeanRegistrar$SpringApplicationAdmin : Application shutdown requested.
2020-10-24 14:28:59.657  INFO 4916 --- [n(38)-127.0.0.1] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
```

 Y ejecutamos el comando "vagrant halt" en la terminal anterior.

```
$ vagrant halt
==> default: Attempting graceful shutdown of VM...
```

## Construido con 🛠️

Herramientas para crear el proyecto.

-  [Spring](https://spring.io/) - Framework usado
- [Maven](https://maven.apache.org/) - Controlador de dependencias
- [SpringTooolSuite](https://spring.io/tools) - IDE para el BackEnd
- [Visual Studio Code](https://code.visualstudio.com/) - IDE para el FrontEnd

## Versionado 📌

Uso [Git](https://github.com/) para el versionado de la aplicación.