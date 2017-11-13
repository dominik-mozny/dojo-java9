# dojo-java9

## Prerequisites:
Add File toolchains.xml to Maven local repository folder (eg: C:\Users\dominik.mozny\.m2) with this content and don't forget to modify path for 1.9 and 1.8:

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

For better orientation are all module names prefixed with ch.adesso.module and all package names with ch.adesso.pkg

### [1 Example of module definition (module)](branch/src/main/java/module-info.java)

### [2 Example of exports](branch/src/main/java/module-info.java)
  
  Try to remove line with exports and see immediate effect on [branchBern/src/main/java/module-info.java](branchBern/src/main/java/module-info.java)

### [3 Example of requires](branchBern/src/main/java/module-info.java)

  Try to remove line with requires and see immediate effect on [branchBern/src/main/java/ch/adesso/pkg/branch/bern/BranchBern.java](branchBern/src/main/java/ch/adesso/pkg/branch/bern/BranchBern.java)

### [4 Example of transitive](branchBern/src/main/java/module-info.java)

  Try to remove transitive word and see immediate effect on [presenter-simple/src/main/java/ch/adesso/pkg/presenter/simple/Presenter](presenter-simple/src/main/java/ch/adesso/pkg/presenter/simple/Presenter.java) 
  
### [5 Example of provides... with...](branchBern/src/main/java/module-info.java)

### [6 Example of uses](presenter-uses/src/main/java/module-info.java)
  
  Execute [presenter-uses/src/main/java/ch/adesso/pkg/presenter/uses/PresenterUses.java](presenter-uses/src/main/java/ch/adesso/pkg/presenter/uses/PresenterUses.java)
  
  You should see two listed branches
  
  Remove provides Branch with BranchZurich; line from [branchZurich/src/main/java/module-info.java](branchZurich/src/main/java/module-info.java) and run [PresenterUses.java](presenter-uses/src/main/java/ch/adesso/pkg/presenter/uses/PresenterUses.java) again

