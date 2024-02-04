class DynamometryTransformer(BaseEstimator, TransformerMixin):
    def fit(self, X, y=None):
        return self  # No fitting necessary

    def transform(self, X):
        X = X.copy()  # Work on a copy to avoid changing the original data
        # Dynamometry deficiency
        X['Dynamometry_Deficiency'] = ((X['Sex'] == 'M') & (X['Dynamometry'] < 47)) | \
                                      ((X['Sex'] == 'F') & (X['Dynamometry'] < 30))

        return X
