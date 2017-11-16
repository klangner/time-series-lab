# Time Series Lab

Web Application for working with Time Series

## Running the server
 
 ```bash
sbt assembly
java -jar target/scala-2.12/timeserieslab.jar 
docker build -t timeserieslab:0.1.0 .
docker run -p 8080:8080 timeserieslab:0.1.0
 ```

# Join in!

We are happy to receive bug reports, fixes, documentation enhancements,
and other improvements.

Please report bugs via the
[github issue tracker](http://github.com/klangner/time-series-lab/issues).



# Redistributing

Hydra HTTP source code is distributed under the Apache-2.0 license.

**Contributions**

Unless you explicitly state otherwise, any contribution intentionally submitted
for inclusion in the work by you, as defined in the Apache-2.0 license, shall be
licensed as above, without any additional terms or conditions.
