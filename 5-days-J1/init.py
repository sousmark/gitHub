import pandas as pd
import world_bank_data as wb
from sqlalchemy import create_engine
import mysql.connector
import pymysql

engine = create_engine('mysql+pymysql://id:Root123*@db-world-bank.mysql.database.azure.com/database')

df = pd.DataFrame(data=wb.get_topics(),
		columns=['value','sourceNote'])

conn = pymysql.connect(user='id',
                       password='Root123*',
                       database='worldbank',
                       host='db-world-bank.mysql.database.azure.com',
                       ssl={'ca': 'DigiCertGlobalRootCA.crt.pem'})

cur = conn.cursor()

for i in df.index:
  sql = "INSERT INTO topic (id, value, sourceNote) VALUES (%s, %s, %s)"
  value = (i, df["value"][i], df["sourceNote"][i])
  cur.execute(sql, value)


conn.commit()
