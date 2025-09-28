# kMapper Examples

A few examples for using the [kMapper](https://github.com/s0nicyouth/kmapper).

## Use kMapper Local Develop Version

It uses the released version `1.3.0`

Beginning with v1.3.0, KMapper was converted to be Multiplatform compatible. This involves that
`java.math.BigDecimal` is no longer supported but `com.ionspin.kotlin.bignum.decimal.BigDecimal` is used instead.
[There is an issue a Kotlin native BigDecimal implementation](https://discuss.kotlinlang.org/t/multiplatform-bigdecimal-implementation/5631).

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
> Task :run
RecDomainPartB(id=1, name=Room, relations=[A2BRelation(aId=1, bId=1, valid=morning, partA=RecDomainPartB(id=1, name=A one, relations=[] ), partB=RecDomainPartB(id=1, name=Room, relations=[] )), A2BRelation(aId=2, bId=1, valid=lunch, partA=RecDomainPartB(id=2, name=A two, relations=[] ), partB=RecDomainPartB(id=1, name=Room, relations=[] )), A2BRelation(aId=2, bId=1, valid=evening, partA=RecDomainPartB(id=3, name=A three, relations=[] ), partB=RecDomainPartB(id=1, name=Room, relations=[] ))] )
Money(amount=22, currency=Currency(code=EUR, fractionalDigits=null))
InterfaceTestDomain(floatToInt=1, doubleToFloat=2.0, strToBigDecimal=3.0, bigDecimalToStr=10)
RecursiveDataClassDomain(second=RecursiveDataClassDomainSecond(third=RecursiveDataClassDomainThird(bigDecimalToFloat=1.0, stringToString=one, bigDecimalToBigDecimal=0.0), bigDecimalToInt=1.0E+1))
ListDomain(i=OtherListDomain(k=Other), l=[OtherListDomain(k=first), OtherListDomain(k=second)])
ListDomain(i=OtherListDomain(k=Other), l=[OtherListDomain(k=third), OtherListDomain(k=fourth)])
MapTestDomain(mapOne={Seven=7}, mapTwo={}, mapThree={3=3.876})
BindDomain(one=One Bind, second=2, third=SomeInternalDomain(i=3), fourth=4.4)
UserEntity(id=a50e593f-6c3e-4c0f-8c64-3595b89da476, login=sherlock, firstname=Sherlock, lastname=Holmes, addresses=[AddressEntity(id=5834c29a-759f-41c6-a495-b2dcde18d0e7, street=10 Baker St, town=London), AddressEntity(id=a38e910d-d627-4f13-b1f2-cd39f40d5eb3, street=10 Wood St, town=Edinburgh)])
DomainUser(id=a50e593f-6c3e-4c0f-8c64-3595b89da476, login=sherlock, firstname=Sherlock, lastname=Holmes, addresses=[DomainAddress(id=5834c29a-759f-41c6-a495-b2dcde18d0e7, street=10 Baker St, town=London), DomainAddress(id=a38e910d-d627-4f13-b1f2-cd39f40d5eb3, street=10 Wood St, town=Edinburgh)])
AdvancedUser(firstname=Sherlock, lastname=Holmes, hairColour=null)
```
