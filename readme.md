![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)

## Don't forget to give a :star: to make the project popular.

## :question: What is this Repository about?

- This repo contains automation tests for Shadow DOM elements using Selenium WebDriver 4.
- This repo uses Maven as build tool and TestNG testing framework to run the tests.
- Google Chrome's Download Page has been used as a demo page to automate Shadow DOM elements.

## Running the Tests

By default, tests would be running on LambdaTest Platform. 
If you want to run it on your local machine, please update the browser value in `testng.xml` to `chrome` or 
`firefox` and you should be able to run it in local chrome or firefox respectively.

- To run the test from command line use the following command:

    `mvn clean install -Dusername=<LambdaTest username> -DaccessKey<LambdaTest access key>`

- To run the tests using TestNG: 
  1. In the Run Configuration add the LambdaTest username and access key in the VM option as follows:
      `-Dusername=<LambdaTest username> -DaccessKey<LambdaTest access key>`
  2. Right-click on the `testng.xml` file and select `Run '...\testng.xml'` 

🧬 Need Assistance?

- Discuss your queries by writing to me @ [mohammadfaisalkhatri@gmail.com][mail], or you can ping me on the following
  social media sites:
- Twitter: [mfaisal_khatri][twitter]
- LinkedIn: [Mohammad Faisal Khatri][linkedin]

## :thought_balloon: Checkout the blogs related to Testing on my [website][] and [medium-account][medium]

[mail]: mohammadfaisalkhatri@gmail.com

[linkedin]: https://www.linkedin.com/in/faisalkhatri/

[twitter]: https://twitter.com/mfaisal_khatri

[lambdawebsite]:https://www.lambdatest.com/

[the-internet]: http://the-internet.herokuapp.com/

[website]: https://mfaisalkhatri.github.io

[medium]: https://medium.com/@iamfaisalkhatri