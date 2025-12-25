# Currency Converter (Java)

A simple **Java-based Currency Converter** built using **IntelliJ IDEA**.  
It fetches live exchange rates via REST API calls and JSON parsing, demonstrating API integration, JSON handling, and clean CLI-based user interaction.

---

## Features
- Convert between multiple currencies (USD, CAD, EUR, HKD, INR)
- Real-time exchange rates via [Currency API](https://github.com/fawazahmed0/currency-api)
- Input validation to avoid invalid or duplicate conversions
- Clean formatted output (2 decimal places)
- Interactive CLI loop for multiple conversions

---

## Tech Stack
- **Java (Core Java)**
- **IntelliJ IDEA** (IDE for development & debugging)
- **HttpURLConnection** (Networking)
- **BufferedReader & InputStreamReader** (I/O)
- **HashMap & Scanner** (Collections & Input handling)
- **org.json.JSONObject** (JSON parsing)
- **DecimalFormat** (Output formatting)
- **External API** → [Fawaz Ahmed’s Currency API](https://github.com/fawazahmed0/currency-api)

---

## Sample output
- Welcome to Currency Converter!
- Currency Converting FROM?
- 1:USD  2:CAD  3:EUR  4:HKD  5:INR
- 1
- Currency Converting TO?
- 5
- Amount you wish to Convert?
- 100
- The value of 1 USD : 83.12 INR
- 100 USD = 8312.00 INR

---

## Future Improvements
- GUI Interface → Build a JavaFX/Swing-based UI for a more user-friendly experience
- Mobile App Integration → Extend functionality to Android using Java/Kotlin
- Performance Optimization → Switch from HttpURLConnection to modern libraries like OkHttp or Retrofit
- Expanded Currency Support → Add more currencies dynamically from the API
- Historical Data & Charts → Show past exchange trends using chart libraries
- Error Handling & Resilience → Improve exception handling, retry logic, and offline fallback
- Unit Testing → Add JUnit tests for validation and reliability
- Cloud Deployment → Host as a microservice (Spring Boot + REST API) for broader accessibility
- AI Integration → Predict currency trends using ML models

---

## Acknowledgements
- Fawaz Ahmed’s Currency API for providing free exchange rate data.
- IntelliJ IDEA for offering a powerful development environment to build and debug this project.
- The Java developer community for resources, tutorials, and guidance that inspired this project.

---

## 📂 How to Run
1. Clone this repository:
   ```bash
   https://github.com/Saravanakumar211402/Currency-Converter.git
