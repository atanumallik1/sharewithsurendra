# sharewithsurendra

deploy using `cf push`

create tasks 
````
cf run-task AppWithTask -m 1G -k 1G --name SpringbootAppAsTask --command  '$PWD/.java-buildpack/open_jdk_jre/bin/java -jar $PWD/BOOT-INF/lib/TaskApplication-1.jar'
cf run-task AppWithTask --name sample-shell_task --command  'sh $PWD/BOOT-INF/classes/taskscripts/hello.sh'      
````


check task status 
````
cf tasks AppWithTask
````

kill a task
````
cf terminate-task AppWithTask <task id>     
````
