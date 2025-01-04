
# Vortex TSDB

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17+-brightgreen.svg)](https://www.oracle.com/java/)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-Compatible-brightgreen.svg)](https://spring.io/projects/spring-cloud)
[![Netty](https://img.shields.io/badge/Netty-Based-brightgreen.svg)](https://netty.io/)

Vortex TSDB (Time Series Database) is a highly scalable and flexible time series data storage solution built on **Java** and **Spring Cloud**. Designed to efficiently store and analyze time series data with fine granularity (down to 1-minute intervals), Vortex TSDB provides robust features for real-time monitoring, analytics, and large-scale data management. With its extensible architecture and integration capabilities, Vortex TSDB is a powerful tool for applications requiring precision and high...

---

## Key Features

### 1. Granular Time Series Data Storage
Vortex TSDB supports fine-grained data storage with a granularity of **1-minute intervals**, making it suitable for real-time analytics and precision monitoring. Key data types supported include:
- **Double**
- **Long**
- **Decimal**

These data types enable precise measurements and calculations tailored to diverse application needs.

---

### 2. Advanced Statistical Calculations
The database provides a comprehensive set of built-in statistical operations, enabling deep insights into time series data:
- **Maximum and Minimum Values**: Identify peaks and troughs in your data.
- **Average Values**: Calculate trends and patterns over time.
- **Variance**: Measure data variability for predictive analytics.
- **Baseline Comparisons**: Evaluate deviations from expected values.

These capabilities make Vortex TSDB a strong choice for applications requiring rich data analysis.

---

### 3. Flexible Storage Backends
- **Redis-Based Storage**: The current implementation leverages Redis for fast, in-memory storage, ensuring low-latency read and write operations.
- **Future-Ready Architecture**: Plans to support additional storage backends like **MySQL** or other databases, providing developers with flexibility to choose the optimal storage solution for their use case.

---

### 4. High Availability and Scalability
- **Built on Netty NIO**: Ensures efficient, non-blocking IO for high-throughput communication.
- **Horizontal Scalability**: Add more nodes to scale out the system seamlessly.
- **Fault Tolerance**: Designed for high availability to ensure consistent service delivery in distributed environments.

---

### 5. Built-in UI for Benchmarking
Vortex TSDB includes a **benchmark testing UI** to evaluate performance metrics such as throughput, latency, and resource utilization. This makes it easier for users to test, analyze, and optimize the database in their specific environments.

---

## Getting Started

### 1. Prerequisites
- **Java 17+**
- **Redis 7.x** (for storage backend)
- **Maven** (for building the project)

### 2. Clone the Repository
```bash
git clone https://github.com/paganini2008/vortex.git
cd vortex
```

### 3. Build and Run
```bash
mvn clean install
java -jar target/vortex-tsdb.jar
```

### 4. Access the UI
Navigate to `http://localhost:8080` to access the benchmark testing UI and explore the database capabilities.

---

## Documentation
For detailed documentation, API reference, and advanced configuration, visit the [Official Documentation](https://github.com/paganini2008/vortex/wiki).

---

## Contributing
We welcome contributions! Check out the [Contributing Guide](CONTRIBUTING.md) for more information on how to get involved.

---

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Vortex TSDB combines precision, scalability, and extensibility to deliver a cutting-edge time series database solution. Whether for real-time monitoring, predictive analytics, or large-scale data management, Vortex TSDB provides the tools and flexibility you need to succeed.
