# Dockerfile
FROM openjdk:17-jdk-slim

# Metadados
LABEL maintainer="exemplo@email.com"
LABEL description="Sistema de Notificações Assíncronas"

# Variáveis de ambiente
ENV SPRING_PROFILES_ACTIVE=docker
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Criar diretório da aplicação
WORKDIR /app

# Copiar arquivos do Maven (para cache de dependências)
COPY pom.xml .
COPY .mvn/ .mvn/
COPY mvnw .

# Dar permissão de execução ao mvnw
RUN chmod +x ./mvnw

# Baixar dependências (cache layer)
RUN ./mvnw dependency:go-offline -B

# Copiar código fonte
COPY src/ ./src/

# Compilar aplicação
RUN ./mvnw clean package -DskipTests

# Expor porta
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar target/sistema-notificacoes-1.0.0.jar"]