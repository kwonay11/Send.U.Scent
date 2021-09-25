from django.db import models

class Perfume(models.Model):
    perfume_id = models.IntegerField(primary_key=True)
    title = models.CharField(max_length=100)
    
    def __str__(self):
        return self.title

# class QnA(models.Model):
#     season_gender_age = models.TextField()
#     daynight = models.TextField()
#     accords = models.TextField()
#     rating_score = models.TextField()

  
