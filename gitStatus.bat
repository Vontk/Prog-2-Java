@echo off
title Git Status

cd "C:\path\to\your\repository"
git add .
git commit -m "Your commit message"

:loop
git status
pause
goto loop