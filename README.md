Welcome to the Social network for Kids
=====================================

This project is based on play framework. Go to its main page for more information.

The first thing we have to do is installing sbt - simple built tool.

Visit [scala-sbt][http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html] for install instructions.

After installing sbt, run follow command:

   $ sbt run

This command will automatically install play framework and then compile and run webserver for you.

The main directory structure of the project is that:

```
.
├── app
│   ├── controllers
│   │   └── Application.scala
│   └── views
│       ├── index.scala.html
│       └── main.scala.html
├── build.sbt
├── conf
│   ├── application.conf
│   └── routes
├── logs
│   └── application.log
├── project
│   ├── build.properties
│   ├── plugins.sbt
│   └── project
├── public
│   ├── images
│   │   └── favicon.png
│   ├── javascripts
│   │   └── jquery-1.9.0.min.js
│   └── stylesheets
│       └── main.css
├── README.md
└── test
    ├── ApplicationSpec.scala
		    └── IntegrationSpec.scala
```

Happy hacking!
