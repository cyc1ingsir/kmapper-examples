# kMapper Examples

A few examples for using the [kMapper](https://github.com/s0nicyouth/kmapper).

## Use kMapper Local Develop Version

It uses the non released version `1.1.0-SNAPSHOT`

To use this from `mavenLocal()`, you need to create a gpg key to sign the artefacts.  
[Documentation](https://central.sonatype.org/publish/requirements/gpg/#signing-a-file)
```shell
gpg --gen-key
gpg --list-signatures --keyid-format 0xshort
```
Add this to your `~/.gradle/gradle.properties`:
```properties
signing.keyId=YourKeyId
signing.password=YourPublicKeyPassword
signing.secretKeyRingFile=PathToYourKeyRingFile
```

```shell
cd <kMapper root folder>
./gradlew publishToMavenLocal
```

## Build and Run

```shell
./gradlew clean build
./gradlew run
```
