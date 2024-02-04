import pandas as pd
from sklearn.base import BaseEstimator, TransformerMixin
class CBCTransformer(BaseEstimator, TransformerMixin):
    def fit(self, X, y=None):
        return self 

    def transform(self, X):
        X = X.copy() 
        X['RBC_Deficiency'] = ((X['Sex'] == 'M') & (X['RBC'] < 4.35)) | \
                              ((X['Sex'] == 'F') & (X['RBC'] < 3.92))
        
        X['Hemoglobin_Deficiency'] = ((X['Sex'] == 'M') & (X['Hemoglobin'] < 13.2)) | \
                                     ((X['Sex'] == 'F') & (X['Hemoglobin'] < 11.6))
       
        X['Hematocrit_Deficiency'] = ((X['Sex'] == 'M') & (X['Hematocrit'] < 38.3)) | \
                                     ((X['Sex'] == 'F') & (X['Hematocrit'] < 35.5))
        
        X['Platelet_Abnormal'] = (X['Platelet'] < 135) | (X['Platelet'] > 317)

        return X
