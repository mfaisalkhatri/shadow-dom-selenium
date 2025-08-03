## Don't forget to give a :star: to make the project popular.

## :question: What is this Repository about?

- This repo contains automation tests for Shadow DOM elements using Selenium WebDriver 4.
- This repo uses Maven as build tool and TestNG testing framework to run the tests.
- Google Chrome's Download Page has been used as a demo page to automate Shadow DOM elements.
- [Watir.com][watirwebsite]  has been used for automating the Shadow DOM elements.
- [LambdaTest Selenium Playground - Shadow DOM](https://www.lambdatest.com/selenium-playground/shadow-dom) is used
  for automating Shadow DOM elements.

## Running the Tests

By default, tests would be running on LambdaTest Platform.
If you want to run it on your local machine, please update the browser value in `testng.xml`for test name
`Shadow DOM Tests on Watir Website` to
`chrome` or `firefox` and you should be able to run it in local chrome or firefox respectively.

- To run the test from command line use the following command:

  `mvn clean install -DLT_USERNAME=<LambdaTest username> -DLT_ACCESSKEY=<LambdaTest access key>`

- To run the tests using TestNG:
    1. In the Run Configuration add the LambdaTest username and access key in the VM option as follows:
       `-DLT_USERNAME=<LambdaTest username> -DLT_ACCESSKEY=<LambdaTest access key>`
    2. Right-click on the `testng.xml` file and select `Run '...\testng.xml'`

## :writing_hand: Blog Links

- [How To Automate Shadow DOM In Selenium WebDriver?](https://medium.com/@iamfaisalkhatri/how-to-automate-shadow-dom-in-selenium-webdriver-lambdatest-blog-3884698b995)
- [How to Handle Shadow Root in Selenium Java](https://www.lambdatest.com/blog/shadow-root-in-selenium-java/)
- [How To Handle Shadow Root in Selenium Java](https://dzone.com/articles/how-to-handle-shadow-root-in-selenium-java)

🧬 Need Assistance?

- Discuss your queries by writing to me @ [mohammadfaisalkhatri@gmail.com][mail], or you can ping me on the following
  social media sites:
- Twitter: [mfaisal_khatri][twitter]
- LinkedIn: [Mohammad Faisal Khatri][linkedin]

## :thought_balloon: Checkout the blogs related to Software Testing and Test Automation on my [Medium][medium] blog

[mail]: mohammadfaisalkhatri@gmail.com

[linkedin]: https://www.linkedin.com/in/faisalkhatri/

[twitter]: https://twitter.com/mfaisal_khatri

[the-internet]: http://the-internet.herokuapp.com/

[medium]: https://medium.com/@iamfaisalkhatri

[watirwebsite]: http://watir.com/examples/shadow_dom.html