# dojo-java9

##Prerequisites:
Add File toolchains.xml to Maven local repository folger (eg: C:\Users\dominik.mozny\.m2) with this content and don't forget to modify path for 1.9 and 1.8):

```
<toolchains>
  <!-- JDK toolchains -->
  <toolchain>
    <type>jdk</type>
    <provides>
      <version>1.9</version>
      <vendor>oracle</vendor>
    </provides>
    <configuration>
      <jdkHome>C:\Program Files\Java\jdk-9.0.1</jdkHome>
    </configuration>
  </toolchain>
  <toolchain>
    <type>jdk</type>
    <provides>
      <version>1.8</version>
      <vendor>oracle</vendor>
    </provides>
    <configuration>
      <jdkHome>C:\Program Files\Java\jdk1.8.0_25</jdkHome>
    </configuration>
  </toolchain>
</toolchains>
```