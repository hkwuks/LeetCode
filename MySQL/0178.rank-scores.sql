SELECT Score,dense_rank() OVER(ORDER BY Score DESC) 'Rank' FROM Scores