**Job Scheduler**

This project is a Job Scheduling system written in Java and built with Maven.
It consists of the following components:

1. **Job**: Represents a task to be executed. It includes a unique ID, task description, and a method to execute.
2. **Trigger**: Determines when and how a job is executed. Triggers can be time-based or event-based.
3. **Scheduler**: Manages jobs and their triggers, ensuring timely execution based on trigger conditions.
4. **Execution Context**: Provides a runtime environment for job execution, managing concurrency and resource allocations.
5. **Logging & Monitoring**: Includes logging mechanisms to track job execution and monitoring functionalities to ensure system health.

### Flow chart
```
  Client      JobScheduler       Trigger     Job     ExecutionContext  Monitoring/Logging
   │1. Add job    │                 │         │           │                  │
   ├─────────────>│2. Set trigger   │         │           │                  │
   │              ├────────────────>│         │           │                  │
   │              │3. Schedule job  │         │           │                  │
   │              ├─────────────────┼────────>│           │                  │
   │              │4. Check trigger │         │           │                  │
   │              ├────────────────>│         │           │                  │
   │              │5. Is triggered  │         │           │                  │
   │              │<────────────────┤         │           │                  │
   │              │6. Execute job   │         │           │                  │
   │              ├─────────────────┼─────────┼──────────>│                  │
   │              │7. Log execution │         │           │                  │
   │              ├─────────────────┼─────────┼───────────┼─────────────────>│
   │8. Return info│                 │         │           │                  │
   │<─────────────┤                 │         │           │                  │  
   │              │                 │         │           │                  │
```

### Project Structure
```
  src/
  └── main/
      ├── java/
      │   └── org/
      │       └── job/
      │           └── Main.java
      │           └── jobscheduler/
      │               ├── model/
      │               │   ├── Job.java
      │               │   └── Trigger.java
      │               ├── scheduler/
      │               │   ├── ExecutionContext.java
      │               │   ├── JobScheduler.java
      │               │   └── ...
      │               └── util/
      │                   └── Logging.java
      └── resources/
```

### Getting Started
To get started with the Job Scheduler project, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/job-scheduler.git
   ```
2. Navigate to the project directory:
   ```bash
   cd scheduler
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

### Usage
Once the project is set up, you can start using the Job Scheduler in your Java applications:

1. Add the Job Scheduler library to your project dependencies.
2. Create instances of jobs and triggers according to your requirements.
3. Schedule jobs with triggers using the Scheduler component.
4. Monitor job execution and system health using the provided logging and monitoring functionalities.

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for any improvements or bug fixes.