from django.db import models

class PerfumeResult(models.Model):
    perfume_id = models.IntegerField(primary_key=True)
    title = models.TextField()
    
    def __str__(self):
        return self.title

# class QnA(models.Model):
#     season_gender_age = models.TextField()
#     daynight = models.TextField()
#     accords = models.TextField()
#     rating_score = models.TextField()

  
