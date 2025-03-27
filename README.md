# Spring LangChain4j AI Integration

This project is an implementation of an AI service using **Spring Boot** and **LangChain4j** to integrate an AI agent capable of responding to user queries.

## Prerequisites
- Java 21+
- Maven 3.4.4+
- An OpenAI API key (if using GPT)

## Installation
Clone the repository and navigate to the project directory:
```sh
git clone https://github.com/your-repo/spring-langchain4j-ai-integration.git
cd spring-langchain4j-ai-integration
```



## Configuration
Add your OpenAI API key in `application.yml`:
```properties
langchain4j:
    open-ai:
        chat-model:
            api-key: OPENAI_API_KEY
            model-name: MODEL_TO_USE
```


## Deployment
Build the application with:
```sh
mvn clean install
```

Run the application with:
```sh
mvn spring-boot:run
```

Access the endpoint:
```
GET http://localhost:8080/api/ai/chat?question=Hello
```

## Author
- **Your Name** - YAZID El Mehdi


