<<<<<<< HEAD
hi
=======

<h1>Finance and Budgeting App</h1>
 <h2>Introduction</h2>
           Building a financial management application that helps users track expenses, set budgets, and generate financial reports. 
 
<h2>Technology Used : </h2>
 
  <h3> 1. Terraform:   </h3>
           Used for EC2 instance creation.

   <h3> 2. AWS:   </h3>
            Used EC2 instances for a versatile and scalable infrastructure platform 
    
   <h3> 3. GitHub Actions:   </h3>
            Used For The CICD Pipeline.
 
<h2>Step:1 Terraform</h2>
Terraform is a tool for building, changing, and versioning infrastructure safely and efficiently. Follow these steps to install Terraform on your local machine:
<ol><li>Download the appropriate Terraform binary for your operating system from the <a href="https://developer.hashicorp.com/terraform/install">https://developer.hashicorp.com/terraform/install.</a></li>
<li>Extract the downloaded archive to a directory included in your system's PATH.</li>
<li>Verify the installation by running terraform version in your terminal. You should see the Terraform version printed to the console.</li></ol>
 For reference visit <a href="https://spacelift.io/blog/how-to-install-terraform">https://spacelift.io/blog/how-to-install-terraform</a>

 <h2>Step:2 AWS </h2>
          To Create EC2 instance
          The backend is deployed using EC2 instance and S3 bucket. The deployment process includes CI/CD pipelines for automated testing and deployment.
 

## Getting Started
 
These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

<h2>1.  Initialize Terraform:</h2>
Run the following command to initialize Terraform:
 
bash
Copy code
terraform init
Create a main.tf File:
Create a main.tf file in your project directory and add the following content:
 
hcl
Copy code
# main.tf
 
provider "aws" {
  region = "eu-west-1" # Update with your desired region
}
 
resource "aws_instance" "example_instance" {
  ami           = "ami-0c55b159cbfafe1f0" # Update with your desired AMI
  instance_type = "t2.micro"             # Update with your desired instance type
 
  tags = {
    Name = "example-instance"
  }
}
Adjust the region, ami, and instance_type based on your preferences. The tags block is optional but can be useful for identifying your instances.
 
<h2>2.  Plan and Apply:</h2>
Run the following commands to plan and apply the changes:
 
bash
Copy code
terraform plan
terraform apply
Confirm the changes by typing yes when prompted.
 
<h2>3. Verify Instance Creation:</h2>
Once the apply is complete, verify that your instance is created in the AWS Console or by using the AWS CLI.
 
 
Remember to replace the placeholder values in the Terraform configuration with your actual preferences, and ensure that your AWS credentials are configured on your machine.
Additionally, always be cautious when working with infrastructure provisioning, especially in production environments.
 
# Workflow Overview
This workflow will build a Java project with Maven, and cache/restore any dependencies to improve the workflow execution time
For more information see: https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-maven
This workflow uses actions that are not certified by GitHub.
They are provided by a third-party and are governed by
separate terms of service, privacy policy, and support
documentation.

    name: saveIt_backend CI/CD

    on:
    push:
      branches: [ "master" ]
    pull_request:
      branches: [ "master" ]
  
    jobs:
      build:

    runs-on: ubuntu-latest

    steps:
      - name: Checkout Repository
        uses: actions/checkout@v2

      - name: Set up JDK 21
        uses: actions/setup-java@v2
        with:
          java-version: '21'
          distribution: 'adopt'
          cache: maven
      - name: Build with Maven
        run: mvn clean install

      - uses: actions/checkout@v2
        with:
          repository: aws/aws-cli
          path: aws-cli
      - name: Install AWS CLI
        run: |
          sudo apt-get update
          sudo apt-get install -y awscli
        env:
          AWS_DEFAULT_REGION: 'eu-west-1'
          AWS_ACCESS_KEY_ID: ${{ secrets.AWS_ACCESS_KEY_ID }}
          AWS_SECRET_ACCESS_KEY: ${{ secrets.AWS_SECRET_ACCESS_KEY }}


      - name: AWS S3 Upload
        run: |
          aws configure set aws_access_key_id ${{ secrets.AWS_ACCESS_KEY_ID }}
          aws configure set aws_secret_access_key ${{ secrets.AWS_SECRET_ACCESS_KEY }}
          aws s3 ls
          pwd
          ls -a
          aws s3 cp "target/helloworld-0.0.1-SNAPSHOT.jar" s3://springboot-helloworld/
        env:
          AWS_DEFAULT_REGION: 'eu-west-1'

      - name: Copy JAR file to EC2
        uses: appleboy/scp-action@master
        with:
          host:  ${{ secrets.ELASTIC_IP }}
          username: ec2-user
          key: ${{ secrets.SSH_PRIVATE_KEY }}
          source: 'target/helloworld-0.0.1-SNAPSHOT.jar'
          target: '/home/ec2-user/helloworld-0.0.1-SNAPSHOT.jar'

      - name: SSH into EC2 and deploy
        uses: appleboy/ssh-action@master
        with:
          host:  ${{ secrets.ELASTIC_IP }}
          username: ec2-user
          key: ${{ secrets.SSH_PRIVATE_KEY }}
          script: |
            echo "Java process started."
            ls target
            nohup java -jar target/helloworld-0.0.1-SNAPSHOT.jar > output.log>&1 &
            echo "Java process started."

## Confluence 
<ul><li> <a href="https://bbd-nidhirudani.atlassian.net/wiki/spaces/~712020fd6e855c677a4607aa91c7562553b854/pages/4030466/SaveIt+Backend">Confluence</a></li> </ul>
>>>>>>> 86db96b4e94de4aa980aefc2752234262b835e0a
