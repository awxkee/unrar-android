# unrar-android
The [unrar library](https://www.rarlab.com/rar_add.htm) java binding.

List archive entries:
```java
RarFile rar=new RarFile("/sdcard/test.rar");
for(RarEntry entry:rar.getEntries(null)){
    ....

}
// check if password protected
rar.isPasswordProtected()
// validate password
rar.validatePassword("pwd")
// set password
rar.setPassword("newPassword")
```
Extract entry:
``` java
RarFile rar=new RarFile("/sdcard/test.rar");
rar.extract("one.txt",new UnrarCallback() {
                    @Override
                    public void close() throws IOException {}
                    @Override
                    public void processData(byte[] b, int off, int len) throws IOException {
                        System.out.println(new String(b, off, len, "GBK"));
                    }
                });
```

Extract all entries:
``` java
RarFile rar=new RarFile("/sdcard/test.rar");
rar.extractAll("/destPath/",null);
```

# License

While this crate uses the Apache license for the java parts,
      the embedded [C++ library](./src/main/cpp/libunrar/) has a different license.

For more informations, see its [license file](./src/main/cpp/libunrar/license.txt).

