1.启动方法

在Intellij IDEA中执行mvn gatling:test

2.执行模拟器说明

1)如果只启动单个simulation，需要将runMultipleSimulations的值设为false，同时指定simulationClass的值，特别注意路径格式
2如果同时启动多个如果只启动单个simulation，需要将runMultipleSimulations的值设为true，同时可以指定本次执行包括哪些simulation，排除哪些simulation

                    <!-- the name of the single Simulation class to run -->
                    <simulationClass>computerdatabase.BasicSimulation</simulationClass>

                    <!-- if the plugin should run multiple simulations sequentially -->
                    <runMultipleSimulations>false</runMultipleSimulations>

                    <includes>
                        <!--<include>default.*</include>-->
                        <include>computerdatabase.*</include>
                    </includes>
                    <excludes>
                        <exclude>default.*</exclude>
                        <!--<exclude>computerdatabase.*</exclude>-->
                    </excludes>
