db-schema-definition-translator-maven-plugin
============================================



















   <pluginManagement>
      <plugins>

         <plugin>
            <groupId>db-schema-definition</groupId>
            <artifactId>db-schema-definition-translator-maven-plugin</artifactId>
            <version>0.83</version>
            <executions>
               <execution>
                  <id>translate_to_sql</id>
                  <phase>generate-sources</phase>
                  <configuration>
                     <outputFormat>sql</outputFormat>
                     <outputFolder>${project.basedir}/src/main/sql/oracle/</outputFolder>
                     <inputFileName>src/main/resources/nlp-messaging-manager.dbsd</inputFileName>
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
                     <outputFormat>img</outputFormat>
                     <outputFolder>${project.basedir}/src/main/resources/</outputFolder>
                     <inputFileName>src/main/resources/nlp-messaging-manager.dbsd</inputFileName>
   	  	             <outputFilePrefix>nlp-messaging-manager</outputFilePrefix>
                  </configuration>
                  <goals>
                     <goal>translate</goal>
                  </goals>
               </execution>
            </executions>
         </plugin>
      </plugins>
   </pluginManagement>




