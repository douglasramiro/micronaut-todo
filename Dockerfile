FROM oracle/graalvm-ce:19.0.0 as graalvm
COPY . /home/app/micronaut-todo
WORKDIR /home/app/micronaut-todo
RUN gu install native-image
RUN native-image --no-server -cp target/micronaut-todo.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-todo .
ENTRYPOINT ["./micronaut-todo"]