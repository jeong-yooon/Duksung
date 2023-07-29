from bs4 import BeautifulSoup
import requests

with open('myHtml.html', 'r', encoding='utf8') as infile:
    html = infile.read()

soup = BeautifulSoup(html, 'html.parser')

print(soup)
print(soup.h1)
print(soup.find('h1'))

print(soup.div)
print('-----------------------------')
print(soup.find('div').find(class_='bland').find_all('li'))




