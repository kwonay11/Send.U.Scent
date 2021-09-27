from django.db import models
#퍼퓸 
# class Perfume(models.Model):
#     perfume_id = models.IntegerField(primary_key=True)
#     title = models.CharField(max_length=100) 
#     brand = models.CharField(max_length=50) 
#     accords = models.CharField(max_length=100)
#     gender = models.CharField(max_length=10)
#     longevity = models.IntegerField()
#     sillage = models.IntegerField() 
#     daynight = models.IntegerField() 
#     top = models.CharField(max_length=300, blank=True, null=True)
#     middle = models.CharField(max_length=300, blank=True, null=True)
#     base = models.CharField(max_length=300, blank=True, null=True)
#     rating_score = models.FloatField()
#     votes = models.IntegerField()

#     def __str__(self):
#         return self.title



class PerfumeResult(models.Model):
    perfume_id = models.IntegerField(primary_key=True)
    # title = models.CharField()
    
    def __str__(self):
        return self.title

# class QnA(models.Model):
#     season_gender_age = models.TextField()
#     daynight = models.TextField()
#     accords = models.TextField()
#     rating_score = models.TextField()

  
