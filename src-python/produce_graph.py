import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot

from matplotlib.dates import DateFormatter
formatter = DateFormatter('%Y-%m-%d')



import sys
from pylab import *
import MySQLdb

db = MySQLdb.connect(host="localhost", user="guycorlett", passwd="password", db="weather_measurements")
cursor = db.cursor()

# Python does not seem to be selecting all 30 data points
query = "SELECT * FROM (SELECT * FROM measurements ORDER BY measurement_id DESC LIMIT 50) sub ORDER BY measurement_id ASC"

cursor.execute(query)
result = cursor.fetchall()

time = []
temperature = []

for record in result:
  time.append(record[1])
  temperature.append(record[2])

# Next two lines are to debug why plot is not showing all data points
print(len(time))
print(len(temperature))


plot_date(time, temperature, fmt='ro-', tz=None, xdate=True,
          ydate=False, label='Temperature', linewidth=2)
# Need to correct this for correct limits
axis([min(time), max(time), min(temperature)-5, max(temperature)+5])
title("Fridge conditions - last 50 measurements")
gcf().axes[0].xaxis.set_major_formatter(formatter)
gcf().autofmt_xdate()
# The following line could be used to only show major x tick lines at Sundays (i.e. week by week)
# Might need to be implemented when get 50+ data points....
# gcf().axes[0].xaxis.set_major_locator(matplotlib.dates.WeekdayLocator(byweekday=matplotlib.dates.SU))
xlabel("Date")
ylabel("Temperature")

grid(True)



F = gcf()
DPI = F.get_dpi()

F.savefig('/home/ubuntu/workspace/HTML/Graphs/plot.png',dpi = (100))