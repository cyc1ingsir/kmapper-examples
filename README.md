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
./gradlew processor_annotations:publishToMavenLocal
./gradlew publishToMavenLocal
```
Any time, something was changed on the `kMapper` code,  
```shell
./gradlew publishToMavenLocal
```
needs to be run again.

## Build and Run

```shell
./gradlew clean build
./gradlew run
```
### Expected Result
```text
Money(amount=22, currency=Currency(code=EUR, fractionalDigits=null))
RecursiveDataClassDomain(second=RecursiveDataClassDomainSecond(third=RecursiveDataClassDomainThird(bigDecimalToFloat=1.0, stringToString=one, bigDecimalToBigDecimal=0), bigDecimalToInt=10))
ListDomain(i=OtherListDomain(k=Other), l=[OtherListDomain(k=first), OtherListDomain(k=second)])
ListDomain(i=OtherListDomain(k=Other), l=[OtherListDomain(k=third), OtherListDomain(k=fourth)])
UserEntity(id=4e18c1cf-6b6d-46dc-83e9-00dfdc0fec8a, login=sherlock, firstname=Sherlock, lastname=Holmes, addresses=[AddressEntity(id=c9508952-d95f-42ff-8484-8615193c955b, street=10 Baker St, town=London), AddressEntity(id=1e596c66-ac1a-4e12-ac01-c3d2930566fd, street=10 Wood St, town=Edinburgh)])
DomainUser(id=4e18c1cf-6b6d-46dc-83e9-00dfdc0fec8a, login=sherlock, firstname=Sherlock, lastname=Holmes, addresses=[DomainAddress(id=c9508952-d95f-42ff-8484-8615193c955b, street=10 Baker St, town=London), DomainAddress(id=1e596c66-ac1a-4e12-ac01-c3d2930566fd, street=10 Wood St, town=Edinburgh)])

```
