@echo off
cd /d %~dp0

echo Running Ivanti Automation Tests...
mvn clean test

pause