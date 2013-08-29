DB Schema Definition Translator - Maven Plugin
==============================================
It's the Maven plugin to be used if you want to integrate the [DB Schema Definition Translator][1] tool in your project.

Usage
-----
The configuration parameters are:
* __inputFileName:__ The input file name (.dbsd)
* __outputFormat:__ The output format. The available formats are;¡:
   * __img:__ Generates Graphviz dot diagrams.
   * __sql:__ Generates the DB creation PL/SQL scripts.
* __outputFolder:__ The folder where the output files will be saved.
* __outputFilePrefix:__ The prefix to be used in the output file names.


Example
-------
The following example shows how to configure the plugin to generate the diagrams and PL/SQL scripts.

    <pluginManagement>
       <plugins>
          ...
          <plugin>
             <groupId>db-schema-definition</groupId>
             <artifactId>db-schema-definition-translator-maven-plugin</artifactId>
             <version>0.83</version>
             <executions>
                <execution>
                   <id>translate_to_sql</id>
                   <phase>generate-sources</phase>
                   <configuration>
                      <inputFileName>src/main/resources/nlp-messaging-manager.dbsd</inputFileName>
                      <outputFormat>sql</outputFormat>
                      <outputFolder>${project.basedir}/src/main/sql/oracle/</outputFolder>
                      <outputFilePrefix>nlp-messaging-manager</outputFilePrefix>
                   </configuration>
                   <goals>
                      <goal>translate</goal>
                   </goals>
                </execution>
                <execution>
                   <id>translate_to_img</id>
                   <phase>generate-resources</phase>
                   <configuration>
                      <inputFileName>src/main/resources/nlp-messaging-manager.dbsd</inputFileName>
                      <outputFormat>img</outputFormat>
                      <outputFolder>${project.basedir}/src/main/resources/</outputFolder>
    	  	             <outputFilePrefix>nlp-messaging-manager</outputFilePrefix>
                   </configuration>
                   <goals>
                      <goal>translate</goal>
                   </goals>
                </execution>
             </executions>
          </plugin>
          ...
       </plugins>
    </pluginManagement>


[1]: https://github.com/ryoppei/db-schema-definition-translator  "DB Schema Definition Translator"


