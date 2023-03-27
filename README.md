# ub01-akka-http-rest


## Build
#### Compilación y empaquetado
```
sbt clean package stage 
```
#### Generación de Imagen Docker y publicación en repositorio de Imagenes de GitLab
```
sbt docker:publish
```
-  Para la construcción de la imagen en local
  ```
    sbt docker:publishLocal
  ```
## Para una ejecución en Local (Sin usar la infraestructura Cloud)
### Compilación y empaquetado
```
sbt -DLOCAL_EXECUTION=oc2.ada.jobs.LocalJobLauncher clean package stage
```
### Ejecución
```
target/universal/stage/bin/oc2-ada-jobs-kdm2angular -DDATABASE_CONFIG_HOST="<Base de datos Cassandra>"
```
## Variables de Entorno
### Database
- DATABASE_CONFIG_HOST: host ej: ["localhost"] for Cassandra Cluster Configuration host = ["host1", "host2", "host3]
- DATABASE_CONFIG_PORT: port ej: "9042"
- DATABASE_CONFIG_USER: user ej: "cassandra"
- DATABASE_CONFIG_PASS: password ej: "cassandra"

### HDFS Configuration
- HDFS_CONFIG_HDFS_HOST: hdfs host ej: "localhost"
- HDFS_CONFIG_HDFS_PORT: Hdfs port ej: 8020
- HDFS_CONFIG_HDFS_USER: hdfs user ej: "user1"
- HDFS_CONFIG_HDFS_PASSWORD: hdfs password ej: "password"
- HDFS_CONFIG_HDFS_DOCUMENT_ROOT: hdfs document root ej: "/test"

### FS Configurartion
- FS_CONFIG_FS_PATH_REPOSITORY: Ruta del repositorio en el sistema de ficheros, ej: "/tmp/repository"

### AKKA Persistence
- AKKA_PERSISTENCE_JOURNAL: Journal leveldb directorio ej: "target/example/journal"
- AKKA_PERSISTENCE_SNAPSHOT: Snapshot store local directorio ej: "target/example/snapshots"

### Logger Store Configuration
- LOGGER_STORE_CONFIG_HOST: host ej: "localhost"
- LOGGER_STORE_CONFIG_PORT: port ej: "27017"
- LOGGER_STORE_CONFIG_NAME: name ej:"oc2-ada-jobs-lang-cobol-mod-2018"
- LOGGER_STORE_CONFIG_USER: user ej: "user1"
- LOGGER_STORE_CONFIG_PASSWORD: password ej:"password"

### kafka-configuration
- KAFKA_CONFIG_KAFKA_HOST: kafka host ej: "localhost"
- KAFKA_CONFIG_KAFKA_PORT: kafka port ej: 9092
- KAFKA_CONFIG_KAFKA_USER: kafka user ej:""
- KAFKA_CONFIG_KAFKA_PASSWORD: kafka password ej: ""

## Otras Variables de Entorno 'kdm-attributes.conf'
- RESOURCES_ORIGIN: GIT, when resources are in git or LOCAl, when resources are in local folder

### oc2-ada-resource-git
- RESOURCE_GIT_URI: Uri git ej: https://git.opencanarias.com/oc2/ada/na/prototipos/angulararchetype_v2.git
- RESOURCE_GIT_USER: User git
- RESOURCE_GIT_PASS: Password git
- RESOURCE_GIT_CLONE_PATH: Path to clore repository ej: "/tmp/angulararchetype_v2"
- RESOURCE_GIT_CLONE_BRANCH: If you want to indicate a branch by default "maters" branch
}
